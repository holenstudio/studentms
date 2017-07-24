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
s
function delete(id) {
    window.location.reload("delete?id=" + id);
}

function update(id){
    window.location.reload("update?id=" + id);
}