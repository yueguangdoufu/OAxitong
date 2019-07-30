<%--
  Created by IntelliJ IDEA.
  User: Acer-1
  Date: 2018/6/5
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="layui/login/login.css">
</head>
<body>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>OA 系统</h2>
            <p>系统简介</p>
        </div>
        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
                <input type="text" name="username" id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
                <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
            </div>

            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="LAY-user-login-submit">登 入</button>
            </div>
        </div>
    </div>
</div>
<script src="layui/layui.js"></script>
<script>
    layui.use(['form'],function(){
        var $ = layui.$
            ,form = layui.form
            ,layer = layui.layer;

        form.render();//更新全部

        //提交
        form.on('submit(LAY-user-login-submit)', function(obj){
            $.ajax({
                url:'/login' //实际使用请改成服务端真实接口
                ,data:obj.field
                ,type:'post'
                ,success:function(res){
                    res = JSON.parse(res);//把字符串转换成json对象
                    if (res.code == 200) {
                        //登入成功的提示与跳转
                        layer.msg('登入成功', {
                            offset: '15px'
                            ,icon: 1
                            ,time: 1000
                        }, function(){
                            location.href = "main.html"; //后台主页
                        });
                    } else {
                        layer.msg(res.msg, {
                                offset: '15px'
                                ,icon: 1
                                ,time: 1000
                        });
                    }

                }
            });
        });
    });

    if (top != self) {
        window.top.location.href = window.location.href;
    }
</script>
</body>
</html>
