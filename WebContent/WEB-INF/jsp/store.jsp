<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お店</title>
<link rel="stylesheet" type="text/css" href="/C1/css/chanko.css">
<link rel="stylesheet" href="/C1/css/common.css">
</head>
<body>
<main>
   <h1 class="chankopicresult">お店（検索結果)</h1>

	<hr>

	<div class="result">
   <h2>${storesList.venue_name}あ</h2>
	<c:forEach var="e" items="${storesList}">
		<form id="regist_form" method="post" action="/C1/ChankoServlet">
			<table class="tb">
				<tr>
					<td>
					<table class="minitable">
					<tr><td>${e.shop_name}</td></tr>
					<tr><td><a href="${e.shop_link}">食べログ</a></td></tr>
					<tr><td><img src="${e.shop_pic}" width="400" height="400"></td></tr>
					<tr><td><img src="${e.food_pic}" width="400" height="400"></td></tr>
					</table>
					</td>
					<td>
					<table class="minitable">
					<tr><td>${e.shop_name}</td></tr>
					<tr><td><a href="${e.shop_link}">食べログ</a></td></tr>
					<tr><td><img src="${e.shop_pic}" width="400" height="400"></td></tr>
					<tr><td><img src="${e.food_pic}" width="400" height="400"></td></tr>
					</table>
					</td>
				</tr>
			</table>
 		</form>
	 </c:forEach>
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