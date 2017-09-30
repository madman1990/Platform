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
		$('#viewUser').datagrid('resize', {
			width : cs()
		});
	});
	function cs() {
		return $(window).width() - 6;
	}
	var flag;
	var userCount;
	$.openWin = function(obj, index) {
		$('#UserSave').window({
			title : '添加用户'
		});
		$.showDivShade('${ctx}');
		$('#loginName').val('');
		$('#realName').val('');
		$("#roleId").val('');
		$("#password").val('');
		$("#psdTd").show();
		$("#userId").val('');
		flag = obj;
		if (flag != "-1") {
			$("#psdTd").hide();
			$('#UserSave').window({
				title : '修改用户'
			});
			$('#viewUser').datagrid('selectRow', index);
			var row = $('#viewUser').datagrid('getSelected');
			$('#loginName').val(row.loginName);
			$('#realName').val(row.realName);
			$("#roleId").val(row.roleId);
			$("#userId").val(row.userId);
		}
		$("#UserSave").window('open').window('refresh');
	};
	$.save = function() {

		var loginName = $('#loginName').val();
		var realName = $('#realName').val();
		var roleId = $("#roleId").val();

		if ($.trim(loginName) == "") {
			$.messager.alert("提示 ", "请输入登录名称");
			return false;
		}
		if (!$.checkUserName()) {
			return false;
		}
		if (!$("#userId").val() && '' == $("#userId").val()) {
			if ($.trim($("#password").val()) == "") {
				$.messager.alert("提示 ", "请输入密码");
				return false;
			}
			if ($.trim($("#password").val()).length < 6) {
				$.messager.alert("提示 ", "输入密码长度必须大于等 于6位");
				return false;
			}
			if ($.trim(realName) == "") {
				$.messager.alert("提示 ", "请输入真实名");
				return false;
			}
		}

		if ($.trim(roleId) == "") {
			$.messager.alert("提示 ", "请选择角色");
			return false;
		}

		$('#save').linkbutton('disable');
		if (flag == "-1") {
			$.post("${ctx}/user/insertUser", {
				loginName : $('#loginName').val(),
				realName : $('#realName').val(),
				roleId : $("#roleId").val(),
				password : hex_md5($("#password").val())
			}, function(data) {
				$.parseAjaxReturnInfo(data, $.success, $.failed);
			}, "json");
		} else {
			$.post("${ctx}/user/updateUser", {
				userId : $("#userId").val(),
				loginName : $('#loginName').val(),
				realName : $('#realName').val(),
				roleId : $("#roleId").val()
			}, function(data) {
				$.parseAjaxReturnInfo(data, $.success, $.failed);
			}, "json");
		}

	};
	$.success = function(message, data) {
		$.messager.alert("提示 ", message);
		$('#save').linkbutton('enable');
		$.close();
		$.UserViewClose();
		$.viewUser();
	};
	$.failed = function(message, data) {
		$.messager.alert("提示 ", message);
		$('#save').linkbutton('enable');
	};
	$.close = function() {
		$.hideDivShade();
		$("#UserSave").window('close');
	};
	$.UserViewClose = function() {
		$("#UserView").window('close');
	}

	$.deleteUser = function(index) {
		$('#viewUser').datagrid('selectRow', index);
		var rows = $('#viewUser').datagrid('getSelected');
		
		$.messager.confirm("提示", "确定删除？", function(r) {
            if (r) {
            	$.post("${ctx}/user/deleteUser", {
                    userId : rows.userId,
                }, function(data) {
                    $.parseAjaxReturnInfo(data, $.success, $.failed);
                }, "json");
            }
        });
	};
	$.savePas = function() {
		$.post("${ctx}/user/updateUserPwd", {
			userId : $("#userIdUpdate").val(),
			password : hex_md5($("#passwordUpdate").val())
		}, function(data) {
			$.parseAjaxReturnInfo(data, $.success, $.failed);
			
		}, "json");

	};
	$.viewUserInfo = function(index) {
		$('#viewUser').datagrid('selectRow', index);
		var rows = $('#viewUser').datagrid('getSelected');
		$("#userIdUpdate").val(rows.userId);
		$("#passwordUpdate").val('');
		$("#UserView").window('open').window('refresh');
	}
	$.checkUserName = function() {
		$.post("${ctx}/user/checkUserName", {
			userId : $("#userId").val(),
			loginName : $('#loginName').val()
		}, function(data) {
			if (!data.success) {
				$.messager.alert("提示 ", data.msg);
				return false;
			}
		}, "json");
		return true;
	}
	$.viewUser = function() {
		var UserName = $("#UserName").val();
		$('#viewUser').datagrid({
			title : '用户管理',
			width : $(window).width() - 6,
			height : $(window).height() * 0.9,
			nowrap : true,
			fitColumns : true,
			url : "${ctx}/user/selectList",
			pageSize : 20,
			pageNumber : 1,
			singleSelect : true,
			queryParams : {
				UserName : UserName
			},
			loadMsg : '数据载入中,请稍等！',
			remoteSort : false,
			columns : [ [ {
				field : "loginName",
				title : "用户登录名",
				width : $(window).width() * 0.1,
				align : "center",
				sortable : true
			}, {
				field : "roleName",
				title : "角色名",
				width : $(window).width() * 0.1,
				align : "center",
				sortable : true
			}, {
				field : "realName",
				title : "用户真实名",
				width : $(window).width() * 0.1,
				align : "center",
				sortable : true
			}, {
				field : "userId",
				title : "操作",
				width : $(window).width() * 0.2,
				align : "center",
				sortable : true,
				formatter : function(value, row, index) {
					var html = "";
					html += "  <a href='#' onclick='$.viewUserInfo(" + index + ")'>重置密码</a>";

					html += " | <a href='#' onclick='$.openWin(-2," + index + ")'>修改</a>";

					html += " | <a href='#' onclick='$.deleteUser(" + index + ")'>删除</a>";
					return html;
				}
			} ] ],
			hideColumn : [ [ {
				field : "userId",
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
		var p = $('#viewUser').datagrid('getPager');
		$(p).pagination({
			pageList : [ 5, 10, 20, 50 ],
			beforePageText : '第',
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	};
	$(function() {
		$.viewUser();
	});
</script>
</head>
<body id="indexd" bgcolor="#ff0000">
	<br />
	<table id="viewUser"></table>

	<div id="UserSave" class="easyui-window" title="角色更新" draggable="false" closable="false" closed=true cache="false" collapsible="false" zIndex="20px" minimizable="false" maximizable="false"
		resizable="true" style="width: 720px; height: 300px; top: 100px; padding: 0px; background: #fafafa; overflow: hidden;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="true" style="padding: 10px; background: #fff; overflow: hidden;">
				<input type="hidden" id="userId" name="userId" />
				<table width="680">
					<tr>
						<td align="right">用户登录名：</td>
						<td align="left">
							<input type="text" name="loginName" id="loginName" maxlength="100" onchange="$.checkUserName()" />
						</td>
					</tr>
					<tr id="psdTd">
						<td align="right">密码：</td>
						<td align="left">
							<input type="password" name="password" id="password" maxlength="20" />
						</td>
					</tr>
					<tr>
						<td align="right">真实名：</td>
						<td align="left">
							<input type="text" name="realName" id="realName" maxlength="100" />
						</td>
					</tr>
					<tr>
						<td align="right">角色：</td>
						<td align="left">
							<select id="roleId" name="roleId">
								<option value="">-请选择-</option>
								<c:forEach items="${ROLES}" var="role">
									<option value="${role.roleId }">${role.roleName }</option>
								</c:forEach>
							</select>
						</td>

					</tr>

					<tr>
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

	<div id="UserView" class="easyui-window" title="密码修改" draggable="false" closable="false" closed=true cache="false" collapsible="false" zIndex="20px" minimizable="false" maximizable="false"
		resizable="true" style="width: 720px; height: 300px; top: 100px; padding: 0px; background: #fafafa; overflow: hidden;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="true" style="padding: 10px; background: #fff; overflow: hidden;">
				<input type="hidden" id="userIdUpdate" name="userIdUpdate" />
				<table width="680">
					<tr>
						<td align="right">密码：</td>
						<td align="left">
							<input type="password" name="passwordUpdate" id="passwordUpdate" />
						</td>
					</tr>
					<tr>
						<td align="center" colspan="6">
							<a name="savePas" id="savePas" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$.savePas()">保存</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a name="closePas" id="closePas" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="$.UserViewClose()">关闭</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
