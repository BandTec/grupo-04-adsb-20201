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