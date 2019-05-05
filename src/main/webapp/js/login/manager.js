
//数据的非空验证
function  isEmpty(name) {
    if(name.length==0)
        return true;
    else
        return false;
}
//员工号表达式验证
function match(empno) {
    var empNoTest=/^[0-9a-zA-Z]+$/;
    return empNoTest.test(empno)

}
//真实姓名验证
function testRealname(realname) {
    var real=/^[\u4E00-\u9FA5]{1,5}$/;
    return real.test(realname);
}
//员工号长度验证
function testLength(empno){
    if(empno.length!=8)
        return false;
    else
        return true;
}
//用户名唯一验证
function uniqueTest(userName) {
   var data=$("#online").bootstrapTable('getData');
    for(var i=0;i<data.length;i++){
       if(userName==data[i].username){
           return true;
       }if(userName==data[i].telephone){
           return true;
        }
    }
    return false;
}
//手机号唯一验证
function uniqueTestTel(tel) {
    var data=$("#online").bootstrapTable('getData');
    for(var i=0;i<data.length;i++){
      if(tel==data[i].telephone){
            return true;
        }
    }
    return false;
}
//手机号验证
function testTel(tel){
    var testTel=/^1(3|4|5|7|8)\d{9}$/;
    return testTel.test(tel);
}
//管理员员工账号的唯一验证
function adminUnique(empno){
   var data=$("#offline").bootstrapTable('getData');
   for(var i=0;i<data.length;i++){
       if(empno==data[i].adminname){
           return true;
       }
   }
   return false;
}
//编辑用户信息时唯一验证
function editUnique(username){
    var data=$("#online").bootstrapTable('getData');
    var counter=0;//计数器，

    for(var i=0;i<data.length;i++){
        if(username==data[i].username){
            counter++;
        }
        if(username==data[i].telephone){
            counter++;
        }
    }
    if(counter==2){
        return true;
    }else {
        return false;
    }
}
//编辑时手机号码唯一验证
function editTestTEl(tel){
    var data=$("#online").bootstrapTable('getData');
    var counter=0;//计数器，

    for(var i=0;i<data.length;i++){

        if(tel==data[i].telephone){
            counter++;
        }
    }
    if(counter==2){
        return true;
    }else {
        return false;
    }
}
//密码长度验证，不能小于八位
function testPassword(password){
   var testword=/^[a-zA-Z]\w{5,17}$/;
   return testword.test(password);
}
//员工号长度验证必须位八位，而且是全数字
function  testEmpno(empno){
    if (empno.length == 8) {
        return false;
    }
    else
        return true;

}
//员工号数字验证
function testEmpnoNumber(empno){
    var testEmpno=/^[0-9]*$/;
    return testEmpno.test(empno);
}
//管理员手机号唯一验证
function testAdminTel(tel) {
    var adminTelData=$("#offline").bootstrapTable('getData');
    for(var i=0;i<adminTelData.length;i++){
        if(tel==adminTelData.telephone){
            return true;
        }
    }
    return false;

}
//编辑时管理员手机号唯一验证
function editAdminTel(tel){
    var data=$("#offline").bootstrapTable('getData');
    var counter=0;//计数器，

    for(var i=0;i<data.length;i++){

        if(tel==data[i].telephone){
            counter++;
        }
    }
    if(counter==2){
        return true;
    }else {
        return false;
    }
}
//编辑时管理员号唯一验证
function editAdminName(tel){
    var data=$("#offline").bootstrapTable('getData');
    var counter=0;//计数器，

    for(var i=0;i<data.length;i++){

        if(tel==data[i].adminname){
            counter++;
        }
    }
    if(counter==2){
        return true;
    }else {
        return false;
    }
}
