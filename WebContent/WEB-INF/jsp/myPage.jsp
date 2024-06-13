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
<p><a href="/C1/FllowServlet">フォロー中のユーザー一覧</a></p>
<p><a href="/C1/StarsServlet">白星一覧</a></p>
<p><a href="/C1/SearchServlet">設定</a></p>
<p><a href="/C1/LoginServlet" id="logout">ログアウト</a></p>
      </ul>
    </nav>
  </header>
  <main>
  <!-- ほんとは自分のアイコンが入る-->
    <img src="/simpleBC/img/ホーム.png" width="200" height="100" alt="ホームの男">
    <h1 class="user_name">ユーザーネーム</h1>
    <h1 class="message">メッセージ</h1>
    <h1 class="oshirikishi">推し力士</h1>
  <!-- ほんとは推しの力士のアイコンが入る-->
    <img src="/simpleBC/img/ホーム.png" width="200" height="100" alt="ホームの男">
    <h1 class="toko">投稿一覧</h1>

  </main>
  <footer>
  <p><a href="/C1/StandByServlet">待機部屋</a></p>
  <p><a href="/C1/UserSearchServlet">ユーザー検索</a></p>
  <p><a href="/C1/RikishiSearchServlet">力士一覧</a></p>
  <p><a href="/C1/ChankoServlet">レシピ検索</a></p>
  <p><a href="/C1/SchoolServlet">教習所</a></p>
  <p><a href="/C1/MyPageServlet">マイページ</a></p>
  </footer>
</body>
<script>
  'use strict';
  document.getElementById("logout").onclick = function() {
  if(window.confirm('ログアウトしますか')) {
  }
  else{
  (console.log('クリックされました'));
   event.preventDefault();
  }
  }
</script>
</html>