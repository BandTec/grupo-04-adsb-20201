let processosBloqueadosMaquina = []
function recuperaProcessosComputador() {
    fetch(`/blacklist/recuperar_processos_computador/${sessionStorage.idComputador}`, {
        method: "POST",
    }).then(response => {
        if (response.ok) {

            response.json().then(json => {
                for (let i = 0; i < json.length; i++) {
                    processosBloqueadosMaquina.push(json[i].nomeProcesso);

                    tabela_processos_blacklist.innerHTML += `
                            <tr>
                                <td>${json[i].nomeProcesso}</td>
                            </tr>
                        `;
                }

            });

        } else {
            console.error('Nenhum dado encontrado ou erro na API');
        }
    });
}

function recuperaProcessosEscola() {
    fetch(`/blacklist/recuperar_processos/${sessionStorage.fkEscola}`, {
        method: "POST",
    }).then(response => {
        if (response.ok) {

            response.json().then(json => {
                for (let i = 0; i < json.length; i++) {
                    for (let j = 0; j < processosBloqueadosMaquina.length; j++) {
                        if (processosBloqueadosMaquina[j] == json[i].nomeProcesso) {
                            json[i].nomeProcesso = '';
                        }
                    }
                }
                let contadorVazios = 0;
                debugger;
                for (let i = 0; i < json.length; i++) {

                    if (json[i].nomeProcesso != '') {
                        processos_escola.innerHTML += `
                                <option value="${json[i].idBlacklist}">${json[i].nomeProcesso}</option>
                            `;
                    } else {
                        contadorVazios++;
                    }

                }
                if (contadorVazios == json.length) {
                    processos_escola.innerHTML = `
                                <option value="">Todos os processos foram adicionados</option>
                            `;
                }
            });

        } else {
            console.error('Nenhum dado encontrado ou erro na API');
        }
    });
}

function inserirProcessoBlacklistMaquina() {
    let processoSelecionado = processos_escola.value;
    alert(processoSelecionado)
    if (processoSelecionado != "") {
        fetch(`/blacklist/inserir_computador_has_blacklist/${sessionStorage.idComputador}/${processoSelecionado}`, {
            method: "POST",
        }).then(response => {
            if (response.ok) {

                response.json().then(json => {
                    alert("Adicionado com sucesso");
                });

            } else {
                console.error('Nenhum dado encontrado ou erro na API');
            }
        });
    } else {
        alert("Selecione um processo");
    }

}
