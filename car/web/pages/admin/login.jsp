<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>young帆管理员登录页面</title>
    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>

    <script type="text/javascript">
        // 页面加载完成之后
        $(function () {
            // 给登录绑定单击事件
            $("#sub_btn").click(function () {

                //验证管理员名称和密码
                // var usernameText = document.getElementById("username");
                var usernameText = $("#username").val();
                var passwordText = $("#password").val();

                if (usernameText != "admin" || passwordText != "admin") {
                    //提示结果
                    $("span.errorMsg").text("管理员名称或密码不正确!");

                    return false;
                }
                // 去掉错误信息
                $("span.errorMsg").text("");
            });

        });

    </script>

</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" width="150" height="80" src="static/img/logo.jpg">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>young帆管理员</h1>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
                        ${ empty requestScope.msg ? "请输入管理员名称和密码":requestScope.msg }
                    </span>
                </div>
                <div class="form">
                    <form action="${pageContext.request.contextPath}/pages/manager/manager.jsp" method="post">
                        <input type="hidden" name="action" value="login"/>
                        <label>管理员名称：</label>
                        <input class="itxt" type="text" placeholder="请输入管理员名称"
                               autocomplete="off" tabindex="1" name="username" id="username"
                               value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        &nbsp;&nbsp;
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password"/>
                        <br/>
                        <br/>
                        <input type="submit" value="登录" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>


</body>
</html>