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
	$(window).resize(function() {
		$('#viewRole').datagrid('resize', {
			width : cs()
		});
	});
	function cs() {
		return $(window).width() - 6;
	}
	var flag;
	var userCount;
	$.openWin = function(obj, index) {
		$('#roleSave').window({
			title : '添加角色'
		});
		$.showDivShade('${ctx}');
		$('#roleId').val('');
		$('#RoleName').val('');
		$("#Status").combobox('select', 1);
		$("#roletypeId").combobox('select', 2);
		$("#roleDesc").val('');
		flag = obj;
		if (flag != "-1") {
			$('#roleSave').window({
				title : '修改角色'
			});
			$('#viewRole').datagrid('selectRow', index);
		    var row = $('#viewRole').datagrid('getSelected');
			$("#roleId").val(row.roleId);
			$("#RoleName").val(row.roleName);
		}
		$("#roleSave").window('open').window('refresh');
	};
	$.save = function() {
		var roleId = $("#roleId").val();
		var roleName = $("#RoleName").val();

		if ($.trim(roleName) == "") {
			$.messager.alert("提示 ", "请输入角色名称");
			return false;
		}

		$('#save').linkbutton('disable');
		if (flag == "-1") {
			$.post("${ctx}/role/insertRole", {
				roleName : roleName
			}, function(data) {
				$.parseAjaxReturnInfo(data, $.success, $.failed);
			}, "json");
		} else {
			$.post("${ctx}/role/updateRole", {
				roleId : roleId,
				roleName : roleName
			}, function(data) {
				$.parseAjaxReturnInfo(data, $.success, $.failed);
			}, "json");
		}

	};
	$.success = function(message, data) {
		$.messager.alert("提示 ", message);
		$('#save').linkbutton('enable');
		$.close();
		$.viewRole();
	};
	$.failed = function(message, data) {
		$.messager.alert("提示 ", message);
		$('#save').linkbutton('enable');
	};
	$.close = function() {
		$.hideDivShade();
		$("#roleSave").window('close');
	};
	$.roleViewClose= function(){
		$("#roleView").window('close');
	} 

	$.deleteRole = function(index) {
		$('#viewRole').datagrid('selectRow', index);
	    var rows = $('#viewRole').datagrid('getSelected');
		$.post("${ctx}/role/checkExist", {
			roleId : rows.roleId,
		}, function(data) {
			if (data.success) {
				var count = data.obj.EXISTS_SUM;
				if (count > 0) {
					$.messager.alert("提示 ", "该角色已分配了用户，不能删除!");
					return false;
				}
				$.messager.confirm("提示", "确定删除？", function(r) {
					if (r) {
						$.post("${ctx}/role/deleteRole", {
							roleId : rows.roleId,
						}, function(data) {
							$.parseAjaxReturnInfo(data, $.success, $.failed);
						}, "json");
					}
				});
			}
		}, "json");

	};
	$.viewRoleInfo = function(index) {
		$('#viewRole').datagrid('selectRow', index);
        var rows = $('#viewRole').datagrid('getSelected');
		$("#roleNameView").val(rows.roleName);
		$("#roleView").window('open').window('refresh');
	}
	$.viewRole = function() {
		var roleName = $("#roleName").val();
		$('#viewRole').datagrid({
			title : '角色管理',
			width : $(window).width() - 6,
			height : $(window).height() * 0.9,
			nowrap : true,
			fitColumns : true,
			url : "${ctx}/role/rolelist",
			pageSize : 20,
			pageNumber : 1,
			singleSelect : true,
			queryParams : {
				roleName : roleName
			},
			loadMsg : '数据载入中,请稍等！',
			remoteSort : false,
			columns : [ [ {
				field : "roleName",
				title : "角色名称",
				width : $(window).width() * 0.2,
				align : "center",
				sortable : true
			}, {
				field : "roleId",
				title : "操作",
				width : $(window).width() * 0.2,
				align : "center",
				sortable : true,
				formatter : function(value, row, index) {
					var html = "";
					html += "  <a href='#' onclick='$.viewRoleInfo(" + index + ")'>详情</a>";

					html += " | <a href='#' onclick='$.openWin(-2," + index + ")'>修改</a>";

					html += " | <a href='#' onclick='$.deleteRole(" + index + ")'>删除</a>";
					return html;
				}
			} ] ],
			hideColumn : [ [ {
				field : "roleId"
			} ] ],
			pagination : true,
			rownumbers : true,
			showFooter : true,
			toolbar : [ {
				id : 'btnadd',
				text : '添加',
				iconCls : 'icon-add',
				handler : function() {
					$.openWin(-1);
				}
			} ]
		});
		var p = $('#viewRole').datagrid('getPager');
		$(p).pagination({
			pageList : [ 5, 10, 20, 50 ],
			beforePageText : '第',
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	};
	$(function() {
		$.viewRole();
	});
	$.ClearRole = function(){
		$("#roleName").val('');
	}
</script>
</head>
<body id="indexd" bgcolor="#ff0000">
	<table width="100%">
		<tr>
			<td width="60">角色名称：</td>
			<td width="160" align="left">
				<input type="text" name="roleName" id="roleName" style="width: 150px;" />
			</td>
			<td width="120">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="$.viewRole()">查询</a>
			</td>
			<td>
                <a href="#" class="easyui-linkbutton" onclick="$.ClearRole()">清空</a>
            </td>
		</tr>
	</table>
	<table id="viewRole"></table>

	<div id="roleSave" class="easyui-window" title="角色更新" draggable="false" closable="false" closed=true cache="false" collapsible="false" zIndex="20px" minimizable="false" maximizable="false"
		resizable="true" style="width: 720px; height: 300px; top: 100px; padding: 0px; background: #fafafa; overflow: hidden;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="true" style="padding: 10px; background: #fff; overflow: hidden;">
				<input type="hidden" id="roleId" name="roleId" />
				<table width="680">
					<tr style="height: 50px">
						<td align="right">角色名称：</td>
						<td align="left">
							<input type="text" name="RoleName" id="RoleName" maxlength="100" />
						</td>
					</tr>

					<tr style="height: 50px">
						<td align="center" colspan="6">
							<a name="save" id="save" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$.save()">保存</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a name="close" id="close" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$.close()">关闭</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<div id="roleView" class="easyui-window" title="角色查看" draggable="false" closable="false" closed=true cache="false" collapsible="false" zIndex="20px" minimizable="false" maximizable="false"
		resizable="true" style="width: 720px; height: 300px; top: 100px; padding: 0px; background: #fafafa; overflow: hidden;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="true" style="padding: 10px; background: #fff; overflow: hidden;">
				<table width="680">
					<tr style="height: 50px">
						<td align="right">角色名称：</td>
						<td align="left">
							<input type="text" name="roleNameView" id="roleNameView" maxlength="100" readonly="readonly" />
						</td>
					</tr>
					<tr style="height: 50px">
						<td align="center" colspan="6">
							<a name="close" id="close" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$.roleViewClose()">关闭</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
