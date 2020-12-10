import Vue from 'vue'
import Router from 'vue-router'
import UserManage from '../views/UserManage'
import AddUser from '../views/AddUser'
import UpdateUser from '../views/UpdateUser'
import bootstraptest from '../views/bootstraptest'
import Index from '../views/index'
Vue.use(Router)

export default new Router({
  routes:  [
    {
      path:"/bootstraptest",
      name:"bootstrap测试",
      component:bootstraptest
    },

    {
      path:"/",
      name:"管理",
      component: Index,
      redirect:"/UserManage",
      children: [
        {path:"/UserManage",
          name:"用户管理",
          component:UserManage
        },
        {
          path:"/AddUser",
          name:"添加用户",
          component:AddUser
        },
        {
          path:"/UpdateUser",
          component:UpdateUser
        }
      ],
    },

  ]
})
