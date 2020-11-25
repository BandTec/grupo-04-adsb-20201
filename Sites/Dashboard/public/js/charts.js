
var dados = {
    labels: [],
    datasets: [
        {
            yAxisID: 'y-usoTotal',
            label: 'CPU',
            borderColor: '#2222DD',
            backgroundColor: '#00000033',
            data: []
        },
    ]
};
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
// altere aqui como os dados serão exibidos
// e como são recuperados do BackEnd
function obterDadosGrafico() {
    fkComp.value = sessionStorage.fkcomputer;
    var formulario = new URLSearchParams(new FormData(form_fk));
    fetch("/usoTotal/recuperarCPU", {
        method: "POST",
        body: formulario
    }).then(response => {

        if (response.ok) {

            response.json().then(json => {
                console.log(json);
                console.log("DADOS " + dados.datasets[0].data);
                if (dados.datasets[0].data.length > 3) {
                    dados.labels.shift();
                    dados.labels.push(alteraData(json[0].dataHora) + alteraHora(json[0].dataHora));
                    dados.datasets[0].data.shift();
                    dados.datasets[0].data.push(json[0].usoComponente);
                    window.grafico_linha.update();
                } else {
                    dados.labels.push(alteraData(json[0].dataHora) + alteraHora(json[0].dataHora));
                    dados.datasets[0].data.push(json[0].usoComponente);
                }

                plotarGrafico(dados);

            });

        } else {
            console.error('Nenhum dado encontrado ou erro na API');
        }
    });
}

obterDadosGrafico()

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
                type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                display: true,
                position: 'left',
                id: 'y-usoTotal',
            }],
        }
    };

    return configuracoes;
}
// só altere aqui se souber o que está fazendo!
function plotarGrafico(dados) {
    // console.log("dados", dados);
    console.log('iniciando plotagem do gráfico...');

    var ctx = grafico_cpu.getContext('2d');
    window.grafico_linha = Chart.Line(ctx, {
        data: dados,
        options: configurarGrafico()
    });
    setInterval(obterDadosGrafico, 10000);
}

