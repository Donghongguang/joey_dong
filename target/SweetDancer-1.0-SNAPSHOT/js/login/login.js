$("#loginbutton").click(function () {
     $.ajax({
         type:'get',
         url:'loginUser',
         data:{
             "username":$("#userName").val(),
             "password":$("#inputPassword").val(),
             "type":$("input[name='usertype']:checked").val()
         },
         success:function (d) {
             if(d==0){
                 alert("查无此人")
             }else if(d==1){
                 alert("登陆成功");
                 window.location.href="manage.html";
             }else if(d==2){
                 alert("密码不正确");
             }else{
                alert("输入信息有误");
             }
         }
     })

});