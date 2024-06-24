<!--userPage.jsp-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<! DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>SUMOO</title>
  <link rel="stylesheet" href="/C1/css/userPage.css">
  <link rel="stylesheet" href="/C1/css/common.css">
</head>
<body id="top">
  <!--ヘッダー-->
  <header class="header">
    <nav class="nav">
        <a href="/C1/FollowServlet"><img src="/C1/img/followuser.svg" id="pic"></a><!-- フォロー一覧 -->
        <a href="/C1/StarsServlet"><img src="/C1/img/starwhite.png" id="pic" ></a><!-- 白星一覧 -->

          <c:if test="${empty usersList[0].follow_user_id}">
          <%-- このユーザーのことをフォローしていなかったら --%>
            <a href="/C1/UserServlet?follow=0&user_id=${usersList[0].user_id}">
        	<%-- followはそのまま、idはid=${ cardList.user_id }に変える --%>
              <img src="/C1/img/heartwhite.png" width="70" height="70" alt="SUMOO | ユーザー検索">
		    </a>
		  </c:if>
          <c:if test="${!empty usersList[0].follow_user_id}">
          <%-- このユーザーのことをフォローしていたら --%>
            <a href="/C1/UserServlet?follow=1&user_id=${usersList[0].user_id}">
        	<%-- followはそのまま、idはid=${ cardList.user_id }に変える --%>
              <img src="/C1/img/heartred.svg" width="70" height="70" alt="SUMOO | ユーザー検索">
		    </a>
		  </c:if>

    </nav>
  </header>
  <main>
  <!-- ほんとは自分のアイコンが入る-->
    <img src="${usersList[0].icon}" >
    <h1 class="user_name">${usersList[0].user_name}</h1>
    <h1 class="message">${usersList[0].message}</h1>
    <h1 class="oshirikishi">${usersList[0].rikishi_name}</h1>
  <!-- ほんとは推しの力士のアイコンが入る-->
    <img src="${usersList[0].pic}">
    <h1 class="toko">投稿一覧</h1>

    <c:forEach var="e" items="${contributionsList}">


				<!-- <tr class="my_contributions">  -->
					<td class="my_contributions">
						<%-- 返信へ遷移するユーザーアイコン --%> <a
						href="/C1/ReplyServlet?id=${e.id}&judge=1"> <img
							src="${e.pic_movie}" width="300" height="300">

					</a>
					</td>

				<!-- </tr>  -->

		</c:forEach>

  </main>
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
	<!--JavaScriptを読み込む-->
	<script src="/C1/js/userPage.js"></script>
</html>