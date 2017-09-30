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
		$('#viewmenu').datagrid('resize', {
			width : cs()
		});
	});
	function cs() {
		return $(window).width() - 6;
	}
	var flag;
	var userCount;
	$.openWin = function(obj, index) {
		$('#menuSave').window({
			title : '添加菜单'
		});
		$.showDivShade('${ctx}');
		$('#menuCode').val('');
		$("#upMenuCode").val('');
		$('#menuName').val('');
		$("#menuDesc").val('');
		$("#menuUrl").val('');
		flag = obj;
		if (flag != "-1") {
			$('#menuSave').window({
				title : '修改菜单'
			});
			$('#viewmenu').datagrid('selectRow', index);
			var row = $('#viewmenu').datagrid('getSelected');
			$('#menuCode').val(row.menuCode);
			$("#upMenuCode").val(row.upMenuCode);
			$('#menuName').val(row.menuName);
			$("#menuDesc").val(row.menuDesc);
			$("#menuUrl").val(row.menuUrl);
		}
		$("#menuSave").window('open').window('refresh');
	};
	$.save = function() {
		var menuCode = $("#menuCode").val();
		var menuName = $("#menuName").val();
		var upMenuCode = $("#upMenuCode").val();
		var menuDesc = $("#menuDesc").val();
		var menuUrl = $("#menuUrl").val();

		if ($.trim(menuName) == "") {
			$.messager.alert("提示 ", "请输入菜单名称");
			return false;
		}

		if ($.trim(upMenuCode) != "" && $.trim(menuUrl) == "") {
			$.messager.alert("提示 ", "请输入菜单地址");
			return false;
		}

		$('#save').linkbutton('disable');
		if (flag == "-1") {
			$.post("${ctx}/menu/insertMenu", {
				menuName : $("#menuName").val(),
				upMenuCode : $("#upMenuCode").val(),
				menuDesc : $("#menuDesc").val(),
				menuUrl : $("#menuUrl").val()
			}, function(data) {
				$.parseAjaxReturnInfo(data, $.success, $.failed);
			}, "json");
		} else {
			$.post("${ctx}/menu/updateMenu", {
				menuCode : $("#menuCode").val(),
				menuName : $("#menuName").val(),
				upMenuCode : $("#upMenuCode").val(),
				menuDesc : $("#menuDesc").val(),
				menuUrl : $("#menuUrl").val()
			}, function(data) {
				$.parseAjaxReturnInfo(data, $.success, $.failed);
			}, "json");
		}

	};
	$.success = function(message, data) {
		$.messager.alert("提示 ", message);
		$('#save').linkbutton('enable');
		$.close();
		$.viewmenu();
	};
	$.failed = function(message, data) {
		$.messager.alert("提示 ", message);
		$('#save').linkbutton('enable');
	};
	$.close = function() {
		$.hideDivShade();
		$("#menuSave").window('close');
	};
	$.menuViewClose = function() {
		$("#menuView").window('close');
	}

	$.deletemenu = function(index) {
		$('#viewmenu').datagrid('selectRow', index);
		var row = $('#viewmenu').datagrid('getSelected');
		$.messager.confirm("提示", "确定删除？", function(r) {
			if (r) {
				$.post("${ctx}/menu/deleteMenu", {
					menuCode : row.menuCode,
				}, function(data) {
					$.parseAjaxReturnInfo(data, $.success, $.failed);
				}, "json");
			}
		});
	};

	$.ClearMenu = function() {
		$("#menuNameOper").val('');
	};

	$.viewmenu = function() {
		var menuName = $("#menuNameOper").val();
		$('#viewmenu').datagrid({
			title : '菜单管理',
			width : $(window).width() - 6,
			height : $(window).height() * 0.9,
			nowrap : true,
			fitColumns : true,
			url : "${ctx}/menu/selectList",
			pageSize : 20,
			pageNumber : 1,
			singleSelect : true,
			queryParams : {
				menuName : menuName
			},
			loadMsg : '数据载入中,请稍等！',
			remoteSort : false,
			columns : [ [ {
				field : "menuName",
				title : "菜单 名称",
				width : $(window).width() * 0.2,
				align : "center",
				sortable : true
			}, {
				field : "menuDesc",
				title : "地址",
				width : $(window).width() * 0.2,
				align : "center",
				sortable : true
			}, {
				field : "upMenuName",
				title : "上级菜单 名称",
				width : $(window).width() * 0.2,
				align : "center",
				sortable : true
			}, {
				field : "menuId",
				title : "操作",
				width : $(window).width() * 0.2,
				align : "center",
				sortable : true,
				formatter : function(value, row, index) {
					var html = "";
					html += " <a href='#' onclick='$.openWin(-2," + index + ")'>修改</a>";
					html += " | <a href='#' onclick='$.deletemenu(" + index + ")'>删除</a>";
					return html;
				}
			} ] ],
			hideColumn : [ [ {
				field : "menuCode",
				field : "upMenuCode"
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
		var p = $('#viewmenu').datagrid('getPager');
		$(p).pagination({
			pageList : [ 5, 10, 20, 50 ],
			beforePageText : '第',
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	};
	$(function() {
		$.viewmenu();
	});
</script>
</head>
<body id="indexd" bgcolor="#ff0000">
	<table width="100%">
		<tr>
			<td width="60">菜单名称：</td>
			<td width="160" align="left">
				<input type="text" name="menuNameOper" id="menuNameOper" style="width: 150px;" />
			</td>

			<td width="120">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="$.viewmenu()">查询</a>
			</td>
			<td>
				<a href="#" class="easyui-linkbutton" onclick="$.ClearMenu()">清空</a>
			</td>
		</tr>
	</table>
	<table id="viewmenu"></table>

	<div id="menuSave" class="easyui-window" title="菜单更新" draggable="false" closable="false" closed=true cache="false" collapsible="false" zIndex="20px" minimizable="false" maximizable="false"
		resizable="true" style="width: 720px; height: 300px; top: 100px; padding: 0px; background: #fafafa; overflow: hidden;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="true" style="padding: 10px; background: #fff; overflow: hidden;">
				<input type="hidden" id="menuCode" name="menuCode" />
				<table width="680">
					<tr style="height: 50px">
						<td align="right">上级菜单名称：</td>
						<td align="left">
							<select id="upMenuCode">
								<option value=''>--请选择--</option>
								<c:forEach var="m" items="${ menu }">
									<option value="${ m.menuCode }">${m.menuName }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr style="height: 50px">
						<td align="right">菜单名称：</td>
						<td align="left">
							<input type="text" name="menuName" id="menuName" maxlength="100" />
						</td>
					</tr>
					<tr style="height: 50px">
						<td align="right">菜单描述：</td>
						<td align="left">
							<input type="text" name="menuDesc" id="menuDesc" maxlength="100" />
						</td>
					</tr>
					<tr style="height: 50px">
						<td align="right">菜单地址：</td>
						<td align="left">
							<input type="text" name="menuUrl" id="menuUrl" maxlength="100" />
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

</body>
</html>
