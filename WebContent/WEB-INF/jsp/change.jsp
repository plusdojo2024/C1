<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録情報の変更画面</title>
<link rel="stylesheet" href="/C1/css/change.css">
</head>
<body class="change-page">
	<div class="wrapper"></div>
	<div class="change">
		<div class="change-screen">
			<div class="app-title">
				<h1>登録情報の変更</h1>
			</div>

			<div class="change-form">
				<form id="change_form" method="post" action="/C1/ChangeServlet">
					<!-- アイコンの設定 -->
					<div class="change-icon">
						<input type = "file" class="change-icon" name="icon"
							placeholder="画像を選んでください" id="change-icon">
							<label class="change-field-icon" for="change-icon"></label>
					</div>

					<!-- IDの入力 -->
					<div class="change-name">
						<input type="text" class="change-field" name="id"
							placeholder="ID" id="change-name"> <label
							class="change-field-name" for="change-name"></label>
					</div>

					<!-- ユーザーネームの入力 -->
					<div class="regist-username">
						<input type="text" class="regist-field" name="username"
							placeholder="username" id="regist-username"> <label
							class="regist-field-username" for="regist-username"></label>
					</div>


					<!-- メッセージの入力 -->
					<div class="change-message">
						<input type="text" class="change-field" name="message"
							placeholder="message" id="change-message"> <label
							class="change-field-message" for="change-message"></label>
					</div>

					<div id="error_message" style="color: red;"></div>

					<input type="submit" id="btnChange" value="登録" style="width :120px; padding: 3px;">
				</form>
			</div>
		</div>
	</div>

	<!-- JavaScriptを読み込む -->
	<script src="/C1/js/login.js"></script>

</body>
</html>