/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bandtec
 */
public class DesafioYoshi extends javax.swing.JFrame {

    /**
     * Creates new form DesafioYoshi
     */
    public DesafioYoshi() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCPU = new javax.swing.JLabel();
        lblPorcentagemCpu = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblGPU = new javax.swing.JLabel();
        lblHd = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblStandBy = new javax.swing.JLabel();
        lblExecucao = new javax.swing.JLabel();
        lblMemoria = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCPU1 = new javax.swing.JLabel();
        lblCPU2 = new javax.swing.JLabel();
        lblTempCpu = new javax.swing.JLabel();
        lblTempGpu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCPU.setBackground(new java.awt.Color(1, 1, 1));
        lblCPU.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblCPU.setText("CPU :");

        lblPorcentagemCpu.setBackground(new java.awt.Color(1, 1, 1));
        lblPorcentagemCpu.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblPorcentagemCpu.setText("%");

        btnAtualizar.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(1, 1, 1));
        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Memoria RAM :");

        jLabel2.setBackground(new java.awt.Color(1, 1, 1));
        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setText("Qtd de Processos:");

        lblGPU.setBackground(new java.awt.Color(1, 1, 1));
        lblGPU.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblGPU.setText("%");

        lblHd.setBackground(new java.awt.Color(1, 1, 1));
        lblHd.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblHd.setText("%");

        jLabel3.setBackground(new java.awt.Color(1, 1, 1));
        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel3.setText("Disco Rigido :");

        jLabel4.setBackground(new java.awt.Color(1, 1, 1));
        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel4.setText("GPU:");

        lblStandBy.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblStandBy.setText("em stand by");

        lblExecucao.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblExecucao.setText("em execução");

        lblMemoria.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblMemoria.setText("%");

        jLabel5.setBackground(new java.awt.Color(1, 1, 1));
        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel5.setText("Qtd de Processos:");

        lblCPU1.setBackground(new java.awt.Color(1, 1, 1));
        lblCPU1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblCPU1.setText("Temp CPU :");

        lblCPU2.setBackground(new java.awt.Color(1, 1, 1));
        lblCPU2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblCPU2.setText("Temp GPU :");

        lblTempCpu.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblTempCpu.setText("°C");

        lblTempGpu.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblTempGpu.setText("°C");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblExecucao, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblStandBy, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblCPU)
                        .addGap(49, 49, 49)
                        .addComponent(lblPorcentagemCpu)
                        .addGap(71, 71, 71)
                        .addComponent(lblCPU1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(lblGPU))
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblHd)
                                    .addComponent(lblMemoria))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(lblCPU2)
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTempCpu)
                                    .addComponent(lblTempGpu))
                                .addGap(39, 39, 39))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPU)
                    .addComponent(lblPorcentagemCpu)
                    .addComponent(lblCPU1)
                    .addComponent(lblTempCpu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblMemoria, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblHd))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblGPU)
                    .addComponent(lblCPU2)
                    .addComponent(lblTempGpu))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblExecucao))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblStandBy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        
        Random rnd = new Random();
  
        lblPorcentagemCpu.setText(rnd.nextInt(100) + "%"); 
        
        lblGPU.setText(rnd.nextInt(100) + " %");     
        lblHd.setText(rnd.nextInt(100) + " %");        
        lblMemoria.setText(rnd.nextInt(100) + " %"); 
        lblExecucao.setText(rnd.nextInt(1000) +" em execução");
        lblStandBy.setText(rnd.nextInt(1000) +" em stand by");
        lblTempCpu.setText(rnd.nextInt(100) +"°C");
        lblTempGpu.setText(rnd.nextInt(100) +"°C");                         
    }//GEN-LAST:event_btnAtualizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DesafioYoshi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesafioYoshi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesafioYoshi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesafioYoshi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DesafioYoshi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblCPU;
    private javax.swing.JLabel lblCPU1;
    private javax.swing.JLabel lblCPU2;
    private javax.swing.JLabel lblExecucao;
    private javax.swing.JLabel lblGPU;
    private javax.swing.JLabel lblHd;
    private javax.swing.JLabel lblMemoria;
    private javax.swing.JLabel lblPorcentagemCpu;
    private javax.swing.JLabel lblStandBy;
    private javax.swing.JLabel lblTempCpu;
    private javax.swing.JLabel lblTempGpu;
    // End of variables declaration//GEN-END:variables
}
