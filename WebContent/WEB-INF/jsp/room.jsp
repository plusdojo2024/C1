<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>各部屋</title>
<link rel="stylesheet" type="text/css" href="/C1/css/room.css">
<link rel="stylesheet" href="/C1/css/common.css">
</head>
<header class="header">
</header>
<body>
  <div class="face">
  <img src="${rikishies.pic}">
  </div>
  <button class="calender">カレンダー</button>
  <button class="contribution"><a href="/C1/ContributionServlet">投稿ボタン</a></button>
<div class="footer"></div>
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
</body>
</html>