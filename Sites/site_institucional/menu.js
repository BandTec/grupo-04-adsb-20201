window.onscroll = function () { myFunction() };


function myFunction() {
    if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
        bkGroundMenu.style.height = "100px";
    } else {
        bkGroundMenu.style.height = "0px";
    }
}