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
<main>
<div class="wrapper" id="top">
  <!-- ヘッダー（ここから） -->
  <header class="header">
      <div class="logo">
        <h2>ユーザー検索</h2>
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

  <%-- <c:if test="${empty cardList}">
    <p>一致するデータはありません。</p>
  </c:if> --%>

<%--   <c:forEach var="e" items="${cardList}" > --%>
<!--     <form class="search_result" method="post" action="/C1/UserServlet"> -->
    <table class="boardpic">
      <tr>
        <td>
        <a href="/C1/UserPageServlet?id=0">
            <img src="/C1/img/daiamami.png" width="40" height="40" alt="SUMOO | ユーザー検索">
            <!--
             src="${user_pic} widthとheightはCSSで決める
             -->

		</a>
        </td>
        <td>
          ユーザー名
        </td>
        <td>
          <c:if test="false">
          <%-- このユーザーのことをフォローしていなかったら --%>
            <a href="/C1/UserServlet?follow=0&id=0">
        	<%-- followはそのまま、idはid=${ cardList.user_id }に変える --%>
              <img src="/C1/img/heartwhite.png" width="30" height="30" alt="SUMOO | ユーザー検索">
		    </a>
		  </c:if>
          <c:if test="true">
          <%-- このユーザーのことをフォローしていたら --%>
            <a href="/C1/UserServlet?follow=1&id=0">
        	<%-- followはそのまま、idはid=${ cardList.user_id }に変える --%>
              <img src="/C1/img/heartred.svg" width="30" height="30" alt="SUMOO | ユーザー検索">
		    </a>
		  </c:if>
        </td>
      </tr>
    </table>
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