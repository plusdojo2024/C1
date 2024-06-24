<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SUMOO | フォロー中ユーザー一覧</title>
<link rel="stylesheet" href="/C1/css/follow.css">
<link rel="stylesheet" href="/C1/css/common.css">
</head>
<body class = follow-page>
<div class="wrapper" id="top">
  <!-- ヘッダー（ここから） -->
  <header class="header">
      <div class="logo">
        <h1>フォロー中ユーザー一覧</h1>
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

  <%-- <c:if test="${empty cardList}">
    <p>一致するデータはありません。</p>
  </c:if> --%>

<c:forEach var="e" items="${followsList}">
<form class="search_result" method="post" action="/C1/UserServlet">
    <table class="boardpic">
      <tr>
        <td>
        <a href="/C1/UserPageServlet?"user_id=${e.user_id}>
            <img src="${e.user_name}" width="70" height="70" alt="SUMOO | フォロー中ユーザー一覧">
            <!--
             src="${user_pic} widthとheightはCSSで決める
             -->
		</a>
        </td>

		<td>
			<td><a href="/C1/RoomServlet?user_id=${e.user_id}">
			${e.follow_user_id} </a></td>

        <td>
          <a href="/C1/FollowServlet?follow=1&id=${e.user_id}">
          <%-- followはそのまま、idはid=${ cardList.user_id }に変える --%>
            <img src="/C1/img/heartred.svg" width="70" height="70">
		  </a>
        </td>
      </tr>
    </table>
</form>
</c:forEach>

  <!-- メイン（ここまで） -->
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
  <!-- フッター（ここまで） -->
</div>
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