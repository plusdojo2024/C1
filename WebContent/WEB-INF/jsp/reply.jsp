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
</head>
<main>
<c:forEach var="e" items="${contributionsList}" >
<table class="boardpic">
      <tr>
        <td>
        <!-- ユーザーネーム、アイコン -->
        	<%-- idはid=${ cardList.rikishi_id }に変える --%>

            <img src="${e.icon}" width="70" height="70" alt="アイコン">
            <!--
             src="${rikishi_pic} widthとheightはCSSで決める
             -->
        </td>
        <td>
          ${e.user_name}
        </td>
        <td>
          <c:if test="false">
          <%-- この投稿のことをお気に入りしていなかったら --%>
            <a href="/C1/ContributionServlet?star=0&${e.id}">
        	<%-- favoriteはそのまま、idはid=${ cardList.rikishi_id }に変える --%>
              <img src="/C1/img/staryellow.svg" width="70" height="70" alt="☆">
		    </a>
		  </c:if>
          <c:if test="true">
          <%-- この投稿のことをお気に入りしていたら --%>
            <a href="/C1/ContributionServlet?star=1&${e.id}">
        	<%-- favoriteはそのまま、idはid=${ cardList.rikishi_id }に変える --%>
              <img src="/C1/img/starwhite.png" width="70" height="70" alt="☆">
		    </a>
		  </c:if>
        </td>
      </tr>
      <tr>
        <td colspan="3">
          <img src="${e.pic_movie}" width="70" height="70" alt="投稿">
        </td>
      </tr>
      <tr>
        <td colspan="3">
          ${e.text}
        </td>
      </tr>
    </table>
</c:forEach>


<form>
  <div>
    <label for="reply">テキストを入力</label><br>
    <input id="reply" type="text" name="text" />
  </div>
  <div>
    <input type="submit" value="送信" />
  </div>

  <h1>他のユーザーの返信</h1>
</form>

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