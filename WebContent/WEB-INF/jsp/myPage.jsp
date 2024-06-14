<!--myPage.jsp-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<! DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>SUMOO</title>
  <link rel="stylesheet" href="/C1/css/myPage.css">

</head>
<body id="top">
  <!--ヘッダー-->
  <header class="header">
    <nav class="nav">
      <ul>
<a href="/C1/FllowServlet"><img src="/C1/img/heartred.svg"></a><!-- フォロー一覧 -->
<a href="/C1/StarsServlet"><img src="/C1/img/starwhite.png" ></a><!-- 白星一覧 -->
<a href="/C1/ChangeServlet"><img src="/C1/img/settei.svg"></a><!-- 設定 -->
<a href="/C1/LoginServlet" id="logout"><img src="/C1/img/logout.svg" ></a><!-- ログアウト -->
      </ul>
    </nav>
  </header>
  <main>
  <!-- ほんとは自分のアイコンが入る-->
    <img src="/simpleBC/img/ホーム.png" >
    <h1 class="user_name">ユーザーネーム</h1>
    <h1 class="message">メッセージ</h1>
    <h1 class="oshirikishi">推し力士</h1>
  <!-- ほんとは推しの力士のアイコンが入る-->
    <img src="/simpleBC/img/ホーム.png">
    <h1 class="toko">投稿一覧</h1>

  </main>
  <footer>
  <p><a href="/C1/StandByServlet"><img src="/C1/img/taikibeya.png" ></a></p>
  <p><a href="/C1/UserSearchServlet"><img src="/C1/img/usersearch.png"></a></p>
  <p><a href="/C1/RikishiSearchServlet"><img src="/C1/img/rikishiichiran.png"></a></p>
  <p><a href="/C1/ChankoServlet"><img src="/C1/img/recipe.png"></a></p>
  <p><a href="/C1/SchoolServlet"><img src="/C1/img/school.png"></a></p>
  <p><a href="/C1/MyPageServlet"><img src="/C1/img/mypage.png" ></a></p>
  </footer>
</body>
	<!--JavaScriptを読み込む-->
	<script src="/C1/js/myPage.js"></script>
</html>