const qtdDadosGrafico = 5;


// ESSA É A VARIAVEL ONDE OS DADOS VÃO SER INSERIDOS
var dados = {
    // AQUI É INSERIDO A DATA E HORA
    data: {
        labels: [],
        datasets: [
            {
                yAxisID: 'y-usoTotal',
                label: 'CPU',
                borderColor: '#2222DD',
                backgroundColor: '#00000033',
                data: []// AQUI É INSERIDO A OS DADOS OU SEJA A QUANTIDADE QUE VAI SER EXIBIDA NO GRAFICO
            },
        ]
    }
};
// ESSAS FUNÇÕES SERVEM APENAS PARA MUDAR O FORMATO DA DATA E HORA

function alteraData(data) {
    var dataFormatada = data.substring(0, data.indexOf("T"));
    var dadosData = dataFormatada.split("-");

    var dataFinal = dadosData[2] + "/" + dadosData[1] + "/" + dadosData[0] + " ";
    return dataFinal;
}
function alteraHora(Hora) {
    var horaFormatada = Hora.substring(11, Hora.indexOf("."));
    return horaFormatada;
}

let pesquisas = 0;

// AQUI FAZEMOS AS PESQUISAS NO BANCO E APAGAMOS OS DADOS DO ARRAY DE DADOS ### A FUNÇÃO QUE ESTÁ SENDO RODADA VARIAS VEZES
function receberNovasLeituras() {
    setTimeout(() => {

        // AQUI VC FAZ A CHAMADA PARA O BACKEND PARA RECUPERAR OS DADOS
        // USANDO O FETCH()
        fkComp.value = sessionStorage.fkcomputer;
        var formulario = new URLSearchParams(new FormData(form_fk));
        fetch("/usoTotal/recuperarCPU", {
            method: "POST",
            body: formulario
        }).then(response => {

            if (response.ok) {

                response.json().then(json => {
                    console.log("FIZ LEITURA DE DADOS DO BANCO" + pesquisas)
                    pesquisas++;

                    json.reverse();
                    // tirando e colocando valores no gráfico
                    // incluir uma nova leitura
                    if (dados.data.datasets[0].data.length == 0) {
                        for (let i = 0; i < qtdDadosGrafico; i++) {
                            dados.data.labels.push(alteraData(json[i].dataHora) + alteraHora(json[i].dataHora)); // incluir um novo momento
                            dados.data.datasets[0].data.push(json[i].usoComponente);
                        }
                    } else {
                        for (let i = 0; i < json.length; i++) {
                            dados.data.labels.shift(); // apagar o primeiro
                            dados.data.labels.push(alteraData(json[i].dataHora) + alteraHora(json[i].dataHora)); // incluir um novo momento
                            dados.data.datasets[0].data.shift();  // apagar o primeiro
                            dados.data.datasets[0].data.push(json[i].usoComponente);
                        }
                    }
                    // Atualiza o gráfico
                    window.graficoLinha.update();

                    // agendar a chamada da mesma função para daqui a 7 segundos
                    receberNovasLeituras();

                }); // 7000 ms -> 7 segundos
            } else {
                console.error('Nenhum dado encontrado ou erro na API');
            }
        });
    }, 7000);
}

// CONFIGURAÇÃO DO GRAFICO
function configurarGrafico() {
    var configuracoes = {
        responsive: true,
        animation: { duration: 500 },
        hoverMode: 'index',
        stacked: false,
        title: {
            display: true,
            text: 'Uso Total da CPU'
        },
        gridLines: {
            drawBorder: false
        },
        scales: {
            yAxes: [{
                // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                display: true,
                position: 'left',
                id: 'y-usoTotal',
            }],
        }
    };

    return configuracoes;
}
function plotarGrafico() {

    // criação do gráfico na página
    var ctx = document.getElementById('grafico_cpu').getContext('2d');
    window.graficoLinha = new Chart(ctx, {
        type: 'line',
        data: dados.data,
        options: configurarGrafico()
    });

    // função que agenda a recuperação da última leitura para daqui a 7 segundos
    receberNovasLeituras();
}

window.onload = plotarGrafico;