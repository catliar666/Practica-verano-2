document.addEventListener('DOMContentLoaded', function() {
    const pwShowHide = document.querySelectorAll(".bx-lock-alt.icon");

    pwShowHide.forEach((icon) => {
        icon.addEventListener("click", () => {
            let getPwInput = icon.previousElementSibling;

            if (getPwInput.type === "password") {
                getPwInput.type = "text";
                icon.classList.replace("bx-lock-alt", "bx-lock-open-alt");
            } else {
                getPwInput.type = "password";
                icon.classList.replace("bx-lock-open-alt", "bx-lock-alt");
            }
        });
    });
});

