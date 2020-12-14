let processoExcluir = 0;

function abrirPopUp(idProcesso) {
    bgPopUpAlerta.style.display = 'block';
    divPopUpAlerta.style.display = 'flex';
    PopUpAlerta.style.display = 'flex';
    processoExcluir = idProcesso;
}

function fecharPopUp() {
    bgPopUpAlerta.style.display = 'none';
    divPopUpAlerta.style.display = 'none';
    PopUpAlerta.style.display = 'none';
    processoExcluir = 0;
}


function removerProcessoEscola() {
    fetch(`/blacklist/deletar_processos_escola/${sessionStorage.fkEscola}/${processoExcluir}`, {
        method: "POST",
    }).then(response => {
        if (response.ok) {

            response.json().then(json => {
                resposta_cadastro.innerHTML = "<span style='color: green'>Processo excluido</span>";
                recuperaProcessosEscola();
                fecharPopUp()
            });

        } else {
            console.error('Nenhum dado encontrado ou erro na API');
        }
    });
}