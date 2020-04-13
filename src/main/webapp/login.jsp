<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/22
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
    <title>登录</title>

</head>
<body>
<script type="text/javascript">
  /*  $(function () {
        window.location.href="menu.jsp";
    })*/


</script>
<form id="login" action="${pageContext.request.contextPath}/emp/login"  method="post" >
    <input type="text" name="name">
    <br>
    <input type="password" name="pass">
    <input type="button" value="登录" onclick="login()">

</form>
<script type="text/javascript">

    function login(){
        $("#login").submit();

    }
</script>
</body>
</html>
