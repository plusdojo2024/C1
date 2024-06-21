<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>相撲教習所</title>
<link rel="stylesheet" type="text/css" href="/C1/css/school.css">
<link rel="stylesheet" href="/C1/css/common.css">
</head>
<body>
<main>
	<h1 class="school-pic">相撲教習所</h1>



<!-- 後で必ずやること
・optionのboxに枠を作る
・枠内のどこをクリックしてもアコーディオンメニューを開けるようにする -->



	<div class="accordion">
		<div class="option">
			<input type="checkbox" id="toggle1" class="toggle">
			<label class="title" for="toggle1">相撲用語</label>
			<div class="content">
			<p class = "pText">あんこ</p>
			<p class= "pMainText">太った力士のこと。魚のあんこうが語源。</p>
			<p class = "pText">いきたい</p>
			<p class= "pMainText">勝負の分かれ目で、少しでも逆転可能な体勢。</p>
			<p class = "pText">痛み分け</p>
			<p class= "pMainText">取組中、両方の力士が負傷し続行不可能で、審判が引き分けにする。</p>
			<p class = "pText">えびすこ</p>
			<p class= "pMainText">大食いのこと。</p>
			<p class = "pText">大頭</p>
			<p class= "pMainText">幕下筆頭の力士。</p>
			<p class = "pText">おこめ</p>
			<p class= "pMainText">お金、給金、お小遣いのこと。</p>
			<p class = "pText">恩を返す</p>
			<p class= "pMainText">稽古をつけてくれた先輩力士に本場所で勝つ。番付を抜くこと。</p>
			<p class = "pText">可愛がる</p>
			<p class= "pMainText">ぶつかり稽古で相手をしごくこと。</p>
			<p class = "pText">金星</p>
			<p class= "pMainText">平幕力士が、横綱に勝つこと。美しい女性のこと。</p>
			<p class = "pText">白星</p>
			<p class= "pMainText">相撲の星取り表で勝ちを表す白い丸。転じて、試合に勝つこと、また成功・手柄のこと。</p>
			<p class = "pText">黒星</p>
			<p class= "pMainText">相撲の星取り表で負けを表す黒い丸。転じて、試合に負けること、また失敗のこと。</p>
			<p class = "pText">軍配</p>
			<p class= "pMainText">取り組みのとき、行事が手に持って勝敗を示すうちわ。</p>
			<p class = "pText">そっぷ</p>
			<p class= "pMainText">痩せている力士。</p>
			<p class = "pText">断髪式</p>
			<p class= "pMainText">引退した力士の髷を落とし、第二の人生の門出を祝う儀式。</p>
			<p class = "pText">ちゃんこ</p>
			<p class= "pMainText">力士が作る料理のこと。</p>
			<p class = "pText">どろぎ</p>
			<p class= "pMainText">稽古場などで、まわしをつけた力士が羽織る浴衣。</p>
			<p class = "pText">星</p>
			<p class= "pMainText">恋人や女性のこと。</p>
			<p class = "pText">家賃が高い</p>
			<p class= "pMainText">実力以上の地位にいること。転じて、何かが自分には不相応であること。</p>
			<p class = "pText">山稽古</p>
			<p class= "pMainText">土俵以外の平地で稽古すること。</p>
			<p class = "pText">千秋楽</p>
			<p class= "pMainText">本場所１５日間の最後の日。</p>


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
</main>
</body>
</html>