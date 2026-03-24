import Vue from "vue"
import Router from "vue-router"
//配置页面路由
import Main from "../views/Main";
import Logs from "../views/Logs";
import personInfo from "../views/personInfo";
import login from "../views/login";
import home from "../views/home";
import data from "../views/data";

Vue.use(Router);

export default new Router({

  routes:[
    {
      //路由路径
      path: '/home',
      //路径的组件
      component: home,
      name: home,
      children:[
        {
          //路由路径
          path: '/main',
          //路径的组件
          component: Main,
          name: Main,

        },
        {
          //路由路径
          path: '/logs',
          //路径的组件
          component: Logs,
          name: Logs
        },
        {
          //路由路径
          path: '/personInfo',
          //路径的组件
          component: personInfo,
          name: personInfo
        },{
          //路由路径
          path: '/data',
          //路径的组件
          component: data,
          name: data
        }
      ]

    },
    {
      //路由路径
      path: '/',
      //路径的组件
      component: login,
      name: login,
      redirect: '/login'
    },
    {
      //路由路径
      path: '/login',
      //路径的组件
      component: login,
      name: login
    }
  ]
})
