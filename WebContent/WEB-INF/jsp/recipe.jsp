<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レシピ</title>
<link rel="stylesheet" type="text/css" href="/C1/css/chanko.css">
<link rel="stylesheet" href="/C1/css/common.css">
</head>



<body>
<main>
	<h1 class="chankopic">レシピ（検索結果）</h1>


 	<%--<hr>
	 <div id="mess">
		<c:if test="${empty cardList}">
			<p>一致するデータはありません。</p>
		</c:if>
	</div> --%>



	<%-- <c:forEach var="e" items="${cardList}">--%>
		<form id="regist_form" method="post" action="/C1/"ChankoServlet">
			<table class="tb">
				<tr>
					<td>
					<table class="minitable">
					<tr><td><img src="/C1/img/recipepicture.png"></td></tr>
					<tr><td>鍋</td></tr>
					<tr><td>雪見ちゃんこ</td></tr>
					<tr><td>伊勢ケ浜部屋</td></tr>

					</table>
					</td>
					<td>
					<table class="minitable">
					<tr><td>か</td></tr>
					<tr><td>か</td></tr>
					<tr><td>か</td></tr>
					<tr><td>か</td></tr>

					</table>
					</td>
				</tr>




			</table>
 		</form>
		<!--<hr>
	 </c:forEach>  -->
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