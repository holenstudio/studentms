$(document).ready(function(){
    $("#commit").click(function(){
        var username = $("input[name='username']").val();
        var password = $("input[name='password']").val();
        if (username.length < 1) {
            alert("用户名不能为空");
            return;
        }
        if (password.length < 1) {
            alert("密码不能为空");
            return;
        }

    });
});