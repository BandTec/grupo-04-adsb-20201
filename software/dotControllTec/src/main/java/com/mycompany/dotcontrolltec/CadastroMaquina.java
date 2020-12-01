/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dotcontrolltec;

import com.mycompany.dotcontrolltec.computadores.Cpu;
import com.mycompany.dotcontrolltec.computadores.Disco;
import com.mycompany.dotcontrolltec.computadores.InformacoesSistema;
import com.mycompany.dotcontrolltec.computadores.Ram;
import com.mycompany.exemplo.bd.Componente;
import com.mycompany.exemplo.bd.Computador;
import com.mycompany.exemplo.bd.Conection;
import com.mycompany.exemplo.bd.Tecnico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Aluno
 */
public class CadastroMaquina extends javax.swing.JFrame {
    
    String serial;
    Integer fkComputador, fkRam,fkDisco,fkCpu;
    Tecnico tecnico;
    Conection config = new Conection();
    JdbcTemplate con = new JdbcTemplate(config.getDatasource());
    InformacoesSistema is = new InformacoesSistema();
    Ram ram = new Ram();
    Cpu cpu = new Cpu();
    Disco disco = new Disco();

    /**
     *
     * @param tecnico
     */
    public CadastroMaquina(Tecnico tecnico) {
        fkComputador = null;
        serial = is.getIpv4();
        this.setLocationRelativeTo(null);
        initComponents();
        this.tecnico = tecnico;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastrando maquina ...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel1)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel1)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        //cadastrando maquina
        con.update("insert into Computador values(?,?,?,1,?)","Computador_"+serial, tecnico.getFkEscola(),is.sistemaOperacional(), serial);
        
        //pegando id da maquina
        String select = "select * from Computador where serialnum = ?;";
        List<Computador> dadosComp = con.query(select,new BeanPropertyRowMapper(Computador.class),is.getIpv4());
        for(Computador c: dadosComp){
            fkComputador = c.getIdComputador();
        }
        
        //cadastrando componentes da maquina
        con.update("insert into Componente values(?,'DISCO',?)",disco.nome(),fkComputador);
        con.update("insert into Componente values(?,'RAM',?)","Teste",fkComputador);
        con.update("insert into Componente values(?,'CPU',?)",cpu.nome(),fkComputador);
        
        //pegando o id de cada componente da maquina
        select = "select * from Componente where fkComputador = ?;";
        List<Componente> dadosComponente = con.query(select,new BeanPropertyRowMapper(Componente.class),fkComputador);
        fkDisco = dadosComponente.get(0).getIdComponente();
        fkRam = dadosComponente.get(1).getIdComponente();
        fkCpu = dadosComponente.get(2).getIdComponente();
        
        
        new TelaPrincipal(tecnico, fkCpu,fkDisco,fkRam).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
