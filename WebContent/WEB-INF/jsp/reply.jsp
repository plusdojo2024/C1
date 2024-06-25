<!-- reply.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SUMOO | 返信ページ</title>
<link rel="stylesheet" href="/C1/css/reply.css">
<link rel="stylesheet" href="/C1/css/common.css">
<style>
    span{
     margin-right: 100px;
    }
  </style>
</head>
<main>
<c:forEach var="e" items="${contributionsList}" >
<table class="boardpic">
      <tr>
        <td>
        <!-- ユーザーネーム、アイコン -->
        	<%-- idはid=${ cardList.rikishi_id }に変える --%>

            <img src="${e.icon}" width="70" height="70" alt="アイコン" id="icon">
            <!--
             src="${rikishi_pic} widthとheightはCSSで決める
             -->
        </td>
        <td id="name">
          ${e.user_name}
        </td>
        <td>
          <c:if test="${empty e.stars_user_id}">
          <%-- この投稿のことをお気に入りしていなかったら --%>
            <a href="/C1/ReplyServlet?star=0&id=${e.id}">
        	<%-- favoriteはそのまま、idはid=${ cardList.rikishi_id }に変える --%>
              <img src="/C1/img/staryellow.svg" width="70" height="70" alt="☆" id="star">
		    </a>
		  </c:if>
          <c:if test="${!empty e.stars_user_id}">
          <%-- この投稿のことをお気に入りしていたら --%>
            <a href="/C1/ReplyServlet?star=1&id=${e.id}">
        	<%-- favoriteはそのまま、idはid=${ cardList.rikishi_id }に変える --%>
              <img src="/C1/img/starwhite.png" width="70" height="70" alt="☆" id="star">
		    </a>
		  </c:if>
        </td>
      </tr>
      <tr>
        <td colspan="3" id="position">
          <img src="${e.pic_movie}" width="70" height="70" alt="投稿" id="syasin">
        </td>
      </tr>
      <tr>
        <td colspan="3">
          ${e.text}
        </td>
      </tr>
    </table>
</c:forEach>
<br>

<form method="post" action="/C1/ReplyServlet">
  <div>
    <label for="reply" id="text">テキストを入力</label><br>
    <input id="reply" type="text" name="text" />
  </div>
  <div>
    <input type="hidden" name="id" value="${contributionsList[0].id}">
    <input type="submit" value="送信" />
  </div>
</form>
  <h1 id="comment">コメント</h1>
  <c:forEach var="e" items="${replyList}" >
    <table class="reply">
     <tr>
       <td>
         <span>${e.user_name}</span>
       </td>
       <td>
         ${e.text}
       </td>
     </tr>
    </table>
  </c:forEach>


</main>
<body>

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