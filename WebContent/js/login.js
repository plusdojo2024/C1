  'use strict';

// HTML要素をオブジェクトとして取得する
let formObj = document.getElementById('login_form');
let errorMessageObj = document.getElementById('error_message');

// [ログイン]ボタンをクリックしたときの処理
formObj.onsubmit = function(event) {
  // idとpwの要素を取得
  let idObj = document.getElementById('login-name');
  let pwObj = document.getElementById('login-pass');

  if (!idObj.value || !pwObj.value) {
    errorMessageObj.textContent = '※IDとパスワードを入力してください！';
    event.preventDefault(); // フォームの送信を防ぐ
    return false;
  }
  errorMessageObj.textContent = null;
};
