function Menu() {
    let stateMenu = menuBar.style.left;
    if (stateMenu == "-1000px") {
        menuBar.style.left = "0px";
    } else {
        menuBar.style.left = "-1000px";
    }
}