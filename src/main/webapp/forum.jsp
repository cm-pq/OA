<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <title>main</title>
    <base target="_self">
    <link rel="stylesheet" type="text/css" href="skin/css/base.css" />
    <link rel="stylesheet" type="text/css" href="skin/css/main.css" />

    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript">

    </script>

</head>
<body leftmargin="8" topmargin='8'>

<table width="98%" align="center" border="0" cellpadding="3"
       cellspacing="1" bgcolor="#CBD8AC"
       style="margin-bottom: 8px; margin-top: 8px;">
    <tr>
        <td colspan="3" background="skin/images/frame/wbg.gif" bgcolor="#EEF4EA"
            class='title'>
            <span>论坛分类</span> &nbsp; &nbsp;&nbsp;|<span>生活广场</span> |<span>租房信息</span><a href='${pageContext.request.contextPath}/forum-add.jsp' style='padding-left: 1260px'><font size="3">发帖</font></a>
        </td>
    </tr>
   <c:forEach items="${fors}" var="forq" varStatus="i">
       <c:if test="${i.index % 3 == 0}">
           <tr bgcolor="#FFFFFF">
       </c:if>
        <td>
            <ul class="notice-list">
                <li class="ue-clear">
                    <span><img src="${pageContext.request.contextPath}/images/tx.png" height="50px" width="50px"/></span> <fmt:formatDate value="${forq.createtime}" pattern="yyyy-MM-dd"></fmt:formatDate>
                    <a href="${pageContext.request.contextPath}/fo/look?id=${forq.forumid}"class="notice-title">${forq.forumtitle}</a>
                </li>
            </ul>
        </td>

       <c:if test="${i.index % 3 == 2}">
           </tr>
       </c:if>
   </c:forEach>
</table>

</body>
</html>