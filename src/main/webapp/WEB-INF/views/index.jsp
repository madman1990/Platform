<%@page import="java.util.ArrayList"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style type="text/css">
.colors {
	font-size: 12px;
	color: #ffffff;
	font-weight: bold;
	line-height: 25px;
	padding: 2px;
	background-image: -moz-linear-gradient(top, #ffffff, #F2F2F2);
	/* Firefox */
	background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #ffffff), color-stop(1, #F2F2F2)); /* Saf4+, Chrome */
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#84909c', endColorstr='#c7ccd1', GradientType='0');
} /* IE*/
</style>
<script type="text/javascript" src="${ctx}/commons/js/tab.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>会员积分系统</title>
<script type="text/javascript">
	$(function() {
		$("#detailTree").tree({
			onlyLeafCheck : true,
			checkbox : false,
			url : "${ctx}/menu/getMenuTree",
			onSelect : function() {
				var row = $("#detailTree").tree('getSelected');
				var url = row.attributes.url;
				if (url != '' && url != null) {
					addTab(row.text, "${ctx}" + url, '123');
				}
			}
		});
	});
	//设置登录窗口
	function openPwd() {
		$('#w').window({
			title : '修改密码',
			width : 300,
			modal : true,
			shadow : true,
			closed : true,
			height : 200,
			resizable : false
		});
		$('#txtNewPass').val('');
		$('#txtRePass').val('');
		$('#txtOldPass').val('');
	}
	//关闭登录窗口
	function closePwd() {
		$('#w').window('close');
		$('#txtNewPass').val('');
		$('#txtRePass').val('');
		$('#txtOldPass').val('');
	}

	//修改密码
	function serverLogin() {

		var newPwd = $('#txtNewPass').val();
		var rePass = $('#txtRePass').val();
		var oldPwd = $('#txtOldPass').val();
		newPwd = hex_md5(newPwd);
		rePass = hex_md5(rePass);
		oldPwd = hex_md5(oldPwd);
		if (oldPwd == '') {
			msgShow('系统提示', '请输入原始密码！', 'warning');
			return false;
		}

		if (newPwd == '') {
			msgShow('系统提示', '请输入新密码！', 'warning');
			return false;
		}
		if (rePass == '') {
			msgShow('系统提示', '请再一次输入密码！', 'warning');
			return false;
		}

		if (newPwd != rePass) {
			msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
			return false;
		}
		$.post('${ctx}/user/editUserPwd', {
			pwd : newPwd,
			oldPwd : oldPwd
		}, function(data) {
			$.parseAjaxReturnInfo(data, $.success, $.failed);
		}, "json");

	}

	$(function() {
		openPwd();
		$('#editpass').click(function() {
			$('#w').window('open');
		});

		$('#btnEp').click(function() {
			serverLogin();
		});
		$('#btnCancel').click(function() {
			closePwd();
		});
		$('#loginOut').click(function() {
			$.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
				if (r) {
					$.post('${ctx}/logout', function(result) {
						if (result.success) {
							window.location.href = '${ctx }';
						}
					}, "json");

				}
			});
		});
	});
	$.success = function(message, data) {
		$.messager.alert("提示 ", message);
		closePwd();
	};

	$.failed = function(message, data) {
		$.messager.alert("提示 ", message);
	};
</script>
</head>
<body class="easyui-layout" style="overflow-y: hidden" fit="true" scroll="no">
	<div data-options="region:'north',title:'',split:false" style="overflow: true; height: 65%; background: url('') repeat-x center 50%; line-height: 20px; font-family: Verdana, 微软雅黑, 黑体" class='colors'>

		<table width="100%">
			<tr>
				<td width="190px">
					<img src="${ctx}/commons/images/logo.png">
				</td>
				<td align="left" style="padding-bottom: 5px;">
					<table>
						<tr>
							<td>
								<span style="color: #1197f3; font-size: 22">&nbsp;&nbsp; 瑞银信会员积分系统</span>
								<br />
								<span style="color: #1197f3;">RYX Member Points Management System</span>
							</td>
						</tr>
					</table>
				</td>
				<td align="right" style="font-size: 12px; font-weight: bold;">
					<span style="float: right; padding-right: 20px; padding-top: 15px">
						<a>欢迎 ${username}</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="#" id="editpass">修改密码</a>
						<a href="#" id="loginOut">安全退出</a>
					</span>
				</td>
			</tr>
		</table>
	</div>

	<div data-options="region:'west',title:'导航菜单',split:true" style="width: 180px;">
		<div id="nav">
			<!--  导航内容 -->
			<ul id="detailTree" name="detailTree" data-options="checkbox:true,animate:true,lines:true"></ul>
		</div>
	</div>
	<div id="mainPanle" data-options="region:'center',title:''" style="padding: 0px; background: #eee; overflow-y: hidden">
		<div id="tabs" class="easyui-tabs" fit="true" border="false"></div>
	</div>

	<!--修改密码窗口-->
	<div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false" maximizable="false" icon="icon-save" style="width: 300px; height: 240px; padding: 5px; background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<table cellpadding=3>
					<tr>
						<td>原始密码：</td>
						<td>
							<input id="txtOldPass" class="txt01" type="password" maxlength="10" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" />
						</td>
					</tr>
					<tr>
						<td>新密码：</td>
						<td>
							<input id="txtNewPass" class="txt01" type="password" maxlength="10" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" />
						</td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td>
							<input id="txtRePass" class="txt01" type="password" maxlength="10" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" />
						</td>
					</tr>
				</table>
			</div>
			<div region="south" border="false" style="text-align: center; height: 30px; line-height: 30px;">
				<a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)">确定</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
			</div>
		</div>
	</div>

	<div align="center" data-options="region:'south',title:'',split:true" style="overflow: true; height: 3%; line-height: 5px; font-family: Verdana, 微软雅黑, 黑体" class='colors'>
		<TD align="center" valign="middle">
			<div align="center" style="margin-top: 2px; margin-bottom: 2px;">
				<p style="font-size: 14px; color: #777777;">Copyright 瑞银信 2017-2019.All Rights Reserved 版权所有</p>
			</div>
		</TD>
	</div>

	<div id="mm" class="easyui-menu" style="width: 150px;">
		<div id="refresh">刷新</div>
		<div class="menu-sep"></div>
		<div id="close">关闭</div>
		<div id="closeall">全部关闭</div>
		<div id="closeother">除此之外全部关闭</div>
	</div>

</body>
</html>
