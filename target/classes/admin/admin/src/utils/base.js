const base = {
    get() {
        return {
            url : "http://localhost:8080/yiliaobaoxiaoxitong/",
            name: "yiliaobaoxiaoxitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/yiliaobaoxiaoxitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "医疗报销系统"
        } 
    }
}
export default base
