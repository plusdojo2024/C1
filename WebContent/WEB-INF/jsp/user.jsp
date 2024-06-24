<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SUMOO | ユーザー検索</title>
<link rel="stylesheet" href="/C1/css/user.css">
<link rel="stylesheet" href="/C1/css/common.css">
</head>
<body class = user-page>
<div class="wrapper" id="top">
<main>
  <!-- ヘッダー（ここから） -->
  <header class="header">
      <div class="logo">
        <h1>ユーザー検索</h1>
      </div>
  </header>
  <!-- ヘッダー（ここまで） -->
<!--   <ul id="nav">
    <a href="/simpleBC/MenuServlet"><li>メニュー</li></a>
    <a href="/simpleBC/SearchServlet"><li>検索(更新・削除)</li></a>
    <a href="/simpleBC/ListServlet"><li>一覧(更新・削除)</li></a>
    <a href="/simpleBC/RegistServlet"><li>　登録　</li></a>
    <a href="/simpleBC/LogoutServlet" id="myLink"><li>ログアウト</li></a>
  </ul> -->
  <!-- メイン（ここから） -->
  <form id="UserSearchform" method="post" action="/C1/UserSearchServlet">
    <table>
      <tr >
        <td>
 	      <input type="text" class="userform" id="userform" placeholder="ユーザーネームを入力してください" name="user_search">
        </td>
        <td>
          <input type="submit" class="userform" id="search" name="submit" value="検索">
        </td>
      </tr>
    </table>


  </form>

  <c:if test="${empty usersList}">
    <p>一致するデータはありません。</p>
  </c:if>

<c:forEach var="e" items="${usersList}">

    <table class="boardpic">
      <tr>
        <c:if test="${e.user_id == User_id}">
        <td>
          <a href="/C1/MyPageServlet">
              <img src="${e.icon}" width="70" height="70" alt="SUMOO | ユーザー検索">
               <%-- src="${user_pic} widthとheightはCSSで決める --%>
		  </a>
        </td>
        <td>
        	<a href="/C1/MyPageServlet">
          		${e.user_name}
          	</a>
        </td>
		</c:if>
		<c:if test="${e.user_id != User_id}">
		<td>
          <a href="/C1/UserPageServlet?Follow_user_id=${e.user_id}">
              <img src="${e.icon}" width="70" height="70" alt="SUMOO | ユーザー検索">
               <%-- src="${user_pic} widthとheightはCSSで決める --%>
		  </a>
		</td>
        <td>
        	<a href="/C1/UserPageServlet?Follow_user_id=${e.user_id}">
          		${e.user_name}
          	</a>
        </td>
	    </c:if>
        <td>
          <c:if test="${empty e.follow_user_id}">
          <%-- このユーザーのことをフォローしていなかったら --%>
            <a href="/C1/UserServlet?follow=0&user_id=${e.user_id}">
        	<%-- followはそのまま、idはid=${ cardList.user_id }に変える --%>
              <img src="/C1/img/heartwhite.png" width="70" height="70" alt="SUMOO | ユーザー検索">
		    </a>
		  </c:if>
          <c:if test="${!empty e.follow_user_id}">
          <%-- このユーザーのことをフォローしていたら --%>
            <a href="/C1/UserServlet?follow=1&user_id=${e.user_id}">
        	<%-- followはそのまま、idはid=${ cardList.user_id }に変える --%>
              <img src="/C1/img/heartred.svg" width="70" height="70" alt="SUMOO | ユーザー検索">
		    </a>
		  </c:if>
        </td>
      </tr>
    </table>
</c:forEach>
<!--     </form> -->
<%--   </c:forEach> --%>

  <!-- メイン（ここまで） -->
  </main>
  <!-- フッター（ここから） -->　
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
</div>
  <!-- フッター（ここまで） -->
<!-- JavaScript（ここから） -->

<!--
<script>
/* submitボタンをクリックしたときの処理 */
function submitClick() {
  /* 確認ダイアログボックスを表示します */
  if (!window.confirm('実行します。よろしいですか？')) {
    return false;
  }
}

/* HTML要素をオブジェクトとして取得する */
let formObjs = document.getElementsByClassName('search_result');

/* 取得したすべてのオブジェクトに同じイベントを適用する */
for (let item of formObjs) {
  item.onsubmit = submitClick;
}
</script>
<script src="/simpleBC/js/script.js"></script>

-->
<!-- JavaScript（ここまで） -->

</body>
</html>