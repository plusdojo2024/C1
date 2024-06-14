<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カレンダー</title>
<link rel="stylesheet" type="text/css" href="">
</head>
<body>
  <h2 class="calender">今後の予定</h2><br>
  <c:forEach var="e" items="${}" >
  <ul><br>
    <li name="calender" value="${e.calender}"></li>
  </ul>
  </c:forEach>
  <button><a href="aaaa.xlsx">Googleカレンダーと連携する</a></button>
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