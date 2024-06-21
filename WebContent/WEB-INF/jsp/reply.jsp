<!-- reply.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SUMOO</title>
<link rel="stylesheet" href="/C1/css/reply.css">
<link rel="stylesheet" href="/C1/css/common.css">
</head>
<main>

<table class="boardpic">
      <tr>
        <td>
        <!-- ユーザーネーム、アイコン -->
        <a href="/C1/UserPageServlet?${e.id}">
        	<%-- idはid=${ cardList.rikishi_id }に変える --%>
            <img src="${e.pic_movie}" width="70" height="70" alt="投稿">
            <!--
             src="${rikishi_pic} widthとheightはCSSで決める
             -->
		</a>
        </td>
        <td>
          ${e.user_id}
        </td>
        <td>
          <c:if test="false">
          <%-- この投稿のことをお気に入りしていなかったら --%>
            <a href="/C1/RikishiServlet?favorite=0&${e.id}">
        	<%-- favoriteはそのまま、idはid=${ cardList.rikishi_id }に変える --%>
              <img src="/C1/img/starwhite.png" width="70" height="70" alt="☆">
		    </a>
		  </c:if>
          <c:if test="true">
          <%-- この投稿のことをお気に入りしていたら --%>
            <a href="/C1/RikishiServlet?favorite=1&${e.id}">
        	<%-- favoriteはそのまま、idはid=${ cardList.rikishi_id }に変える --%>
              <img src="/C1/img/staryellow.svg" width="70" height="70" alt="色付き☆">
		    </a>
		  </c:if>
        </td>
      </tr>
    </table>



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