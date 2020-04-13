<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/28
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>回复页面</title>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/utf8-jsp/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/utf8-jsp/lang/zh-cn/zh-cn.js"></script>

    <script type="application/javascript">
        var ue = UE.getEditor('editor');

        function commit(){
            $("#aaa").submit();
        }
    </script>
    <style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>
<body>
<span style="color: #00a2c6" >>>>回复人页面</span>
<form id="aaa" method="post" action="${pageContext.request.contextPath}/eva/add" >

    <input type="hidden" name="forumFk" value="${param.forumid}">
    <input type="hidden" name="evaidFk" value="${param.evaid}">
    <script id="editor" name="evacontent" type="text/plain" style="width:1024px;height:100px;"></script>
    <a href="javascript:commit()" class="coolbg">发布</a>
</form>
</body>
</html>
