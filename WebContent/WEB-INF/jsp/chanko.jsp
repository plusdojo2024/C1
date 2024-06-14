<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ちゃんこ</title>
<link rel="stylesheet" type="text/css" href="/C1/css/chanko.css">
</head>
<body>
   <h1 class="chankopic">ちゃんこ</h1>


    <h2>レシピ検索</h2>
    <form method="post" action="/C1/ChankoServlet">

    <p>
        力士名<br>
        <select name=" recipe">
            <option value="1">熱海富士朔太郎</option>
            <option value="2">遠藤聖大</option>
            <option value="3">炎鵬友哉</option>
            <option value="4">大奄美元規</option>
            <option value="5">大の里泰輝</option>
            <option value="6">尊富士弥輝也</option>
        </select>
    </p>
    <p>
        部屋名<br>
        <select name="sumostable">
            <option value="1">伊勢ヶ濱部屋</option>
            <option value="2">追手風部屋</option>
            <option value="3">二所ノ関部屋</option>
        </select>
    </p>
    <p>
        カテゴリー<br>
        <select name="category">
            <option value="1">鍋</option>
            <option value="2">からあげ</option>
            <option value="3">餃子</option>
        </select>
    </p>
    <p class="submit">
            <input type="submit" name="submit" value="レシピ検索">
    </p>
    </form>


    <h2>お店検索</h2>
    <form method="post" action="/C1/ChankoServlet">

        <p>
            会場<br>
            <select name=" venue">
                <option value="1">東京：両国国技館</option>
                <option value="2">大阪：エディオンアリーナ大阪</option>
                <option value="3">名古屋：愛知国際アリーナ</option>
                <option value="4">福岡：福岡国際センター</option>
            </select>
        </p>

        <p class="submit">
                <input type="submit" name="submit" value="お店検索">
        </p>
        </form>

</body>
</html>