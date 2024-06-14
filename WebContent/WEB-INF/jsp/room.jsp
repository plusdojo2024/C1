<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿</title>
</head>
<body>
<form method="post" action="/C1/ContributionServlet">
  <input type="file"><br>
  <input type="text"><br>
  <button type="submit">送信する</button>
</form>
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