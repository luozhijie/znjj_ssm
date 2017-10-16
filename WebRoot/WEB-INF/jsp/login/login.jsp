<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>登录界面</title>
<%@ include file="/WEB-INF/jsp/includePage/headinclude.html"%>
<script type="text/javascript">
	function login() {
		$.post("ActionServlet?stat=login", {
			username : $("#username").val(),
			password : $("#password").val(),
			yzm : $("#yzm").val()
		}, function(data) {
			if (data == "OK") {
				window.location.href = "Index.jsp";
			} else {
				alert(data);
			}
		});
	}
</script>
</head>
<body class="cbp-spmenu-push">
	<!-- main content start-->
	<div class="main-page login-page ">
		<h3 class="title1">登录</h3>
		<div class="widget-shadow">
			<div class="login-top">
				<h4>
					欢迎来到家庭管理<br> 没有账号？ <a href="signup.jsp"> 注册 »</a>
				</h4>
			</div>
			<div class="login-body">
				<input id="username" type="text" class="user" name="email"
					placeholder="请输入账号" required=""> <input id="password"
					type="password" name="password" class="lock" placeholder="请输入密码">
				<input id="yzm" type="text" class="user" name="email"
					placeholder="请输入验证码" required=""><img alt=""
					src="ActionServlet?stat=getYzm"> <input type="submit"
					name="Sign In" value="登录" onclick="return login()">
				<div class="forgot-grid">
					<label class="checkbox"><input type="checkbox"
						name="checkbox"><i></i>记住密码</label>
					<div class="forgot">
						<a href="#">忘记密码？</a>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!--footer-->
	<%@ include file="/WEB-INF/jsp/includePage/footinclude.html"%>
	<!--//footer-->
	</div>
	<!-- Classie -->
	<script src="/smartHome/js/classie.js"></script>
	<script>
		var menuLeft = document.getElementById('cbp-spmenu-s1'),
			showLeftPush = document
				.getElementById('showLeftPush'),
			body = document.body;
		showLeftPush.onclick = function() {
			classie.toggle(this, 'active');
			classie.toggle(body, 'cbp-spmenu-push-toright');
			classie.toggle(menuLeft, 'cbp-spmenu-open');
			disableOther('showLeftPush');
		};
		function disableOther(button) {
			if (button !== 'showLeftPush') {
				classie.toggle(showLeftPush, 'disabled');
			}
		}
	</script>
</body>
</html>