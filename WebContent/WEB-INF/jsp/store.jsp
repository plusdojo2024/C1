<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<%--<hr>
	 <div id="mess">
		<c:if test="${empty cardList}">
			<p>一致するデータはありません。</p>
		</c:if>
	</div> --%>

	<div class="result">
   <h2>両国国技館周辺</h2>
	<%-- <c:forEach var="e" items="${cardList}">--%>
		<form id="regist_form" method="post" action="/C1/ChankoServlet">
			<table class="tb">
				<tr>
					<td>
					<table class="minitable">
					<tr><td>鍋料理 ちゃんこ巴潟 両国店</td></tr>
					<tr><td><a href="https://tabelog.com/tokyo/A1312/A131201/13002987/">食べログ</a></td></tr>
					<tr><td><img src="/C1/img/TokyoStore1.png" width="400" height="400"></td></tr>
					<tr><td><img src="/C1/img/TokyoFood1.png" width="400" height="400"></td></tr>
					</table>
					</td>
					<td>
					<table class="minitable">
					<tr><td>川崎 </td></tr>
					<tr><td><a href="https://tabelog.com/tokyo/A1312/A131201/13002979/">食べログ</a></td></tr>
					<tr><td><img src="/C1/img/TokyoStore2.png" width="400" height="400"></td></tr>
					<tr><td><img src="/C1/img/TokyoFood2.png" width="400" height="400"></td></tr>


					</table>
					</td>
				</tr>




			</table>
 		</form>
<!-- <hr> -->
	<!--  </c:forEach> -->
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