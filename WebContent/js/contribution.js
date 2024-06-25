 const inputElm = document.getElementById('inputElm');
    inputElm.addEventListener('change', (e) => {
        const file = e.target.files[0];

        const fileReader = new FileReader();
        // 画像を読み込む
        fileReader.readAsDataURL(file);

        // 画像読み込み完了時の処理
        fileReader.addEventListener('load', (e) => {
            // imgタグ生成
            const imgElm = document.createElement('img');
            imgElm.src = e.target.result; // e.target.resultに読み込んだ画像のURLが入っている

            // imgタグを挿入
            const targetElm = document.getElementById('preview');
            targetElm.appendChild(imgElm);
        });
    });