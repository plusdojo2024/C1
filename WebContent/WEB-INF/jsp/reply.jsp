<!-- reply.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SUMOO</title>
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
  <p><a href="/C1/StandByServlet">待機部屋</a></p>
  <p><a href="/C1/UserSearchServlet">ユーザー検索</a></p>
  <p><a href="/C1/RikishiSearchServlet">力士一覧</a></p>
  <p><a href="/C1/ChankoServlet">レシピ検索</a></p>
  <p><a href="/C1/SchoolServlet">教習所</a></p>
  <p><a href="/C1/MyPageServlet">マイページ</a></p>
  </footer>
</html>