<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ちゃんこ</title>
<link rel="stylesheet" type="text/css" href="/C1/css/chanko.css">
<link rel="stylesheet" href="/C1/css/common.css">
</head>
<body>
<main>
	<h1 class="chankopic">ちゃんこ</h1>

	<div class="recipe">
		<h2>レシピ検索</h2>


		<form method="post" action="/C1/ChankoServlet">

			<p>
				力士名<br> <select name=" recipe">
					<option value="1">熱海富士朔太郎</option>
					<option value="2">遠藤聖大</option>
					<option value="3">炎鵬友哉</option>
					<option value="4">大奄美元規</option>
					<option value="5">大の里泰輝</option>
					<option value="6">尊富士弥輝也</option>
				</select>
			</p>
			<p>
				部屋名<br> <select name="sumostable">
					<option value="1">伊勢ヶ濱部屋</option>
					<option value="2">追手風部屋</option>
					<option value="3">二所ノ関部屋</option>
				</select>
			</p>
			<p>
				カテゴリー<br> <select name="category">
					<option value="1">鍋</option>
					<option value="2">からあげ</option>
					<option value="3">餃子</option>
				</select>
			</p>
			<p class="submit">
				<input type="submit" name="submit" value="レシピ検索">
			</p>
		</form>
	</div>




	<div class="store">
		<h2>お店検索</h2>
		<form method="post" action="/C1/ChankoServlet">


			<p>
				会場<br> <select name ="venue">
					<option value="東京">東京：両国国技館</option>
					<option value="大阪">大阪：エディオンアリーナ大阪</option>
					<option value="名古屋">名古屋：愛知国際アリーナ</option>
					<option value="福岡">福岡：福岡国際センター</option>
				</select>
			</p>

			<p class="submit">
				<input type="submit" name="submit" value="お店検索">
			</p>
		</form>
	</div>
	</main>
</body>
<footer>
  <nav class="menu">
      <a href="/C1/StandByServlet"><img src="/C1/img/taikibeya.png" id="icon" ></a>
      <a href="/C1/UserSearchServlet"><img src="/C1/img/usersearch.png" id="icon" ></a>
      <a href="/C1/RikishiSearchServlet"><img src="/C1/img/rikishiichiran.png" id="icon" ></a>
      <a href="/C1/ChankoServlet"><img src="/C1/img/recipe.png" id="icon"></a>
      <a href="/C1/SchoolServlet"><img src="/C1/img/school.png" id="icon"></a>
      <a href="/C1/MyPageServlet"><img src="/C1/img/mypage.png" id="icon"></a>
  </nav>
</footer>
</html>