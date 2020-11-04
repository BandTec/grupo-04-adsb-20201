/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dotcontrolltec.computadores;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;

/**
 *
 * @author vicari
 */
public class Ram {
    
    private GlobalMemory ram;
    
    public Ram(){
        
        ram = new SystemInfo().getHardware().getMemory();
        
        
    }
    //traz a quantidade total de memória Ram da máquina
    public Double qtdMemoriaRamTotal() {

        //calculo para conversão de bytes para GB
        Double qtdTotalGHz = ram.getTotal() / Math.pow(10, 9);

        return qtdTotalGHz;
    }
     //traz a memoria ram livre
    public Double qtdMemoriaRamLivre() {

        //calculo para a conversão de bytes para GB
        Double qtdTotalGHz = ram.getAvailable() / Math.pow(10, 9);

        return qtdTotalGHz;
    }
     public Double porcetagemDeMemoria() {
        Long total = ram.getTotal();
        Long usado = total - ram.getAvailable();
        return (usado * 100.0) / total;
    }
    
     
}
