const qtdDadosGrafico = 5;
let primeiraVezCPU = true;
let primeiraVezMemoria = true;
let target;
let gaugeCPU;
let gaugeMemoria;
let tempoRecuperacao = 700;
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
function receberNovasLeituras(tipoComponente) {
    // AQUI VC FAZ A CHAMADA PARA O BACKEND PARA RECUPERAR OS DADOS
    // USANDO O FETCH()
    fetch(`/usoTotal/recuperar/${sessionStorage.idComputador}/${tipoComponente}`, {
        method: "GET",
    }).then(response => {

        if (response.ok) {

            response.json().then(json => {
                console.log("FIZ LEITURA DE DADOS DO BANCO " + pesquisas)
                pesquisas++;

                json.reverse();
                let resposta = JSON.parse(JSON.stringify(json));
                console.log("RESPOSTA" + resposta);
                if (tipoComponente == "CPU") {
                    plotarGraficoCPU(resposta[0].usoComponente);
                }
                if (tipoComponente == "Ram") {
                    plotarGraficoMemoria(resposta[0].usoComponente);
                }

                // tirando e colocando valores no gráfico
                // incluir uma nova leitura
                // let resposta = JSON.parse(JSON.stringify(json));
                // if (dados.data.datasets[0].data.length == 0) {



                //     for (let i = 0; i < qtdDadosGrafico; i++) {
                //         dados.data.labels.push(alteraData(resposta[i].dataHora) + alteraHora(resposta[i].dataHora)); // incluir um novo momento
                //         dados.data.datasets[0].data.push(resposta[i].usoComponente);
                //     }
                // } else {
                //     for (let i = 0; i < json.length; i++) {
                //         dados.data.labels.shift(); // apagar o primeiro
                //         dados.data.labels.push(alteraData(resposta[i].dataHora) + alteraHora(resposta[i].dataHora)); // incluir um novo momento
                //         dados.data.datasets[0].data.shift();  // apagar o primeiro
                //         dados.data.datasets[0].data.push(resposta[i].usoComponente);
                //     }
                // }
                // // Atualiza o gráfico
                // window.graficoLinha.update();

                // // agendar a chamada da mesma função para daqui a 7 segundos
                // receberNovasLeituras();

            });
        } else {
            uso_memoria.innerHTML = "Dados não encontrados";
            if (tipoComponente == "CPU") {
                plotarGraficoCPU(0);
            }
            if (tipoComponente == "Ram") {
                plotarGraficoMemoria(0);
            }

            console.error('Nenhum dado encontrado ou erro na API');

        }
    });

}


function atualizaGraficos() {
    setTimeout(() => {
        receberNovasLeituras("CPU");
        receberNovasLeituras("Ram");
        atualizaGraficos()
    }, tempoRecuperacao)
}

// CONFIGURAÇÃO DO GRAFICO
function configurarGrafico() {
    var opts = {
        staticZones: [
            { strokeStyle: "#30b32d", min: 0, max: 50, height: 0.6 },
            { strokeStyle: "#ffdd00", min: 50, max: 80, height: 0.6 },
            { strokeStyle: "#f03e3e", min: 80, max: 100, height: 0.6 }
        ],
        staticLabels: {
            font: "10px sans-serif",  // Specifies font
            labels: [0, 50, 100],  // Print labels at these values
            color: "#000000",  // Optional: Label text color
            fractionDigits: 0  // Optional: Numerical precision. 0=round off.
        },
        angle: -0.2, // The span of the gauge arc
        lineWidth: 0.2, // The line thickness
        radiusScale: 0.63, // Relative radius
        pointer: {
            length: 0.58, // // Relative to gauge radius
            strokeWidth: 0.06, // The thickness
            color: '#000000' // Fill color
        },
        limitMax: false,     // If false, max value increases automatically if value > maxValue
        limitMin: false,     // If true, the min value of the gauge will be fixed
        colorStart: '#6F6EA0',   // Colors
        colorStop: '#C0C0DB',    // just experiment with them
        strokeColor: '#EEEEEE',  // to see which ones work best for you
        generateGradient: true,
        highDpiSupport: true,     // High resolution support

    };


    // var configuracoes = {
    //     responsive: true,
    //     animation: { duration: 500 },
    //     hoverMode: 'index',
    //     stacked: false,
    //     title: {
    //         display: true,
    //         text: 'Uso Total da CPU'
    //     },
    //     gridLines: {
    //         drawBorder: false
    //     },
    //     scales: {
    //         yAxes: [{
    //             // only linear but allow scale type registration. This allows extensions to exist solely for log scale for instance
    //             display: true,
    //             position: 'left',
    //             id: 'y-usoTotal',
    //         }],
    //     }
    // };

    return opts;
}
// create sexy gauge!



function plotarGraficoCPU(dado) {
    if (primeiraVezCPU) {
        target = document.getElementById('grafico_cpu'); // your canvas element
        gaugeCPU = new Gauge(target).setOptions(configurarGrafico());
        gaugeCPU.maxValue = 100; // set max gauge value
        gaugeCPU.setMinValue(0);  // Prefer setter over gauge.minValue = 0
        gaugeCPU.animationSpeed = 20; // set animation speed (32 is default value)
        gaugeCPU.set(dado);
        primeiraVezCPU = false;
        uso_cpu.innerHTML = dado + "%";
        tempoRecuperacao = 7000;
    } else {
        gaugeCPU.set(dado);
        uso_cpu.innerHTML = dado + "%";
    }
}

function plotarGraficoMemoria(dado) {
    if (primeiraVezMemoria) {
        target = document.getElementById('grafico_memoria'); // your canvas element
        gaugeMemoria = new Gauge(target).setOptions(configurarGrafico());
        gaugeMemoria.maxValue = 100; // set max gauge value
        gaugeMemoria.setMinValue(0);  // Prefer setter over gauge.minValue = 0
        gaugeMemoria.animationSpeed = 20; // set animation speed (32 is default value)
        gaugeMemoria.set(dado);
        primeiraVezMemoria = false;
        uso_memoria.innerHTML = dado + "%";
        tempoRecuperacao = 7000;
    } else {
        gaugeMemoria.set(dado);
        uso_memoria.innerHTML = dado + "%";
    }
}