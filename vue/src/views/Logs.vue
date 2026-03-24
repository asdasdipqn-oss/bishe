<template>
  <el-main>
    <el-card>
      <el-form :inline="true" :model="pageInfo" ref="pageInfo" class="demo-form-inline">
        <el-form-item label="姓名" prop="username" v-show="admin">
          <el-input v-model="pageInfo.username" placeholder="姓名"></el-input>
        </el-form-item>
        <el-form-item label="打卡地址" prop="address">
          <el-input v-model="pageInfo.address" placeholder="打卡地址"></el-input>
        </el-form-item>
        <el-form-item label="打卡日期" prop="date">
          <el-date-picker
              :value="[pageInfo.startTime, pageInfo.endTime]"
              type="daterange"
              align="right"
              unlink-panels
              range-separator="至"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
              value-format="yyyy-MM-dd"
              :picker-options="pickerOptions"
              @input="handleFilterDateRangeChange($event)">
          </el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">查询</el-button>
          <el-button @click="resetForm('pageInfo')">重置</el-button>
        </el-form-item>
      </el-form>
      <el-table
          :data="this.records"
          style="width: 100%"
          v-loading="loading"
          :row-class-name="tableRowClassName">
        <el-table-column
            prop="date"
            label="日期"
            width="180">
        </el-table-column>
        <el-table-column
            prop="username"
            label="姓名"
            width="180">
        </el-table-column>
        <el-table-column
            prop="temperature"
            label="时间"
            width="180">
        </el-table-column>
        <el-table-column
            prop="address"
            label="打卡地址">
        </el-table-column>
      </el-table>
    </el-card>
    <el-card>
      <el-pagination
          @current-change="handleCurrentChange"
          :current-page="this.pageInfo.page"
          :page-size="5"
          layout="total, prev, pager, next, jumper"
          :total="pageinfo.total">
      </el-pagination>
    </el-card>
  </el-main>
</template>

<style>
.el-table .warning-row {
  background: oldlace;
}

.el-table .danger-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
</style>

<script>
import axios from "axios";
import Cookies from "js-cookie";
export default {
  computed: {
    showUsername() {
      return Cookies.get("username")
    }
  },
  methods: {
    handleCurrentChange(val) {
      this.handleSelect(val);
      console.log('当前页: ' + val);
    },
    tableRowClassName({row, rowIndex}) {
      if (row.temperature >= 36.7) {
        return 'danger-row';
      } else if (row.temperature <= 36.7) {
        return 'success-row';
      }
      return '';
    },
    /*handleSelect(current, select) {
      axios.get('http://localhost:8088/signinfo/findAll/' + current + '/5/' + select).then(res => {
        this.records = res.data.records;
        this.pageinfo = res.data;
        // console.log(res.data.records)
        // console.log(res.data)
      })
    },*/
    handleSelect(current) {
      if (current) {
        this.pageInfo.page = current
      }
      this.loading = true
      axios.post('http://localhost:8088/signinfo/findAll1', {
        page:this.pageInfo.page,
        size:this.pageInfo.size,
        address:this.pageInfo.address,
        username:this.pageInfo.username,
        total:this.pageInfo.total,
        startTime:this.pageInfo.startTime,
        endTime:this.pageInfo.endTime,
      }).then(res => {
        this.records = res.data.records;
        this.pageinfo = res.data;
        // console.log(res.data.records)
        // console.log(res.data)
      }).finally(() => {
        this.loading = false
      })
    },
    onSubmit() {
      this.handleSelect(1)
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
      this.pageInfo.startTime = '';
      this.pageInfo.endTime = '';
    },
    handleFilterDateRangeChange(e) {
      this.$nextTick(() => {
        if (!e) {
          this.pageInfo[`startTime`] = ''
          this.pageInfo[`endTime`] = ''
        } else {
          this.pageInfo[`startTime`] = e[0];
          this.pageInfo[`endTime`] = e[1];
        }
      })
    },
  },
  created() {
    if (this.showUsername==="佐佳豪"){
      this.admin = true
      this.pageInfo.username = ''
    }else {
      this.pageInfo.username = this.showUsername
    }
    this.handleSelect(1);
  },
  data() {
    return {
      admin: false,
      loading: false,
      records: [],
      pageinfo: {},
      pageInfo: {
        address: '',
        username: '',
        current: '',
        startTime: '',
        endTime: '',
        page: '1',
        size: '5',
        total: ''
      },
      pickerOptions: {
        shortcuts: [{
          text: '最近一周',
          onClick(picker) {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '最近一个月',
          onClick(picker) {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '最近三个月',
          onClick(picker) {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
            picker.$emit('pick', [start, end]);
          }
        }]
      }
    }
  }
}
</script>
