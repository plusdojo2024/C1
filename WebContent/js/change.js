document.addEventListener('DOMContentLoaded', function() {
    const fileInput = document.getElementById('change-icon');
    const fileLabel = document.querySelector('.custom-file-input-label');

    fileInput.addEventListener('change', function() {
        if (fileInput.files.length > 0) {
            fileLabel.textContent = fileInput.files[0].name;
        } else {
            fileLabel.textContent = '画像を選んでください';
        }
    });
});
