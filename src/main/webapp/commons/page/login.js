$(document).ready(function() {
	if (top.location != location) {
		top.location = location;
	}

	$.login = function() {

		var loginname = $("#loginname").val();
		var password = $("#password").val();
		// password = hex_md5(password);
		var captcha = $("#captcha").val();

		if (loginname == null || $.trim(loginname) == "") {
			$.messager.alert("提示", "请输入用户名");
			return;
		}

		if (password == null || $.trim(password) == "") {
			$.messager.alert("提示", "请输入密码");
			return;
		}
		if (captcha.length <= 0) {
			$.messager.alert("提示", "请输入验证码");
			return;
		}

		if (checkChinese(loginname)) {
			$.messager.alert("提示 ", "用户名输入错误，请重新输入");
			return false;
		}
		if (checkChinese(password)) {
			$.messager.alert("提示 ", "密码输入错误，请重新输入");
			return false;
		}
		if (checkChinese(captcha)) {
			$.messager.alert("提示 ", "验证码不能是中文");
			return false;
		}
		$.post(basePath + "/login", {
			userName : loginname,
			password : password,
			captcha : captcha
		}, function(data) {
			if (data.success) {
				location.href = basePath + "/index";
			} else {
				$.messager.alert("提示", data.msg);
			}
		}, "json");

	}
});
// 判断是否为中文
function checkChinese(str) {
	var reg = new RegExp("[\\u4E00-\\u9FFF]+", "g");
	return reg.test(str);
}

$(document).keydown(function(event) {
	if (event.keyCode == 13) {
		$.login();
	}
});

function onCheckCode () {
    var date = new Date();
    $("#captchaImg").attr("src", basePath + "/commons/Kaptcha.jpg?d="+date);
}
