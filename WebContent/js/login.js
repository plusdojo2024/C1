
  // HTML要素をオブジェクトとして取得する
  let formObj = document.getElementById('login_form');
  let errorMessageObj = document.getElementById('error_message');

  /* [ログイン]ボタンをクリックしたときの処理 */
  formObj.onsubmit = function() {
    if (!formObj.id.value || !formObj.pw.value) {
      errorMessageObj.textContent = '※IDとパスワードを入力してください！';
      return false;
    }
    errorMessageObj.textContent = null;
  };