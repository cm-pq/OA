<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>项目信息管理</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:项目管理>>基本信息管理
 </td>
  <td>
    <input type='button' class="coolbg np" onClick="location='project-base-add.jsp';" value='添加新项目' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<!--  搜索表单  -->
<form name='form3' id="search" <%--action='${pageContext.request.contextPath}/pro/search'--%> method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='cid' style='width:150'>
          <option value='0'>选择类型...</option>
          	<option value='1'>项目名称</option>
          	<option value='2'>项目经理</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='keyword' value='' style='width:120px' />
        </td>
        <td width='110'>
    		<select name='orderby' style='width:120px'>
            <option value='0'>排序...</option>
            <option value='1'>立项时间</option>
            <option value='2'>计划完成时间</option>
      	</select>
        </td>
        <td>
            <input type="hidden" id="currentPage">
          &nbsp;&nbsp;&nbsp;<input name="imageField" type="image" onclick="search(1)" src="skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
<!--  内容列表   -->
<form name="form2" id="ff" action="${pageContext.request.contextPath}/pro/del">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="12" background="skin/images/tbg.gif">&nbsp;项目信息列表&nbsp;</td>
</tr>
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="6%">序号</td>
	<td width="10%">项目名称</td>
	<td width="10%">客户公司名称</td>
	<td width="10%">客户方负责人</td>
	<td width="5%">项目经理</td>
	<td width="8%">开发人员数</td>
	<td width="6%">立项时间</td>
	<td width="8%">最近更新时间</td>
	<td width="8%">计划完成时间</td>
	<td width="8%">状态</td>
	<td width="10%">操作</td>
</tr>
<tbody id="showProject" >


</tbody>

    <%--<tr align='center'   bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
        <td><input name="id" type="checkbox" id="id" value="101" class="np"></td>
        <td>1</td>
        <td align="left"><a href=''><u>农业银行自助管理系统</u></a></td>
        <td >中国农业银行</td>
        <td>张云</td>
        <td>苏鑫超</td>
        <td>6</td>
        <td>2015-01-03</td>
        <td>2015-02-03</td>
        <td>2015-06-03</td>
        <td>进行中</td>
        <td><a href="project-base-edit.jsp">编辑</a> | <a href="project-base-look.jsp">查看详情</a></td>
    </tr>
--%>

<tr bgcolor="#FAFAF1">
<td height="28" colspan="12">
	&nbsp;
	<a href="javascript:quanxuan()" class="coolbg">全选</a>
	<a href="javascript:unxuan()" class="coolbg">反选</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="javascript:de()" class="coolbg">&nbsp;删除&nbsp;</a>

	<a href="javascript:excal()" class="coolbg">&nbsp;导出Excel&nbsp;</a>
</td>
</tr>
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="12" align="center"><!--翻页代码 --></td>
</tr>
</table>

</form>
  
<script type="text/javascript" >
$(function () {
    cc(1);
})
function cc (num){
    $("#currentPage").val(num);
$.ajax({
    url:"pro/project-show",
    data:{"currentPage":num},
    type:"post",
    dataType:"json",
    success:function (obj) {
        console.log(obj.list)
     $("#showProject").empty();
     //遍历rs
        $(obj.list).each(function (index,item) {

        //将毫秒值转为日期
            var starttime = new Date(item.starttime);
            var buildtime = new Date(item.buildtime);
            var endtime = new Date(item.endtime);
            /!*调用方法得到年月日*!/
            var time1 = starttime.getFullYear()+"-"+starttime.getMonth()+"-"+starttime.getDay();
            var time2 = buildtime.getFullYear()+"-"+buildtime.getMonth()+"-"+buildtime.getDay();
            var time3 = endtime.getFullYear()+"-"+endtime.getMonth()+"-"+endtime.getDay();
            $("#showProject").append(
        "<tr align='center'   bgcolor='#FFFFFF' onMouseMove='javascript:this.bgColor='#FCFDEE';' onMouseOut='javascript:this.bgColor='#FFFFFF';' height='22' >"+
            '<td><input name="pid" type="checkbox" id="id" value="'+item.pid+'" class="np"></td>'+
            '<td>'+index+'</td>'+
            "<td align='left'><a href=''><u>"+item.pname+"</u></a></td>"+
            "<td >"+item.customer.comname+'</td>'+
            "<td>"+item.customer.companyperson+"</td>"+
            "<td>"+item.employee.ename+"</td>"+
            "<td>"+item.empcount+"</td>"+
            "<td>"+time1+"</td>"+
            '<td>'+time2+'</td>'+
            '<td>'+time3+'</td>'+
            '<td>进行中</td>'+
            '<td><a href="${pageContext.request.contextPath}/pro/edit?pid='+item.pid+'&func=1">编辑</a> | <a href="${pageContext.request.contextPath}/pro/edit?pid='+item.pid+'&func=-1">查看详情</a></td>'+
            +"</tr>");

        });

        $("#showProject").append(
            '<tr bgcolor="#FAFAF1" align="center">'+
            '<td height="28" colspan="12">'+
            ' &nbsp;<a href="javascript:cc('+1+')">首页</a>'+
            ' &nbsp;<a href="javascript:cc('+obj.prePage+')">上一页</a>'+
            ' &nbsp;<a href="javascript:cc('+obj.nextPage+')">下一页</a>'+
            ' &nbsp;<a href="javascript:cc('+obj.lastPage+')">尾页</a>'+
            '<input type="hidden" id="list" value="'+obj.pageNum+'" >'+
            '</td>'+
            '</tr>'

        );

    }
});

}
//全选
    function quanxuan() {
     var a =  $("input[type='checkbox']");
     for (var i = 0;i<a.length;i++){
         a[i].checked=true;

        }

    }
    function unxuan() {
        var b =  $("input[type='checkbox']");
        for (var i = 0;i<b.length;i++){
            b[i].checked=!b[i].checked;
        }
    }
    function de() {
     var d = $("input:checked");
   /*  alert(d)*/
     if (d.length>0){
         var bol =confirm("确认要删除吗?");
         if (bol){
          $("#ff").submit();
         }
     }else {
         alert("请选择后再来");
     }
    }
    function excal() {

        if (confirm("导出吗")){
            $("#list").val()
     $.ajax({
         url: "${pageContext.request.contextPath}/pro/project-show?func=999",
         type: "post",
         data:{"currentPage":$("#list").val()},
         success:function () {
             alert("导入成功!")
         }
     })
        }
    }
    function search() {

    }

</script>

</body>

</html>