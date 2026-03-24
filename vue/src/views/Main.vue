<template>
  <div>
    <el-card>
      <el-form :inline="true" :model="mapLocation" :rules="rules" ref="mapLocation" class="demo-form-inline"
               style="height: 40px">
        <el-form-item label="地址" prop="address">
          <el-input
              v-model="mapLocation.address"
              placeholder="点击下方“定位”按钮自动获取地址"
              style="width: 300px"
              disabled
              prop="address"
          >
            <el-button slot="append" icon="el-icon-location" @click="getLocation">定位</el-button>
          </el-input>
        </el-form-item>
        <el-form-item label="时间" prop="temperature">
          <el-input placeholder="自动获取当前时间" style="width: 300px" v-model="mapLocation.temperature" disabled>
          </el-input>
        </el-form-item>
        <el-form-item label="打卡日期" prop="date">
          <el-date-picker
              v-model="mapLocation.date"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit('mapLocation')">提交</el-button>
        </el-form-item>
      </el-form>
    </el-card>
    <el-card>
      <div class="app-container">
        <div style="margin: 5px">
          <baidu-map class="bm-view" :center="mapCenter" :zoom="mapZoom" :scroll-wheel-zoom="true"
                     @ready="handlerBMap" :mapStyle="mapStyle">
            <bm-navigation anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-navigation>
            <bm-map-type :map-types="['BMAP_NORMAL_MAP', 'BMAP_HYBRID_MAP']" anchor="BMAP_ANCHOR_TOP_LEFT"></bm-map-type>
            <bm-scale anchor="BMAP_ANCHOR_BOTTOM_LEFT"></bm-scale>
            <bm-geolocation anchor="BMAP_ANCHOR_BOTTOM_RIGHT" :showAddressBar="true"
                            :autoLocation="true"></bm-geolocation>
          </baidu-map>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
import BaiduMap from 'vue-baidu-map/components/map/Map.vue'
import axios from "axios";
import Cookies from "js-cookie";

export default {
  name: 'Main',
  components: {
    BaiduMap
  },
  data() {
    return {
      mapZoom: 15,
      mapCenter: {lng: 0, lat: 0},
      mapLocation: {
        address: undefined,
        coordinate: undefined,
        date: '',
        temperature: '',
      },
      rules: {
        date: [
          {required: true, message: '请选择日期', trigger: 'blur'}
        ],
        address: [
          {required: true, message: '请输入您的地址', trigger: 'blur'}
        ],
      }
    }
  },
  computed: {
    showUsername() {
      return Cookies.get("username")
    }
  },
  mounted() {
    // 自动获取当前系统时间
    const now = new Date();
    const hours = String(now.getHours()).padStart(2, '0');
    const minutes = String(now.getMinutes()).padStart(2, '0');
    const seconds = String(now.getSeconds()).padStart(2, '0');
    this.mapLocation.temperature = `${hours}:${minutes}:${seconds}`;
    // 自动获取当前日期
    const year = now.getFullYear();
    const month = String(now.getMonth() + 1).padStart(2, '0');
    const day = String(now.getDate()).padStart(2, '0');
    this.mapLocation.date = `${year}-${month}-${day}`;
  },
  methods: {
    handlerBMap({BMap, map}) {
      this.BMap = BMap
      this.map = map
      if (this.mapLocation.coordinate && this.mapLocation.coordinate.lng) {
        this.mapCenter.lng = this.mapLocation.coordinate.lng
        this.mapCenter.lat = this.mapLocation.coordinate.lat
        this.mapZoom = 15
        map.addOverlay(new this.BMap.Marker(this.mapLocation.coordinate))
      } else {
        this.mapCenter.lng = 116.404
        this.mapCenter.lat = 39.915
        this.mapZoom = 10
      }
    },
    getLocation() {
      if (!this.BMap) {
        this.$message({
          message: '地图尚未加载完成，请稍后重试',
          type: 'warning'
        });
        return;
      }
      var that = this;
      var geolocation = new this.BMap.Geolocation();
      geolocation.enableSDKLocation();
      geolocation.getCurrentPosition(function(r) {
        if (this.getStatus() == 0) {
          var point = r.point;
          that.mapLocation.coordinate = point;
          that.makerCenter(point);
          // 逆地理编码：坐标转地址
          var geocoder = new that.BMap.Geocoder();
          geocoder.getLocation(point, function(result) {
            if (result) {
              that.mapLocation.address = result.address;
            }
          });
        } else {
          that.$message({
            message: '定位失败，请检查浏览器定位权限',
            type: 'error'
          });
        }
      }, {enableHighAccuracy: true});
    },
    querySearch(queryString, cb) {
      var that = this
      var myGeo = new this.BMap.Geocoder()
      myGeo.getPoint(queryString, function (point) {
        if (point) {
          that.mapLocation.coordinate = point
          that.makerCenter(point)
        } else {
          that.mapLocation.coordinate = null
        }
      }, this.locationCity)
      var options = {
        onSearchComplete: function (results) {
          if (local.getStatus() === 0) {
            // 判断状态是否正确
            var s = []
            for (var i = 0; i < results.getCurrentNumPois(); i++) {
              var x = results.getPoi(i)
              var item = {value: x.address + x.title, point: x.point}
              s.push(item)
              cb(s)
            }
          } else {
            cb()
          }
        }
      }
      var local = new this.BMap.LocalSearch(this.map, options)
      local.search(queryString)
    },
    handleSelect(item) {
      var {point} = item
      this.mapLocation.coordinate = point
      this.makerCenter(point)
    },
    makerCenter(point) {
      if (this.map) {
        this.map.clearOverlays()
        this.map.addOverlay(new this.BMap.Marker(point))
        this.mapCenter.lng = point.lng
        this.mapCenter.lat = point.lat
        this.mapZoom = 15
      }
    },
    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.post('http://localhost:8088/signinfo/punch', {
            temperature: this.mapLocation.temperature,
            username: this.showUsername,
            date: this.mapLocation.date,
            address: this.mapLocation.address
          }).then((result) => {
            console.log(result.data)
            if (result.data === "success") {
              this.$message({
                message: '打卡成功',
                type: 'success'
              });
              this.mapLocation = ''
            }
          })
        } else {
          return false
        }
      })
    }
  }
}
</script>

<style>
.bm-view {
  width: 100%;
  height: 300px;
}
</style>
