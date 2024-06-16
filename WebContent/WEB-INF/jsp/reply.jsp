<!-- reply.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SUMOO</title>
<link rel="stylesheet" href="/C1/css/reply.css">
<link rel="stylesheet" href="/C1/css/common.css">
</head>
<main>
  <h1>ユーザーネーム</h1>
  <!-- ほんとは投稿 -->
  <img src="/simpleBC/img/ホーム.png" width="200" height="100" alt="ホームの男">
  <h1>テキスト</h1>
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