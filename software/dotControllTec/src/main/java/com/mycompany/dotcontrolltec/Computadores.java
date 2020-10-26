/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dotcontrolltec;

import com.mycompany.dotcontrolltec.computadores.CpuRamDisco;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.JFrame;
import javax.swing.Timer;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

/**
 *
 * @author vicari
 */
public class Computadores extends javax.swing.JFrame {

    private static CpuRamDisco medicaoCpu = new CpuRamDisco();
    
   
    
    public Computadores() {
        initComponents();
        
        SystemInfo si = new SystemInfo();
       CentralProcessor.ProcessorIdentifier cpu = si.getHardware().getProcessor().getProcessorIdentifier();
    
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
        
        lblMaxDisco.setText(String.format("%.2f GB", medicaoCpu.qtdEspacoTotalDisco()));
        
        lblFreeSpace.setText(String.format("%.2f GB", medicaoCpu.qtdEspacoLivre()));
        
        prgRAM.setMaximum(medicaoCpu.qtdMemoriaRamTotal().intValue());
        
        prgRAM.setValue(medicaoCpu.qtdMemoriaRamUsada().intValue());
        
        lblSO.setText(medicaoCpu.sistemaOperacional());
        
        lblProcessadorVendor.setText(medicaoCpu.informacoesProcessador());
        
        lblRamMax.setText(String.format("%.2f GB",medicaoCpu.qtdMemoriaRamTotal()));
       
        lblProcessadorNome.setText(cpu.getName());
        lblProcessadorIndentificado.setText(cpu.getIdentifier());
        lblProcessadorMicroArquitetura1.setText(cpu.getMicroarchitecture());
        lblProcessadorVendor.setText(cpu.getVendor());
                    
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
        pnlInfoPC = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblSO = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblProcessadorVendor = new javax.swing.JLabel();
        lblProcessadorNome = new javax.swing.JLabel();
        lblProcessadorIndentificado = new javax.swing.JLabel();
        lblProcessadorMicroArquitetura1 = new javax.swing.JLabel();
        btnProcessos = new javax.swing.JButton();
        pnlCPU = new javax.swing.JPanel();
        lblCpu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCpuMax = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlDisco = new javax.swing.JPanel();
        lblFreeSpace = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        prgDisco = new javax.swing.JProgressBar();
        lblMaxDisco = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblRam = new javax.swing.JLabel();
        prgRAM = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        lblRamMax = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(769, 340, -1, -1));

        pnlPlanoDeFundo.setBackground(new java.awt.Color(1, 4, 3));
        pnlPlanoDeFundo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlInfoPC.setBackground(new java.awt.Color(7, 10, 16));
        pnlInfoPC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("informações do sistema");
        pnlInfoPC.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 290, -1));

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sistema Operacional:");
        pnlInfoPC.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 108, -1, -1));

        lblSO.setForeground(new java.awt.Color(255, 255, 255));
        lblSO.setText("jLabel11");
        pnlInfoPC.add(lblSO, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Processador:");
        pnlInfoPC.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        lblProcessadorVendor.setBackground(new java.awt.Color(0, 0, 0));
        lblProcessadorVendor.setForeground(new java.awt.Color(255, 255, 255));
        lblProcessadorVendor.setText("jLabel14");
        pnlInfoPC.add(lblProcessadorVendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        lblProcessadorNome.setBackground(new java.awt.Color(0, 0, 0));
        lblProcessadorNome.setForeground(new java.awt.Color(255, 255, 255));
        lblProcessadorNome.setText("jLabel12");
        pnlInfoPC.add(lblProcessadorNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        lblProcessadorIndentificado.setBackground(new java.awt.Color(0, 0, 0));
        lblProcessadorIndentificado.setForeground(new java.awt.Color(255, 255, 255));
        lblProcessadorIndentificado.setText("jLabel13");
        pnlInfoPC.add(lblProcessadorIndentificado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        lblProcessadorMicroArquitetura1.setBackground(new java.awt.Color(0, 0, 0));
        lblProcessadorMicroArquitetura1.setForeground(new java.awt.Color(255, 255, 255));
        lblProcessadorMicroArquitetura1.setText("jLabel14");
        pnlInfoPC.add(lblProcessadorMicroArquitetura1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        btnProcessos.setText("processos");
        btnProcessos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessosActionPerformed(evt);
            }
        });
        pnlInfoPC.add(btnProcessos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        pnlPlanoDeFundo.add(pnlInfoPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 350, 450));

        pnlCPU.setBackground(new java.awt.Color(7, 10, 16));
        pnlCPU.setForeground(new java.awt.Color(255, 255, 255));
        pnlCPU.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCpu.setBackground(new java.awt.Color(255, 255, 255));
        lblCpu.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        lblCpu.setForeground(new java.awt.Color(73, 156, 172));
        lblCpu.setText("0.0 GHz");
        pnlCPU.add(lblCpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cpu Atual:");
        pnlCPU.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cpu Max:");
        pnlCPU.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 84, -1));

        lblCpuMax.setBackground(new java.awt.Color(255, 255, 255));
        lblCpuMax.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        lblCpuMax.setForeground(new java.awt.Color(73, 156, 172));
        lblCpuMax.setText("0.0 GHz");
        pnlCPU.add(lblCpuMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CPU");
        pnlCPU.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        pnlPlanoDeFundo.add(pnlCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 320, 120));

        jPanel1.setBackground(new java.awt.Color(7, 10, 16));

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(".ControlTec");
        jPanel1.add(jLabel6);

        pnlPlanoDeFundo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 690, 60));

        pnlDisco.setBackground(new java.awt.Color(7, 10, 16));
        pnlDisco.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFreeSpace.setBackground(new java.awt.Color(255, 255, 255));
        lblFreeSpace.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        lblFreeSpace.setForeground(new java.awt.Color(73, 156, 172));
        lblFreeSpace.setText("0.0 GB");
        pnlDisco.add(lblFreeSpace, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Disco");
        pnlDisco.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));
        pnlDisco.add(prgDisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 300, 40));

        lblMaxDisco.setBackground(new java.awt.Color(255, 255, 255));
        lblMaxDisco.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        lblMaxDisco.setForeground(new java.awt.Color(73, 156, 172));
        lblMaxDisco.setText("0.0 GB");
        pnlDisco.add(lblMaxDisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jLabel13.setText("Espaço Máximo:");
        pnlDisco.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jLabel12.setText("Espaço Livre:");
        pnlDisco.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        pnlPlanoDeFundo.add(pnlDisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 320, 150));

        jPanel2.setBackground(new java.awt.Color(7, 10, 16));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ram");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        lblRam.setBackground(new java.awt.Color(255, 255, 255));
        lblRam.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        lblRam.setForeground(new java.awt.Color(73, 156, 172));
        lblRam.setText("0.0 GB");
        jPanel2.add(lblRam, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));
        jPanel2.add(prgRAM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 290, 30));

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("máxima:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lblRamMax.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        lblRamMax.setForeground(new java.awt.Color(73, 156, 172));
        lblRamMax.setText("0.0 GB");
        jPanel2.add(lblRamMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Em uso:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        pnlPlanoDeFundo.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 320, 160));

        getContentPane().add(pnlPlanoDeFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    JFrame frame = new JFrame();
    private void btnProcessosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessosActionPerformed
        frame.dispose();
        frame.setContentPane(new TelaProcessos());
        frame.pack();
        //if(frame.isVisible() ==  false){
            frame.setVisible(true);
       // }
        
    }//GEN-LAST:event_btnProcessosActionPerformed


    public static void roda(String args[]) {
       
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Computadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcessos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCpu;
    private javax.swing.JLabel lblCpuMax;
    private javax.swing.JLabel lblFreeSpace;
    private javax.swing.JLabel lblMaxDisco;
    private javax.swing.JLabel lblProcessadorIndentificado;
    private javax.swing.JLabel lblProcessadorMicroArquitetura1;
    private javax.swing.JLabel lblProcessadorNome;
    private javax.swing.JLabel lblProcessadorVendor;
    private javax.swing.JLabel lblRam;
    private javax.swing.JLabel lblRamMax;
    private javax.swing.JLabel lblSO;
    private javax.swing.JPanel pnlCPU;
    private javax.swing.JPanel pnlDisco;
    private javax.swing.JPanel pnlInfoPC;
    private javax.swing.JPanel pnlPlanoDeFundo;
    private javax.swing.JProgressBar prgDisco;
    private javax.swing.JProgressBar prgRAM;
    // End of variables declaration//GEN-END:variables
}
