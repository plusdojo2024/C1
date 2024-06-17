<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>相撲教習所</title>
<link rel="stylesheet" type="text/css" href="/C1/css/school.css">
</head>
<body>
	<h1 class="school-pic">相撲教習所</h1>



<!-- 後で必ずやること
・optionのboxに枠を作る
・枠内のどこをクリックしてもアコーディオンメニューを開けるようにする -->



	<div class="accordion">
		<div class="option">
			<input type="checkbox" id="toggle1" class="toggle">
			<label class="title" for="toggle1">相撲用語</label>
			<div class="content">
			<p>後でここに本文1追加</p>
			</div>
		</div>

		<div class="option">
			<input type="checkbox" id="toggle2" class="toggle">
			<label class="title" for="toggle2">豆知識</label>
			<div class="content">
			<p>後でここに本文2追加</p>
			</div>
		</div>

		<div class="option">
			<input type="checkbox" id="toggle3" class="toggle">
			<label class="title" for="toggle3">イケメン力士紹介</label>
			<div class="content">
			<p>後でここに本文3追加</p>
			</div>
		</div>
	</div>


</body>
</html>