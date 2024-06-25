<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿</title>
<link rel="stylesheet" type="text/css" href="/C1/css/contribution.css">
<link rel="stylesheet" href="/C1/css/common.css">
</head>
<body>
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
  <div class="tape"></div>
  <H2 class="boardpic">投稿部屋</H2>

<form id="button" method="post" action="/C1/ContributionServlet?Rikishi_id=${Rikishi_id}" enctype="multipart/form-data">

    <div id="preview" style="width: 300px;"></div><br>
        <input id="inputElm" type="file" name="pict" accept="image/*"><br>

  <input type="text" name="text"><br>
  <button type="submit">送信する</button>
</form>


<div class="preview">
</div>
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
<script src="/C1/js/contribution.js">
</script>
</body>
</html>