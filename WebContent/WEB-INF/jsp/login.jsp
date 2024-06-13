<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="/C1/css/login.css">
</head>
<body class="login-page">
	<div class="wrapper"></div>
	<div class="login">
		<div class="login-screen">
			<div class="app-title">
				<h1>Login</h1>
			</div>

			<div class="login-form">
				<form id="login_form" method="post" action="/C1/LoginServlet">
					<div class="login-name">
						<input type="text" class="login-field" name="id"
							placeholder="username" id="login-name"> <label
							class="login-field-name" for="login-name"></label>
					</div>

					<div class="login-pass">
						<input type="password" class="login-field" name="pw"
							placeholder="password" id="login-pass"> <label
							class="login-field-pass" for="login-pass"></label>
					</div>

					<div id="error_message" style="color: red;"></div>

					<input type="submit" id="btnLogin" value="login"
					style="margin-top:20px;">
				</form>
				<!-- 問い合わせ先は作る時間ないため#にしておく ただ下線引くだけ-->
				<a class="login-link" href="#">パスワードを忘れましたか?</a>
			</div>
		</div>
	</div>


	<!-- JavaScript（ここから） -->
	<script>
  /* HTML要素をオブジェクトとして取得する */
  let formObj = document.getElementById('login_form');
  let errorMessageObj = document.getElementById('error_message');

  /* [ログイン]ボタンをクリックしたときの処理 */
  formObj.onsubmit = function() {
    if (!formObj.id.value || !formObj.pw.value) {
      errorMessageObj.textContent = '※IDとパスワードを入力してください！';
      return false;
    }
    errorMessageObj.textContent = null;
  };
</script>
	<!-- JavaScript（ここまで） -->
</body>
</html>