import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from "axios";
const echarts = require('echarts');
Vue.config.productionTip = false
import BaiduMap from 'vue-baidu-map'

Vue.use(BaiduMap, {
    ak: '0DrtYPtBoQjRR88fiGIE8iJZLD1D4gqD'
})
Vue.use(echarts)
Vue.use(router)
Vue.use(ElementUI)
Vue.prototype.axios = axios

// 添加响应拦截器
axios.interceptors.response.use(function (response) {
    return response;
}, function (error) {
    ElementUI.Notification({
        title: '错误',
        message: '连接服务器失败',
        type: 'error'
    })
    /*//Message 消息提示
    ElementUI.Message({
      message: '恭喜你，这是一条成功消息',
      type: 'success'
    });*/
    return Promise.reject(error);
});

Vue.directive('title', {
    inserted: function (el, binding) {
        document.title = el.dataset.title
    }
})

new Vue({
    el: '#app',
    router,
    render: h => h(App)
})
