<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SUMOO | 白星一覧</title>
<link rel="stylesheet" href="/C1/css/stars.css">
<link rel="stylesheet" href="/C1/css/common.css">
</head>

<body class=stars-page>
<main>
	<div class="wrapper" id="top">
		<header class="header">
			<div class="logo">
				<h1>白星一覧</h1>
			</div>
		</header>




		<c:forEach var="e" items="${starsList}">
			<table class="stars_contributions">
				<tr class="info">
					<td>
						<%-- 返信へ遷移するユーザーアイコン --%> <a
						href="/C1/ReplyServlet?user_id=${e.user_id}&id=${e.contribution_id}&judge=1"> <img
							src="${e.icon}" width="70" height="70">

					</a>
					</td>
					<td><a href="/C1/ReplyServlet?user_id=${e.user_id}&id=${e.contribution_id}&judge=1">
							${e.user_name} </a></td>
					<td>
						<%-- この力士のことをお気に入りしていたら --%> <a
						href="/C1/StarsServlet?star=${e.user_id}"> <img
							src="/C1/img/starwhite.png" width="70" height="70">
					</a>
					</td>
				</tr>
				<tr>
					<td></td>
					<td class="photo">
						<%-- 返信へ遷移するユーザーアイコン --%> <a
						href="/C1/ReplyServlet?user_id=${e.user_id}&id=${e.contribution_id}&judge=1"> <img
							src="${e.pic_movie}" width="200" height="200">

					</a>
					</td>
					<td></td>

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






</main>
</body>
</html>