// ################ HEAT MAP ################# //

window.requestAnimationFrame = window.requestAnimationFrame || window.mozRequestAnimationFrame ||
    window.webkitRequestAnimationFrame || window.msRequestAnimationFrame;

function get(id) {
    return document.getElementById(id);
}


// ############### POSIÇÃO X e Y DE ONDE VAI COLOCAR O PONTO DE CALOR ##################//
var posicaoCPU = {
    x: 510,
    y: 200,
    intencidade: Math.floor(Math.random() * 51)
}


var posicoes = [
    [posicaoCPU.x, posicaoCPU.y, posicaoCPU.intencidade],
    [posicaoCPU.x - 13, posicaoCPU.y - 15, posicaoCPU.intencidade],
    [posicaoCPU.x + 15, posicaoCPU.y + 25, posicaoCPU.intencidade],
    [posicaoCPU.x - 13, posicaoCPU.y - 15, posicaoCPU.intencidade],
    [posicaoCPU.x + 15, posicaoCPU.y - 14, posicaoCPU.intencidade],
];
var heat = simpleheat('heatMap').data(posicoes).max(18),
    frame;

function draw() {
    console.time('draw');
    heat.draw();
    console.timeEnd('draw');
    frame = null;
}

draw();
