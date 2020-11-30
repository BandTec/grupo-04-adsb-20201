/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dotcontrolltec.computadores;

import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.NetworkIF;

/**
 *
 * @author Aluno
 */
public class InformacoesSistema {
    SystemInfo si;

    public InformacoesSistema() {
        si = new SystemInfo();
    }
    
    public String serialNumber(){
        return si.getHardware().getComputerSystem().getSerialNumber();
    }
    public String[] getIpv4(){
//        String a = "";
//        for(NetworkIF n: si.getHardware().getNetworkIFs()){
//            a = n.getIPv4addr().;
//        }
        return si.getHardware().getNetworkIFs().get(2).getIPv4addr();
    }
    
    
}
