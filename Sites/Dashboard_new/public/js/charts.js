const qtdDadosGrafico = 5;
let primeiraVez = true;
let target;
let gauge;
let tempoRecuperacao = 0;
// ESSA É A VARIAVEL ONDE OS DADOS VÃO SER INSERIDOS
var dados = {
    // AQUI É INSERIDO A DATA E HORA
    data: {
        labels: [],
        datasets: [{
            yAxisID: 'y-usoTotal',
            label: 'CPU',
            borderColor: '#2222DD',
            backgroundColor: '#00000033',
            data: [] // AQUI É INSERIDO A OS DADOS OU SEJA A QUANTIDADE QUE VAI SER EXIBIDA NO GRAFICO
        }, ]
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
        fetch(`/usoTotal/recuperarCPU/${sessionStorage.idComputador}`, {
            method: "GET",
        }).then(response => {

            if (response.ok) {

                response.json().then(json => {
                    console.log("FIZ LEITURA DE DADOS DO BANCO" + pesquisas)
                    pesquisas++;

                    json.reverse();
                    let resposta = JSON.parse(JSON.stringify(json));
                    console.log(resposta[0].usoComponente);
                    plotarGraficoCPU(resposta[0].usoComponente);
                    receberNovasLeituras();
                }); // 7000 ms -> 7 segundos
            } else {
                console.error('Nenhum dado encontrado ou erro na API');
            }
        });
    }, tempoRecuperacao);
}

// CONFIGURAÇÃO DO GRAFICO
function configurarGrafico() {
    var opts = {
        staticZones: [{
                strokeStyle: "#30b32d",
                min: 0,
                max: 50,
                height: 0.6
            },
            {
                strokeStyle: "#ffdd00",
                min: 50,
                max: 80,
                height: 0.6
            },
            {
                strokeStyle: "#f03e3e",
                min: 80,
                max: 100,
                height: 0.6
            }
        ],
        staticLabels: {
            font: "10px sans-serif", // Specifies font
            labels: [0, 50, 100], // Print labels at these values
            color: "#000000", // Optional: Label text color
            fractionDigits: 0 // Optional: Numerical precision. 0=round off.
        },
        angle: -0.2, // The span of the gauge arc
        lineWidth: 0.2, // The line thickness
        radiusScale: 0.63, // Relative radius
        pointer: {
            length: 0.58, // // Relative to gauge radius
            strokeWidth: 0.06, // The thickness
            color: '#000000' // Fill color
        },
        limitMax: false, // If false, max value increases automatically if value > maxValue
        limitMin: false, // If true, the min value of the gauge will be fixed
        colorStart: '#6F6EA0', // Colors
        colorStop: '#C0C0DB', // just experiment with them
        strokeColor: '#EEEEEE', // to see which ones work best for you
        generateGradient: true,
        highDpiSupport: true, // High resolution support

    };

    return opts;
}

function plotarGraficoCPU(dado) {
    if (primeiraVez) {
        target = document.getElementById('foo'); // your canvas element
        gauge = new Gauge(target).setOptions(configurarGrafico());
        gauge.maxValue = 100; // set max gauge value
        gauge.setMinValue(0); // Prefer setter over gauge.minValue = 0
        gauge.animationSpeed = 20; // set animation speed (32 is default value)
        gauge.set(dado);
        primeiraVez = false;
        uso_cpu.innerHTML = dado + "%";
        tempoRecuperacao = 7000;
    } else {
        gauge.set(dado);
        uso_cpu.innerHTML = dado + "%";
    }
}