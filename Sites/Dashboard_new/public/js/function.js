function abrirModal() {
    document.getElementById('modal').style.display = 'block';
    document.getElementById('header__profile').style.border = '#2f2f2f 0.5px solid';
    document.getElementById('header__profile').style.borderRadius = '29px';
}

function fecharModal() {
    document.getElementById('modal').style.display = 'none';
    document.getElementById('header__profile').style.border = '';
    document.getElementById('header__profile').style.borderRadius = '';
}

function finalizar_sessao(Page) {
    var login_usuario = sessionStorage.login_usuario_meuapp;
    fetch(`/tecnico/sair/${login_usuario}`, { cache: 'no-store' });
    sessionStorage.clear();
    window.location = Page;
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