<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>会员积分系统</title>
<style type="text/css">
.button1 {
	color: #444;
	background-repeat: no-repeat;
	background: #f5f5f5;
	background-repeat: repeat-x;
	border: 1px solid #bbb;
	background: -webkit-linear-gradient(top, #ffffff 0, #e6e6e6 100%);
	background: -moz-linear-gradient(top, #ffffff 0, #e6e6e6 100%);
	background: -o-linear-gradient(top, #ffffff 0, #e6e6e6 100%);
	background: linear-gradient(to bottom, #ffffff 0, #e6e6e6 100%);
	background-repeat: repeat-x;
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#ffffff, endColorstr=#e6e6e6, GradientType=0);
	-moz-border-radius: 5px 5px 5px 5px;
	-webkit-border-radius: 5px 5px 5px 5px;
	border-radius: 5px 5px 5px 5px;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#detailTree").tree({
			url : "${ctx}/menu/getRoleMenuTree",
			checkbox : true
		});
	});

	$.changeRole = function() {
		var roleId = $("#rolelist").val();
		$("#detailTree").tree({
			url : "${ctx}/menu/getRoleMenuTree?roleId=" + roleId,
			checkbox : true
		});

	}
	$.save = function() {
		var powerIds = "";
		var roleId = $("#rolelist").val();
		if ($.trim(roleId) == "-1") {
			$.messager.alert("提示 ", "请选择一个角色");
			return;
		}

		var rows = $("#detailTree").tree("getChecked");
		var authId = $("#authId").val;
		for (var i = 0; i < rows.length; i++) {
			powerIds += rows[i].id + ",";
		}
		powerIds = powerIds.substring(0, powerIds.lastIndexOf(","));
		$('#save').linkbutton('disable');
		$.post("${ctx}/menu/saveRoleMenu", {
			roleId : roleId,
			powerIds : powerIds
		}, function(data) {
			$.parseAjaxReturnInfo(data, $.success, $.failed);
		}, "json");
	};

	$.success = function(message, data) {
		$.messager.alert("提示 ", message);
		$('#save').linkbutton('enable');

	};

	$.failed = function(message, data) {
		$.messager.alert("提示 ", message);
		$('#save').linkbutton('enable');
	};
</script>
</head>
<body>
	<table id="border" width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td class="SmallPartHeader" colspan="2" style="background: #F2F2F2;" align="center">
				<font size="5"><b>角色菜单管理</b></font>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<b>请选择一个角色,勾选菜单列表后点击保存进行更新菜单 :&nbsp;&nbsp;</b>
				<select id="rolelist" name="rolelist" style="width: 110px;" onchange="$.changeRole()">
					<option value="">-请选择-</option>
					<c:forEach items="${ROLES}" var="role">
						<option value="${role.roleId }">${role.roleName }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>

			<td>
				<div id="divTree" style="background: #fafafa; position: relative; visibility: visible; left: 0 px; top: 0 px; z-index: 1; width: 100%; height: 400px; overflow-y: auto;">
					<ul id="detailTree" name="detailTree" data-options="checkbox:true,animate:true,lines:true"></ul>

				</div>
				<div align="center">
					<a name="save" id="save" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$.save()">保存</a>
				</div>
				<br />
			</td>

		</tr>
	</table>
</body>
</html>