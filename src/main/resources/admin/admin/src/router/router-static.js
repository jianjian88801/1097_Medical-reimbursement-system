import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import biaoxiaodan from '@/views/modules/biaoxiaodan/list'
    import caikuai from '@/views/modules/caikuai/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import lingdao from '@/views/modules/lingdao/list'
    import yonghu from '@/views/modules/yonghu/list'
    import dictionaryBiaoxiaodanBingqing from '@/views/modules/dictionaryBiaoxiaodanBingqing/list'
    import dictionaryBiaoxiaodanRenyuan from '@/views/modules/dictionaryBiaoxiaodanRenyuan/list'
    import dictionaryBiaoxiaodanYesno from '@/views/modules/dictionaryBiaoxiaodanYesno/list'
    import dictionaryBiaoxiaodanYiliaofeiyong from '@/views/modules/dictionaryBiaoxiaodanYiliaofeiyong/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryBiaoxiaodanBingqing',
        name: '病情',
        component: dictionaryBiaoxiaodanBingqing
    }
    ,{
        path: '/dictionaryBiaoxiaodanRenyuan',
        name: '人员状态',
        component: dictionaryBiaoxiaodanRenyuan
    }
    ,{
        path: '/dictionaryBiaoxiaodanYesno',
        name: '审核状态',
        component: dictionaryBiaoxiaodanYesno
    }
    ,{
        path: '/dictionaryBiaoxiaodanYiliaofeiyong',
        name: '费用类型',
        component: dictionaryBiaoxiaodanYiliaofeiyong
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }


    ,{
        path: '/biaoxiaodan',
        name: '报销单',
        component: biaoxiaodan
      }
    ,{
        path: '/caikuai',
        name: '财会审核人员',
        component: caikuai
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/lingdao',
        name: '领导',
        component: lingdao
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
