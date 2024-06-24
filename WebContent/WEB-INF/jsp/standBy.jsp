<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SUMOO | 待機部屋</title>
<link rel="stylesheet" href="/C1/css/standBy.css">
<link rel="stylesheet" href="/C1/css/common.css">
</head>
<body class=rikishi-page>
	<div class="wrapper" id="top">
		<header class="header">
			<div class="logo">
				<h1>待機部屋</h1>
			</div>
		</header>









		<c:forEach var="e" items="${rikishiesList}">
			<table class="boardpic">
				<tr>
					<td><a href="/C1/RoomServlet?rikishi_id=${e.id}"> <img
							src="${e.pic}" width="70" height="70">
					</a></td>
					<td><a href="/C1/RoomServlet?rikishi_id=${e.id}">
							${e.rikishi_name} </a></td>
					<td><a href="/C1/RikishiServlet?favorite=1&rikishi_id=${e.id}">
							<img src="/C1/img/heartred.svg" width="70" height="70">
					</a></td>
				</tr>
			</table>
		</c:forEach>











		<footer>
			<nav class="menu">
				<a href="/C1/StandByServlet"><img src="/C1/img/taikibeya.png"
					id="icon"></a> <a href="/C1/UserSearchServlet"><img
					src="/C1/img/usersearch.png" id="icon"></a> <a
					href="/C1/RikishiSearchServlet"><img
					src="/C1/img/rikishiichiran.png" id="icon"></a> <a
					href="/C1/ChankoServlet"><img src="/C1/img/recipe.png"
					id="icon"></a> <a href="/C1/SchoolServlet"><img
					src="/C1/img/school.png" id="icon"></a> <a
					href="/C1/MyPageServlet"><img src="/C1/img/mypage.png"
					id="icon"></a>
			</nav>
		</footer>
	</div>
</body>
</html>