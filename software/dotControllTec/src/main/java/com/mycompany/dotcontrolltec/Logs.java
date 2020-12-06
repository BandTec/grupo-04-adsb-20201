/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dotcontrolltec;

import java.io.File;
import java.time.LocalDateTime;
import sun.tools.tree.ThisExpression;

/**
 *
 * @author Aluno
 */
public class Logs {
    String nome_arquivo;
    LocalDateTime dataAtual; 
    File arquivo;

    public Logs() {
        dataAtual = LocalDateTime.now();
        this.nome_arquivo = "Mind6_"+ dataAtual.getDayOfMonth() +"_" + dataAtual.getMonthValue()+"_"+dataAtual.getYear();
        arquivo = new File("c:/"+nome_arquivo);
    }
    public void gerar_Log(){
        System.out.println(arquivo.exists());
    }
  
}
