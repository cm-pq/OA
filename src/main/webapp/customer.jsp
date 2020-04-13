<%@ page import="com.github.pagehelper.PageInfo" %>
<%@ page import="com.ujiuye.cus.bean.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>客户信息管理</title>
<link rel="stylesheet" type="text/css" href="../skin/css/base.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="application/javascript">
        

    </script>
</head>
<body leftmargin="8" topmargin="8" background='../skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="../skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:客户信息管理>>客户信息
 </td>
      <%--onClick="location='customer_add';"--%>
  <td>
    <a href="../customer-add.jsp"><input type='button' class="coolbg np"  value='添加客户信息' /></a>
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form action="search" id="search" method="post">

<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='../skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select id="mt" name='kinds' style='width:150'>
            <option value='0'>选择类型...</option>
          	<option value='1'>客户所在公司名称</option>
          	<option value='2'>联系人姓名</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' id="info"  name='keyCode' style='width:120px' />
        </td>
        <td width='110'>
    		<select id="mtime" name='mark' style='width:120px'>
                <option value='0'>排序...</option>
                <option value='1'>编号</option>
      	    </select>
        </td>
        <td>
          &nbsp;&nbsp;&nbsp;<input name="imageField" onclick="search()" type="image" src="../skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
<!--  内容列表   -->
<form name="form2" id="ff" action="delete">

<table id="infotb" width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7" >
	<td height="24" colspan="12" background="../skin/images/tbg.gif">&nbsp;需求列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22" id="tr2">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">联系人</td>
	<td width="10%">公司名称</td>
	<td width="8%">添加时间</td>
	<td width="8%">联系电话</td>
	<td width="10%">操作</td>
</tr>




<%--分页插件里有个属性list用来展示所搜到的数据--%>
    <c:forEach items="${pageinfo.list}" var="customers" varStatus="str">
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >

    <td><input name="id" type="checkbox" id="id" value="${customers.id}" class="np"></td>
	<td>${str.count}</td>
	<td>${customers.companyperson}</td>
	<td align="center">${customers.comname}</td>
    <td> <fmt:formatDate value="${customers.addtime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
<%--
         <fmt:formatDate value="${customers.addtime}" pattern="yyyy-MM-dd">注意这里不能有空格</fmt:formatDate>
--%>
	<td>${customers.comphone}</td>
	<td><a href="updata?func=edit&id=${customers.id}">编辑</a> | <a href="updata?func=look&id=${customers.id}">查看详情</a></td>

</tr>
    </c:forEach>
<%--翻页代码--%>
    <tr bgcolor="#FAFAF1" align="center">
        <td height="28" colspan="12">
            &nbsp;<a href="?currentPage=${pageinfo.firstPage}">首页</a>
            &nbsp;<a href="?currentPage=${pageinfo.prePage}">上一页</a>
            【&nbsp;&nbsp;
<%--
            这里pageinfo.navigatepagenums里面是总页数/每页条数参照自定义分页
--%>
            <c:forEach items="${pageinfo.navigatepageNums}" var="num">

                <c:choose>
                    <c:when test="${pageinfo.pageNum == num}">
                        <a style="color: red;" href="?currentPage=${num}">${num}</a>&nbsp;&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="?currentPage=${num}">${num}</a>&nbsp;&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            】
            &nbsp;<a href="?currentPage=${pageinfo.nextPage}">下一页</a>
            &nbsp;<a href="?currentPage=${pageinfo.lastPage}">尾页</a>
        </td>
    </tr>
<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
    <a href="javascript:allCheck()" class="coolbg">全选</a>
    <a href="javascript:unCheck()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="javascript:batchDelete()" class="coolbg">&nbsp;删除&nbsp;</a>
<%--获取对象--%>
    <%
        session.setAttribute("list",  request.getAttribute("pageinfo"));
    %>
    <a href="outExcel" class="coolbg">&nbsp;导出Excel&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
</tr>
</table>

</form>
<script type="text/javascript">
    /*全选*/
function allCheck() {
var arr = $("input[type='checkbox']");
for (var i = 0;i<arr.length;i++){
    arr[i].checked=true;
}

}
/*反选*/
function unCheck() {
    var arr = $("input[type='checkbox']");
    for (var i = 0; i < arr.length; i++) {
        arr[i].checked = !arr[i].checked;

    }


}
//搜索
    function search() {
    alert("代收款")
    $("#search").submit();
    }



    //获取所有被选中的对像
function batchDelete() {
var arr = $("input:checked");
if (arr.length>0){
var msg = confirm("确认删除吗?")
    if(msg){
  //如果确认,则提交
      $("#ff").submit();
    }
}else{

    alert("请选中要删除的数据")
}


}










</script>
</body>

</html>