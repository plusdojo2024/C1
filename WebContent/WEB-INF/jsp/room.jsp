<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>各部屋</title>
<link rel="stylesheet" type="text/css" href="/C1/css/room.css">
<link rel="stylesheet" href="/C1/css/common.css">
  <!--
  <style>
  * {
    outline: 1px solid #FF0000;
  }
  </style>
  -->
</head>
<header class="header">
</header>
<body>
<main>
  <div class="face">
  <img src="/C1/img/iconatami.png">
  <h2>力士の名前</h2>
  <p>プロフィール</p>
  </div>
  <div class="calender">
  <a href="/C1/ContributionServlet"><img src="/C1/img/contribution.png"></a>
  <a href="/C1/ContributionServlet"><img src="/C1/img/calender.png"></a>
  </div>

  <ul class="scroll_content">
  <li>
    <a href="#"><img src="/C1/img/iconatami.png"></a>
    <h2>タイトル</h2>
    <p>ディスクリプション</p>
  </li>
  <li>
    <a href="#"><img src="/C1/img/iconendo.png"></a>
    <h2>タイトル</h2>
    <p>ディスクリプション</p>
  </li>
  <li>
    <a href="#"><img src="/C1/img/heartwhite.png"></a>
    <h2>タイトル</h2>
    <p>ディスクリプション</p>
  </li>
</ul>
<p id="mat"></p>
</main>
<footer id="footer">
  <nav class="menu">
      <a href="/C1/StandByServlet"><img src="/C1/img/taikibeya.png" id="icon" ></a>
      <a href="/C1/UserSearchServlet"><img src="/C1/img/usersearch.png" id="icon" ></a>
      <a href="/C1/RikishiSearchServlet"><img src="/C1/img/rikishiichiran.png" id="icon" ></a>
      <a href="/C1/ChankoServlet"><img src="/C1/img/recipe.png" id="icon"></a>
      <a href="/C1/SchoolServlet"><img src="/C1/img/school.png" id="icon"></a>
      <a href="/C1/MyPageServlet"><img src="/C1/img/mypage.png" id="icon"></a>
  </nav>
</footer>
</body>
</html>