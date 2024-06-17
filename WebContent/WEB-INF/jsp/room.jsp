<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>各部屋</title>
</head>
<body>
  <img src="${rikishies.pic}">
  <a href="/C1/CalenderServlet">カレンダー</a>

  <button><a href="/C1/ContributionServlet">投稿ボタン</a></button>
<div id="footer">
<ul id="nav">
    <li><a href="/C1/StandByServlet">待機部屋</a></li>
    <li><a href="/C1/UserSearchServlet">ユーザ検索</a></li>
    <li><a href="/C1/RikishiSearchServlet">力士一覧</a></li>
    <li><a href="/C1/ChankoServlet">ちゃんこ</a></li>
    <li><a href="/C1/SchoolServlet">教習所</a></li>
    <li><a href="/C1/MyPageServlet">マイページ</a></li>
  </ul>
</div>
</body>
</html>