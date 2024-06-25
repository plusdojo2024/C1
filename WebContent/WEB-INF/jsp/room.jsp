<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="hero">
 </div>
</header>
<body>
<main>
  <div class="hero">
  <div class="face">
  <img src="${rikishiesList[0].pic}">
  <h2>${rikishiesList[0].rikishi_name}</h2>
  <p>${rikishiesList[0].rikishi_profile}</p>
  </div>
  <div class="calender">
  <a href="/C1/ContributionServlet?rikishi_id=${rikishiesList[0].id}"><img src="/C1/img/contribution.png"></a>
  <a href="/C1/ContributionServlet"><img src="/C1/img/calender.png"></a>
  </div>
  </div>
  <div class="tape">


  <ul class="scroll_content">
  <c:forEach var="e" items="${contributionsList}" >

  <li>
    <a href="/C1/ReplyServlet?id=${e.id}&judge=1"><img src="${e.pic_movie}"></a>

  </li>
  </c:forEach>
  </ul>

<p class="mat"></p>
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