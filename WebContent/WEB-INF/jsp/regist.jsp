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
							placeholder="ID" id="regist-name"> <label
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
							placeholder="もう一度入力してください" id="regist-pass"> <label
							class="regist-field-pass" for="regist-pass"></label>
					</div>


					<p>
						秘密の質問<br> <select name="secret-question">
						<option value="1">初めて飼った動物は？</option>
						<option value="2">初恋の人は？</option>
						<option value="3">推し力士は？</option>
						</select>
					</p>
					<!-- 秘密の質問-->
					<div class="regist-question">
						<input type="text" class="regist-field" name="question"
							placeholder="上記の答えを入力してください" id="regist-pass" style="margin-top: 0px;"> <label
							class="regist-field-pass" for="regist-pass"></label>
					</div>


					<!-- ユーザーネームの入力 -->
					<div class="regist-username">
						<input type="text" class="regist-field" name="username"
							placeholder="username" id="regist-username"> <label
							class="regist-field-username" for="regist-username"></label>
					</div>


					<!-- 推し力士 -->
					<div class="regist-favorite-rikishi">
						<input type="text" class="regist-field" name="favorites"
							placeholder="推し力士" id="regist-favorites"> <label
							class="regist-field-favorites" for="regist-username"></label>
					</div>


					<!-- messageの入力 -->
					<div class="regist-username">
						<textarea class="regist-field-message" name="message"
							placeholder="message" id="regist-message" rows="5" cols="40"></textarea>
						<label class="regist-field-message" for="regist-message"></label>
					</div>




					<!-- アイコンの設定 -->



					<form id="regist_form" method="post" action="/C1/RegistServlet" enctype="multipart/form-data">
                    <!-- フォームで選択した画像 -->
                    <img id="user-icon" src="/C1/img/default.png">

                    <div class="buttons">
                        <!-- フォーム -->
                        <input type="file" name="logo" id="form" accept=".jpg, .jpeg, .png, .gif">

                        <!-- 画像削除ボタン -->
                        <button type="button" id="delete">削除</button>
                    </div>

                    <div id="error_message" style="color: red;"></div>

                    <input type="submit" id="btnLogin" value="入門">
                </form>
			</form>



			</div>

		</div>
	</div>

	<!-- JavaScriptを読み込む -->
	<script src="/C1/js/regist.js"></script>

</body>
</html>