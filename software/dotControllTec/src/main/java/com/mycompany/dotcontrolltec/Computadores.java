/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dotcontrolltec;

import com.mycompany.dotcontrolltec.computadores.CpuRamDisco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author vicari
 */
public class Computadores extends javax.swing.JFrame {

    private static CpuRamDisco medicaoCpu = new CpuRamDisco();
    
   
    
    public Computadores() {
        initComponents();
        
        
        ActionListener acao = (ActionEvent executar) -> {
            
        //mostra a lista de frequencias na CPU
        //essa é a média dos meus 4 núcleos da CPU
        lblCpu.setText(String.format("%.2f GHz", medicaoCpu.frenquenciaCpu()));

        //mostra o valor máximo do processador
        lblCpuMax.setText(String.format("%.2f GHz", medicaoCpu.frequenciaMax()));
        
        //mostra a quantidade de memoria ram usada
        lblRam.setText(String.format("%.2f GB", medicaoCpu.qtdMemoriaRamUsada()));
        
        //insere a quantidade total do seu disco na progressBar
        prgDisco.setMaximum(medicaoCpu.qtdEspacoTotalDisco().intValue());
        
        //insere a quatidade usada na progressBar
        prgDisco.setValue(medicaoCpu.qtdEspacoUsadoDisco().intValue());
        
        lblMaxDisco.setText(String.format("Max: %.2f GB", medicaoCpu.qtdEspacoTotalDisco()));
        
        lblFreeSpace.setText(String.format("Free Space: %.2f GB", medicaoCpu.qtdEspacoLivre()));
        
        prgRAM.setMaximum(medicaoCpu.qtdMemoriaRamTotal().intValue());
        
        prgRAM.setValue(medicaoCpu.qtdMemoriaRamUsada().intValue());
        
        lblSO.setText(medicaoCpu.sistemaOperacional());
        
        lblProcessador.setText(medicaoCpu.informacoesProcessador());
        
    };
      
    //timer é uma calsse importada do swing  
    Timer tempo = new Timer(1000, acao);
    
    //iniciar o temporizador
    tempo.start();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        pnlPlanoDeFundo = new javax.swing.JPanel();
        pnlComponentes = new javax.swing.JPanel();
        pnlDisco = new javax.swing.JPanel();
        lblFreeSpace = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        prgDisco = new javax.swing.JProgressBar();
        lblMaxDisco = new javax.swing.JLabel();
        pnlCPU = new javax.swing.JPanel();
        lblCpu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCpuMax = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblRam = new javax.swing.JLabel();
        prgRAM = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        pnlInfoPC = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblSO = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblProcessador = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPlanoDeFundo.setBackground(new java.awt.Color(0, 0, 0));

        pnlComponentes.setBackground(new java.awt.Color(242, 242, 242));
        pnlComponentes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        pnlDisco.setBackground(new java.awt.Color(255, 255, 255));
        pnlDisco.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        lblFreeSpace.setBackground(new java.awt.Color(255, 255, 255));
        lblFreeSpace.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        lblFreeSpace.setForeground(new java.awt.Color(0, 0, 0));
        lblFreeSpace.setText("Espaço livre:  0.0 GB");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Disco");

        lblMaxDisco.setBackground(new java.awt.Color(255, 255, 255));
        lblMaxDisco.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        lblMaxDisco.setForeground(new java.awt.Color(0, 0, 0));
        lblMaxDisco.setText("Max: 0.0 GB");

        javax.swing.GroupLayout pnlDiscoLayout = new javax.swing.GroupLayout(pnlDisco);
        pnlDisco.setLayout(pnlDiscoLayout);
        pnlDiscoLayout.setHorizontalGroup(
            pnlDiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiscoLayout.createSequentialGroup()
                .addGroup(pnlDiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDiscoLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2))
                    .addGroup(pnlDiscoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFreeSpace)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlDiscoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDiscoLayout.createSequentialGroup()
                        .addComponent(lblMaxDisco)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(prgDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDiscoLayout.setVerticalGroup(
            pnlDiscoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiscoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prgDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMaxDisco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFreeSpace)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCPU.setBackground(new java.awt.Color(255, 255, 255));
        pnlCPU.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        lblCpu.setBackground(new java.awt.Color(255, 255, 255));
        lblCpu.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        lblCpu.setForeground(new java.awt.Color(0, 0, 0));
        lblCpu.setText("0.0 GHz");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cpu Atual:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cpu Max:");

        lblCpuMax.setBackground(new java.awt.Color(255, 255, 255));
        lblCpuMax.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        lblCpuMax.setForeground(new java.awt.Color(0, 0, 0));
        lblCpuMax.setText("0.0 GHz");

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("CPU");

        javax.swing.GroupLayout pnlCPULayout = new javax.swing.GroupLayout(pnlCPU);
        pnlCPU.setLayout(pnlCPULayout);
        pnlCPULayout.setHorizontalGroup(
            pnlCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCPULayout.createSequentialGroup()
                .addGroup(pnlCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCPULayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlCPULayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCpu))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCPULayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCpuMax))))
                    .addGroup(pnlCPULayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel8)))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        pnlCPULayout.setVerticalGroup(
            pnlCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCPULayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(pnlCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCpu)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblCpuMax))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Ram");

        lblRam.setBackground(new java.awt.Color(255, 255, 255));
        lblRam.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        lblRam.setForeground(new java.awt.Color(0, 0, 0));
        lblRam.setText("0.0 GB");

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Em uso:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prgRAM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(lblRam)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prgRAM, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblRam))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout pnlComponentesLayout = new javax.swing.GroupLayout(pnlComponentes);
        pnlComponentes.setLayout(pnlComponentesLayout);
        pnlComponentesLayout.setHorizontalGroup(
            pnlComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComponentesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlCPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        pnlComponentesLayout.setVerticalGroup(
            pnlComponentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlComponentesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        pnlInfoPC.setBackground(new java.awt.Color(242, 242, 242));
        pnlInfoPC.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("informações do sistema");

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Sistema Operacional:");

        lblSO.setForeground(new java.awt.Color(0, 0, 0));
        lblSO.setText("jLabel11");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Processador:");

        lblProcessador.setText("jLabel12");

        javax.swing.GroupLayout pnlInfoPCLayout = new javax.swing.GroupLayout(pnlInfoPC);
        pnlInfoPC.setLayout(pnlInfoPCLayout);
        pnlInfoPCLayout.setHorizontalGroup(
            pnlInfoPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoPCLayout.createSequentialGroup()
                .addGroup(pnlInfoPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoPCLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel9))
                    .addGroup(pnlInfoPCLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(pnlInfoPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(pnlInfoPCLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(pnlInfoPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(lblSO)
                                    .addComponent(lblProcessador))))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        pnlInfoPCLayout.setVerticalGroup(
            pnlInfoPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoPCLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel9)
                .addGap(51, 51, 51)
                .addComponent(jLabel10)
                .addGap(34, 34, 34)
                .addComponent(lblSO)
                .addGap(32, 32, 32)
                .addComponent(jLabel11)
                .addGap(36, 36, 36)
                .addComponent(lblProcessador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(".ControlTec");

        javax.swing.GroupLayout pnlPlanoDeFundoLayout = new javax.swing.GroupLayout(pnlPlanoDeFundo);
        pnlPlanoDeFundo.setLayout(pnlPlanoDeFundoLayout);
        pnlPlanoDeFundoLayout.setHorizontalGroup(
            pnlPlanoDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlanoDeFundoLayout.createSequentialGroup()
                .addGroup(pnlPlanoDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPlanoDeFundoLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(pnlComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPlanoDeFundoLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlInfoPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnlPlanoDeFundoLayout.setVerticalGroup(
            pnlPlanoDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlanoDeFundoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlPlanoDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlInfoPC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlPlanoDeFundoLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(27, 27, 27)
                        .addComponent(pnlComponentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPlanoDeFundo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnlPlanoDeFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void roda(String args[]) {
       
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Computadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCpu;
    private javax.swing.JLabel lblCpuMax;
    private javax.swing.JLabel lblFreeSpace;
    private javax.swing.JLabel lblMaxDisco;
    private javax.swing.JLabel lblProcessador;
    private javax.swing.JLabel lblRam;
    private javax.swing.JLabel lblSO;
    private javax.swing.JPanel pnlCPU;
    private javax.swing.JPanel pnlComponentes;
    private javax.swing.JPanel pnlDisco;
    private javax.swing.JPanel pnlInfoPC;
    private javax.swing.JPanel pnlPlanoDeFundo;
    private javax.swing.JProgressBar prgDisco;
    private javax.swing.JProgressBar prgRAM;
    // End of variables declaration//GEN-END:variables
}
