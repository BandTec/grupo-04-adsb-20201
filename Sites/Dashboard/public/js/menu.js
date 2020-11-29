function Menu() {
    let stateMenu = menuBar.style.left;
    if (stateMenu == "-1000px") {
        menuBar.style.left = "0px";
    } else {
        menuBar.style.left = "-1000px";
    }
}

function insertMenu() {
    var txtFile = new XMLHttpRequest();
    txtFile.open("GET", "http://localhost:3500/menu.html", true);
    txtFile.onreadystatechange = function () {
        if (txtFile.readyState === 4) {
            if (txtFile.status === 200) {
                menuBar.innerHTML = txtFile.responseText;
            }
        }
    }
    txtFile.send(null)
}
insertMenu();

function finalizar_sessao() {
    var login_usuario = sessionStorage.login_usuario_meuapp;
    fetch(`/tecnico/sair/${login_usuario}`, { cache: 'no-store' });
    sessionStorage.clear();
    window.location = 'login.html';
}

function validar_sessao() {
    var login_usuario = sessionStorage.login_usuario_meuapp;
    fetch(`/tecnico/sessao/${login_usuario}`, { cache: 'no-store' })
        .then(resposta => {
            if (resposta.ok) {
                resposta.text().then(texto => {
                    console.log('Sessão :) ', texto);
                });
            } else {
                console.error('Sessão :.( ');
                finalizar_sessao();
            }
        });
}

validar_sessao();
