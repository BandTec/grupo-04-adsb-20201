package com.mycompany.dotcontrolltec;

import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import oshi.SystemInfo;
import oshi.software.os.OSProcess;

/**
 *
 * @author castione
 */
public class TelaProcessos extends javax.swing.JPanel {

    SystemInfo si = new SystemInfo();
    
    /**
     * Creates new form Processes
     */
    public TelaProcessos() {
        initComponents();
        
        DefaultTableModel model = (DefaultTableModel)tblProcesses.getModel();
        Integer cpuCount = si.getHardware().getProcessor().getLogicalProcessorCount();
        Long totalMem = si.getHardware().getMemory().getTotal();
        
        Timer timer = new Timer(1000, e -> {
            model.setRowCount(0);
            
            for (OSProcess process : si.getOperatingSystem().getProcesses()) {
            
                if (process.getProcessID() > 0) {
                    model.addRow(new Object[] {
                        process.getProcessID(),
                        process.getName(),
                        String.format("%.1f%%", 100.0 * process.getProcessCpuLoadCumulative() / cpuCount),
                        String.format("%.1f%%", 100.0 * process.getResidentSetSize() / totalMem)
                    } );
                }
            } 
        });
        
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProcesses = new javax.swing.JTable();

        tblProcesses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPU", "Memory"
            }
        ));
        jScrollPane1.setViewportView(tblProcesses);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProcesses;
    // End of variables declaration//GEN-END:variables
}
