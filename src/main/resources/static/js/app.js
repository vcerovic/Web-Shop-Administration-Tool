const preloader = document.getElementById("preloader");

//Preloader animation
window.addEventListener("load", () => {
    setTimeout(() => {
        preloader.classList.add("hidden");
        setTimeout(() => {
            preloader.parentNode.removeChild(preloader);
        }, 200)
    }, 300);
});
