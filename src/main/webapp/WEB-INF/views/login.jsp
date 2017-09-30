<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>会员积分系统</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.code {
	font-family: Arial;
	font-style: italic;
	position: absolute;
	background-repeat: no-repeat;
	color: Red;
	border: 0;
	letter-spacing: 5px;
	font-weight: bolder;
}

.STYLE2 {
	font-family: "微软雅黑"
}

#Layer1 {
	position: absolute;
	width: 1094px;
	height: 61px;
	z-index: 1;
}
</style>
</style>
<script type="text/javascript" src="${ctx}/commons/page/login.js">
	
</script>


</head>
<body style="line-height: 0; color: black; background: white; margin: auto;">
	<div style="MARGIN-RIGHT: auto; MARGIN-LEFT: auto; margin-top: 0px; width: 100%; min-width: 1200px;">
		<div style="width: 1200px; margin: 0 auto; overflow: hidden;">
			<div style="float: left; padding: 10px 0 5px 100px;">
				<img src="${ctx}/commons/images/logo.png">
			</div>
			<div style="float: left; padding: 10px 40px 5px;">
				<table>
					<tr>
						<td>
							<span style="color: #1197f3; font-size: 24"> 瑞银信会员积分系统</span>
							<br />
							<span style="color: #1197f3;">RYX Member Points Management System</span>

						</td>
					</tr>

				</table>
			</div>
			<div style="float: right; position: absolute; right: 150px;">
				<p style="font-size: 20px; color: #333; margin-left: 42px; height: 60px; line-height: 80px;">欢迎登录</p>
			</div>
		</div>
		<div style="width: 100%; min-width: 1200px; height: 623px; background-color: #1197f3;">
			<div style="width: 1200px; margin: 0 auto; overflow: hidden; position: relative;">
				<div style="float: left; width: 800px; height: 623px; position: relative;">
					<img src="${ctx}/commons/images/bg.png" style="position: absolute; top: 65px; left: 45px;">
				</div>
				<div style="float: right; position: absolute; top: 103px; right: 80px; height: 417px; width: 344px; background: #FFF">
					<div class="loginWrap">
						<table width="344px" height="360" border="0 cellspacing=" 0" style="position: absolute; top: 60px; left: 0px;">
							<tr height="40px"">
								<td colspan="2">
									<p style="font-size: 16px; position: absolute; top: 0px; left: 30px;">账户登录</p>
									<p style="border-top: 1px solid #E6E6E6; width: 220px; position: absolute; top: 10px; left: 100px;"></p>
								</td>
							</tr>
							<tr height="40px">
								<TD align="center" valign="middle" background="#BFDFFF">
									<div id="loginname1" style="position: absolute; left: 30px; top: 60px; width: 285px; height: 40px; border: 1px solid #dfdfdf;">
										<img style="position: absolute; left: 10px; top: 10px; border-right: 1px solid #dfdfdf; padding-right: 8px;" width="20px" height="20px"
											src="${ctx}/commons/images/majorization/mty-user-icon02.png">
										<input id="loginname" style="position: absolute; left: 40px; top: 0px; outline: none; width: 245px; height: 40px; border: none; font-size: 14px; color: #000000;" type="loginname"
											placeholder="  账户" autocomplete="off" name="loginname" onKeyUp="value=value.replace(/[^\w\.\/]/ig,'')"></input>
									</div>
								</TD>
							</tr>
							<TR height="15px">
								<TD align="center" background="#BFDFFF">
									<div id="password1" style="position: absolute; left: 30px; top: 130px; width: 285px; height: 40px; border: 1px solid #dfdfdf;">
										<img style="position: absolute; left: 10px; top: 10px; border-right: 1px solid #dfdfdf; padding-right: 8px;" width="20px" height="20px"
											src="${ctx}/commons/images/majorization/mty-password-icon.png">
										<input id="password" style="position: absolute; left: 40px; outline: none; top: 0px; width: 245px; height: 40px; border: none; font-size: 14px; color: #000000;" type="password"
											placeholder="  密码" autocomplete="off" name="password" onKeyUp="value=value.replace(/[^\w\.\/]/ig,'')"></input>
									</div>
								</TD>
							</TR>
							<TR height="19px">
								<TD background="#BFDFFF">
									<div id="yzm_div" style="position: relative; top: 100px; left: 30px; width: 238px; height: 40px; border: 1px solid rgb(223, 223, 223);">
										<input id="captcha" style="position: absolute; float: left; width: 135px; height: 100%; font-size: 14px; color: #000000; border: none; outline: none;" placeholder="  验证码"
											autocomplete="off"></input>
										<img id="captchaImg" alt="验证码" src="${ctx }/commons/Kaptcha.jpg" onclick="onCheckCode()" style="position: absolute; top: 0px; left: 135px; width: 103px; height: 40px;" />
										<img style="position: absolute; left: 250px; top: 8px;" src="${ctx}/commons/images/majorization/SX.png" onClick="onCheckCode()" />
									</div>
								</TD>
							</TR>
							<tr>
								<td colspan="2" align="center">
									<input id="submit"
										style="position: absolute; top: 280px; left: 30px; color: white; font-size: 16px; width: 285px; height: 40px; border: 1px solid #3ca0ff; border-radius: 5px; background: #3ca0ff; cursor: pointer;"
										type="button" value="登录" onClick="$.login()">
								</td>
							</tr>
						</table>

					</div>


				</div>

			</div>
		</div>

		<p style="border-top: 1px solid #E6E6E6; margin: 20 auto 0; width: 1000px;"></p>
		<TD align="center" valign="middle">
			<div align="center" style="margin-top: 26px; margin-bottom: 27px;">
				<p style="font-size: 14px; color: #777777;">Copyright 瑞银信 2017-2019.All Rights Reserved 版权所有</p>
			</div>
		</TD>

	</div>
</body>

</html>