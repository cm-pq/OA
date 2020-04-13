<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/30
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>测试</title>
</head>
<body>
<form id="ppl" method="post" action="${pageContext.request.contextPath}/ppl/add">
    姓名:<input type="text" name="pname"><br>
    性别:<input type="checkbox" name="psex" style="background-color: #66512c" value="男">
         <input type="checkbox" name="psex" style="background-color: red" value="女"><br>
         <input type="submit" value="提交">
</form>
<hr>
<form id="aaaa" action="${pageContext.request.contextPath}/ppl/delete" method="post">
<c:forEach items="${pp}" var="ppl" varStatus="i">
    <p style="color: #00B83F">-------------------------------------------------</p>
  <input type="checkbox" id="pid" name="id" value="${ppl.pid}">
    ${i.count}
    &nbsp;&nbsp;<input type="text"  value="${ppl.pname}">
    <input type="text"  value="${ppl.psex}">
</c:forEach>

</form>
<a href="${pageContext.request.contextPath}/customer/cust">点击</a>
<a  href="javascript:void(0)" onclick="ppp()" >删除</a>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">


   function ppp() {
       //获取所有被选中的对象
       var a = $("input:checked");
       if (a.length==0){

           alert("请选择一项")
       }else if(confirm("确认删除吗")){
//猜想:前面的只是判断是否有选中,而在内容表单里,有name属性的只有id,而id有是复选框,没选中他是没有值的,也就是说,这里只是提交id相同,值不同的多个id
  $("#aaaa").submit();
       }
   }



</script>
</body>

</html>
