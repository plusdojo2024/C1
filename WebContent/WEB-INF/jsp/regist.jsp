<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入門画面</title>
<link rel="stylesheet" href="/C1/css/regist.css">
</head>
<body class="regist-page">
	<div class="wrapper"></div>
	<div class="regist">
		<div class="regist-screen">
			<div class="app-title">
				<h1>入門</h1>
			</div>


			<div class="regist-form">
				<form id="regist_form" method="post" action="/C1/RegistServlet">
					<!-- IDの入力 -->
					<div class="regist-name">
						<input type="text" class="regist-field" name="id"
							placeholder="username" id="regist-name"> <label
							class="login-field-name" for="regist-name"></label>
					</div>


					<!-- パスワードの入力 -->
					<div class="regist-pass">
						<input type="password" class="regist-field" name="pw"
							placeholder="password" id="regist-pass"> <label
							class="regist-field-pass" for="regist-pass"></label>
					</div>

					<!-- パスワードの再度確認 -->
					<div class="regist-pass">
						<input type="password" class="regist-field" name="pw"
							placeholder="passwordをもう一度入力してください" id="regist-pass"> <label
							class="regist-field-pass" for="regist-pass"></label>
					</div>

					<!-- 秘密の質問 ！修正必須！-->
					<div class="regist-question">
						<input type="text" class="regist-field" name="question"
							placeholder="秘密の質問の答えを入力してください" id="regist-pass"> <label
							class="regist-field-pass" for="regist-pass"></label>
					</div>


					<!-- ユーザーネームの入力 -->
					<div class="regist-username">
						<input type="text" class="regist-field" name="username"
							placeholder="username" id="regist-username"> <label
							class="regist-field-username" for="regist-username"></label>
					</div>


					<!-- アイコンの設定 -->
					<div class="regist-icon">
						<input type = "file"><br>
					</div>

					<div id="error_message" style="color: red;"></div>

					<input type="submit" id="btnLogin" value="入門" style="width :120px; padding: 3px;">
				</form>

			</div>

		</div>
	</div>

	<!-- JavaScriptを読み込む -->
	<script src="/C1/js/regist.js"></script>

</body>
</html>