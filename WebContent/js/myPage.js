  'use strict';
  document.getElementById("logout").onclick = function() {
  if(window.confirm('ログアウトしますか')) {
  }
  else{
  (console.log('クリックされました'));
   event.preventDefault();
  }
  }
