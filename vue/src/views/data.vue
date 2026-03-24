<template>
  <div id="app">
<!--    <el-row :gutter="24">
      <el-col :span="12">
        <el-card>
          <div id="main" style="width:600px;height:400px"></div>
        </el-card>
      </el-col>
      <el-col :span="12">
      </el-col>
    </el-row>-->
    <div>
      <el-card>
      <iframe src="http://2019ncov.chinacdc.cn/2019-nCoV/" id="mobsf" scrolling="no" frameborder="0" style="position:absolute;top:64px;left: 240px;right:0px;bottom:100px;"></iframe>
      </el-card>
    </div>
  </div>
</template>

<script>
const echarts = require('echarts');
import axios from "axios";
import Cookies from "js-cookie";

export default {
  computed: {
    showUsername() {
      return Cookies.get("username")
    }
  },
  data() {
    return {
      option: {
        title: {
          text: '时间曲线图'
        },
        xAxis: {
          type: 'category',
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun',]
        },
        yAxis: {
          type: 'value'
        },
        tooltip: {
          trigger: 'axis'
        },
        series: [{
          data: [820, 932, 901, 934, 1290, 1330, 1320],
          type: 'line',
          smooth: true
        }]
      }
    };
  },
  methods: {
    drawPid(id) {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById("main"));
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(this.option);
      console.log(this.showUsername)
      axios.get('http://localhost:8088/signinfo/data', {
        params: {
          username: this.showUsername
        }
      }).then((result) => {
        console.log(result.data)
      })
    },


  },
  mounted() {
    this.$nextTick(function () {
      this.drawPid("main");
    });
    function changeMobsfIframe(){
      const mobsf = document.getElementById('mobsf');
      const deviceWidth = document.body.clientWidth;
      const deviceHeight = document.body.clientHeight;
      mobsf.style.width = (Number(deviceWidth)-240) + 'px'; //数字是页面布局宽度差值
      mobsf.style.height = (Number(deviceHeight)-64) + 'px'; //数字是页面布局高度差
    }

    changeMobsfIframe()

    window.onresize = function(){
      changeMobsfIframe()
    }
  }
};

</script>

<style scoped>

</style>