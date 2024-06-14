<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SUMOO | ユーザー検索</title>
<link rel="stylesheet" href="/C1/css/user.css">
</head>
<body>
<div class="wrapper" id="top">
  <!-- ヘッダー（ここから） -->
  <header class="header">
    <a href="/C1/MenuServlet">
      <div class="logo">
        <h2>ユーザー検索</h2>
      </div>
    </a>
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
  <form>
    <table>
      <tr>
        <td>
 	      <input type="text" placeholder="ユーザーネームを入力してください" name="user_search">
        </td>
        <td>
          <input type="submit" id="search" name="submit" value="検索">
        </td>
      </tr>
    </table>


  </form>

  <%-- <c:if test="${empty cardList}">
    <p>一致するデータはありません。</p>
  </c:if> --%>


<%--   <c:forEach var="e" items="${cardList}" > --%>
    <form class="search_result" method="post" action="/C1/UserServlet">
    <table>
      <tr>
      <a href="/C1/UserPageServlet?id=0">
      <%-- id=${ cardList.user_id } --%>
        <td>
            <input type="image" src="/C1/img/daiamami.png" alt="SUMOO | ユーザー検索" value="daiamami">
            <!--
             各ユーザーのページに直接飛ぶことができる
            ということはここが押されたらユーザーのURLを
            渡して、そのページにリダイレクトする
            srcの中身はアイコンで、valueの中身はユーザーのURLだといいかも
            それで、サーブレットでユーザーのURLが渡されたらそのユーザーページに遷移するとする-->


        </td>
        <td>
          ユーザー名
        </td>
        <td>
          <input type="image" src="/C1/img/daiamami.png" width="30" height="30" alt="SUMOO | ユーザー検索" value="フォロー">
            <!-- フォローを属性にしたinputにして、これが押されたら
             doPostでfollowsテーブルにレコードを追加する。
            そして、フォローしたという情報をもって再びこのページにフォワードする
            srcの中身はフォローの画像で、valueの中身はそのユーザーのIDがいいかな？
            それで、サーブレットでユーザーIDが渡されたら、自分のIDとそのユーザーのIDで
            followsテーブルにレコードを追加する。
            width,heightはいい感じで-->
        </td>
      </a>
      </tr>
    </table>
    </form>
    <hr>
<%--   </c:forEach> --%>

  <!-- メイン（ここまで） -->
  <!-- フッター（ここから） -->
  <div id="footer">
    <p class="copyright">Copyright&copy; managebusiness Co.,Ltd All Rights Reserved.</p>
  </div>
  <!-- フッター（ここまで） -->
</div>
<!-- JavaScript（ここから） -->
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
<!-- JavaScript（ここまで） -->

</body>
</html>