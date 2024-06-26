'use strict';

// 画像切り替え時にプレビュー表示
document.getElementById('form').addEventListener('change', function(e) {
    var reader = new FileReader();
    reader.onload = function(e) {
        document.getElementById('user-icon').src = e.target.result;
    }
    reader.readAsDataURL(e.target.files[0]);
});

// 削除ボタンクリック時にフォームとプレビューを初期化
document.getElementById('delete').addEventListener('click', function(e) {
    document.getElementById('user-icon').src = '/C1/img/default.png';
    document.getElementById('form').value = '';
});
