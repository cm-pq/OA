<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>创建任务</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/skin/css/base.css">
	<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>

	<script type="application/javascript">
        //选择项目
        $(function () {
            ex();
            pro();
        })
        function pro() {
            $.ajax({
                url:"${pageContext.request.contextPath}/func/selp",
                type:"psot",
                dataType:"json",
                success:function (object) {
                    $("#pro").empty();
                    $("#pro").append("<option value=1>帐户管理模块</option>");
                    $(object).each(function (index,item) {
                        $("#pro").append(
                            "<option name='pid' value="+item.pid+">"+item.pname+"</option>"
                        );
                    })
                }
            })
        }
        function addayalisys(c) {
            $.ajax({
                url: "${pageContext.request.contextPath}/func/ht",
                data:{"pid":c},
                dataType: "json",
                success:function (obj) {
                    $("#anid").empty();
                    $("#anid").append("<option value="+obj.analysis.id+">"+obj.analysis.title+"</option>");
                    $("#mod").empty();
                    $(obj.moduls).each(function (index,item) {
                        $("#mod").append(
                            " <option value="+item.id+">"+item.modname+"</option>"
                        )
                    })
                }
            })
        }
        function addfunc(obj) {
            $.ajax({
                url: "ta/yi",
                data: {"func": obj},
                dataType: "json",
                success: function (os) {
                    console.log(os)
                    $("#fun").empty();
                    $(os.functions).each(function (index, item) {
                        $("#fun").append(
                            " <option value=" + item.id + ">" + item.functionname + "</option>"
                        )
                    });
                }
            })
        }
        function ex() {
            $.ajax({
                url:"emp/selectAll",
                type:"post",
                dataType:"json",
                success:function (obj) {

                    $("#emp").empty();
                    $("#emp").append("<option value='-1'>请选择</option>");
                    $.each(obj,function (index,em) {
                        $("<option ></option>").val(em.eid).text(em.ename).appendTo($("#emp"));
                    })
                }


            })

        }
        function commit() {
            alert("发多少");
            $("#form7").submit();
        }
	</script>




</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:任务管理>>创建任务
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" id="form7" action="${pageContext.request.contextPath}/ta/add" method="post">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;创建任务&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">参考位置：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="pro" onchange="addayalisys(this.value)">
			<option value=1>请选择项目</option>
		</select>-
		<select id="anid"><option value=1>请选择需求</option></select>
		-<select id="mod" onchange="addfunc(this.value)"><option value=1>请选择模块</option></select>-
		<select id="fun" name="funFk"><option value=1>请选择功能</option></select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">任务标题：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="tasktitle"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="starttime"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">结束时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="endtime"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">执行者：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="emp" name="empFk2">
			<option value=1>任务的执行者</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select name="level"><option value="高">高</option><option value="中">中</option><option value="低">低</option></select></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >详细说明：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130 name="remark"></textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit()" class="coolbg">保存</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>