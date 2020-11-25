
var dados = {
    labels: [],
    datasets: [
        {
            yAxisID: 'y-usoTotal',
            label: 'CPU',
            borderColor: '#2222FF',
            backgroundColor: '#000',
            data: []
        },
    ]
};

// altere aqui como os dados serão exibidos
// e como são recuperados do BackEnd
function obterDadosGrafico() {

    fetch("/usoTotal/recuperarCPU", {
        method: "GET",
    }).then(response => {

        if (response.ok) {

            response.json().then(json => {
                console.log(json);


                if (dados.datasets[0].data.length == 3) {
                    dados.labels.shift();
                    dados.labels.push(json[0].dataHora) // apagar o primeiro
                    dados.datasets[0].data.shift();  // apagar o primeiro de uso
                    dados.datasets[0].data.push(json[0].usoComponente);
                    window.grafico_linha.update();
                } else {
                    for (i = 0; i < 3; i++) {
                        dados.labels.push(json[0].dataHora);
                        dados.datasets[0].data.push(json[0].usoComponente);
                    }
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
        scales: {
            yAxes: [{
                type: 'linear', // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
                display: true,
                position: 'left',
                id: 'y-usoTotal',
            },],
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

    setTimeout(obterDadosGrafico, 20000);
}

