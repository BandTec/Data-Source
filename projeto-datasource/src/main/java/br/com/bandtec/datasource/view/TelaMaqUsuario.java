/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.view;

import br.com.bandtec.datasource.conexao.ConexaoBD;
import br.com.bandtec.datasource.conexao.DadosConexao;
import br.com.bandtec.datasource.dao.ColetaDadosMaquinaDAO;
import br.com.bandtec.datasource.dao.ProcessosMaquinaDAO;
import br.com.bandtec.datasource.model.teste.CpuUser;
import br.com.bandtec.datasource.model.teste.DiscoRigidoUser;
import br.com.bandtec.datasource.model.teste.MemoriaUser;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

/**
 *
 * @author Thata
 */
public class TelaMaqUsuario extends javax.swing.JFrame {

    SystemInfo sistema = new SystemInfo();
    File[] disk = File.listRoots();
    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    OperatingSystem os = si.getOperatingSystem();
    private double cpu;
    private double cpuConvert;
    private long totalRAM;
    private long RamDisponivel;
    private long RamUsada;
    private long PorcentagemRam;
    private String DiskC;

    private long discoConvercao;

    private boolean bits;
    private String nome;
    private long interrompido;
    private int logica;
    private int fisica;

    MemoriaUser memory;
    DiscoRigidoUser disc;

    CpuUser cpuDados;
    ConexaoBD con = new ConexaoBD();
    DadosConexao dadosConexao = new DadosConexao();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());

    private void Analisar() throws InterruptedException, SQLException, IOException {

        bits = sistema.getHardware().getProcessor().isCpu64bit();
        nome = sistema.getHardware().getProcessor().getName();
        interrompido = sistema.getHardware().getProcessor().getInterrupts();
        logica = sistema.getHardware().getProcessor().getLogicalProcessorCount();
        fisica = sistema.getHardware().getProcessor().getPhysicalProcessorCount();

        totalRAM = sistema.getHardware().getMemory().getTotal();
        RamDisponivel = sistema.getHardware().getMemory().getAvailable();
        RamUsada = totalRAM - RamDisponivel;
        PorcentagemRam = ((RamUsada * 100) / totalRAM);

        for (File partition : disk) {
            DiskC = partition.getAbsolutePath();

            if (DiskC.charAt(0) == 'C') {
                discoConvercao = (partition.getUsableSpace() * 100) / partition.getTotalSpace();
            }
            if (DiskC.charAt(0) == 'D') {
                discoConvercao = (partition.getUsableSpace() * 100) / partition.getTotalSpace();
            }
            if (DiskC.charAt(0) == 'B') {
                discoConvercao = (partition.getUsableSpace() * 100) / partition.getTotalSpace();
            }
            if (DiskC.charAt(0) == '/') {
                discoConvercao = (partition.getUsableSpace() * 100) / partition.getTotalSpace();
            }

            DecimalFormat df = new DecimalFormat();
            df.applyPattern("##,00");
            cpu = sistema.getHardware().getProcessor().getSystemCpuLoadBetweenTicks();
            cpuConvert = cpu * 100;

            // Sistema operacional usado  
            lbSistemaOperacional.setText(memory.getNomeSistema());

            // Mostrando RAM Total
            lbRamTotal.setText(memory.getTotalRAM());
            // Mostrando RAM Utilizada 
            rsRam.setValue((int) PorcentagemRam);

            lbNomeCpu.setText(String.valueOf(nome));

            lbCpuFisica.setText(String.valueOf(fisica));

            lbCpuLogica.setText(String.valueOf(logica));

            rsCPU.setValue((int) cpuConvert);

            // Mostrando Espaço Total de HD
            String total = FormatUtil.formatBytes(partition.getTotalSpace());
            lbDiscoC.setText(total);

            rsDISCO.setValue((int) discoConvercao);

        }

    }

    public TelaMaqUsuario() {
        initComponents();
        this.memory = new MemoriaUser();
        setLocationRelativeTo(null);
    }

    private void incluirMaquina() {

        String nomeMaquina = si.getOperatingSystem().getNetworkParams().getHostName();
        List queryNomeMaquina = jdbcTemplate.queryForList("SELECT MAQU_NOME FROM  [DBO].[TB_MAQUINA_MAQU] WHERE MAQU_NOME = ?", nomeMaquina);
        if (queryNomeMaquina.isEmpty() || queryNomeMaquina.size() == 0) {
            try {
                con.incluirTeste(os.getFileSystem(), os.getNetworkParams(), hal.getNetworkIFs());
            } catch (IOException | SQLException ex) {
                Logger.getLogger(TelaMaqUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rSProgressBarSinTextBeanInfo1 = new rojerusan.componentes.RSProgressBarSinTextBeanInfo();
        jLabel1 = new javax.swing.JLabel();
        btAnalise = new javax.swing.JButton();
        lbSistemaOperacional = new javax.swing.JLabel();
        lbCpuLogica = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbNomeCpu = new javax.swing.JLabel();
        lbCpuFisica = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rsRam = new rojerusan.componentes.RSProgressCircle();
        lbRamTotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rsCPU = new rojerusan.componentes.RSProgressCircle();
        jPanel5 = new javax.swing.JPanel();
        rsDISCO = new rojerusan.componentes.RSProgressCircle();
        lbDiscoC = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(980, 600));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Sistema Operacional usado:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 460, 240, 17);

        btAnalise.setBackground(new java.awt.Color(102, 102, 102));
        btAnalise.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btAnalise.setText("Analisar");
        btAnalise.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btAnalise.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAnalise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnaliseActionPerformed(evt);
            }
        });
        getContentPane().add(btAnalise);
        btAnalise.setBounds(730, 470, 190, 60);

        lbSistemaOperacional.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbSistemaOperacional.setText("...");
        getContentPane().add(lbSistemaOperacional);
        lbSistemaOperacional.setBounds(290, 460, 420, 20);

        lbCpuLogica.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbCpuLogica.setText("...");
        getContentPane().add(lbCpuLogica);
        lbCpuLogica.setBounds(290, 500, 410, 20);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Número de CPUs Lógicas:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 500, 260, 20);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Dados da CPU:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 480, 120, 20);

        lbNomeCpu.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbNomeCpu.setText("...");
        getContentPane().add(lbNomeCpu);
        lbNomeCpu.setBounds(290, 480, 400, 20);

        lbCpuFisica.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        lbCpuFisica.setText("...");
        getContentPane().add(lbCpuFisica);
        lbCpuFisica.setBounds(290, 520, 410, 20);

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Número de CPUs Física:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 520, 190, 17);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(rsRam);

        lbRamTotal.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        lbRamTotal.setText("...");
        jPanel1.add(lbRamTotal);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(340, 240, 300, 190);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(rsCPU);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 240, 300, 190);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.add(rsDISCO);

        lbDiscoC.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        lbDiscoC.setText("...");
        jPanel5.add(lbDiscoC);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(660, 240, 300, 190);

        jLabel14.setBackground(new java.awt.Color(0, 204, 106));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Cpu Utilizada:");
        jLabel14.setOpaque(true);
        getContentPane().add(jLabel14);
        jLabel14.setBounds(20, 190, 300, 50);

        jLabel15.setBackground(new java.awt.Color(52, 152, 219));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Memoria Ram utilizada:");
        jLabel15.setOpaque(true);
        getContentPane().add(jLabel15);
        jLabel15.setBounds(340, 190, 300, 50);

        jLabel16.setBackground(new java.awt.Color(243, 156, 18));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Disco Rigido:");
        jLabel16.setOpaque(true);
        getContentPane().add(jLabel16);
        jLabel16.setBounds(660, 190, 300, 50);

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel9.setText("Monitoramento de Hardware");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 110, 760, 40);

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jPanel9);
        jPanel9.setBounds(0, 60, 1610, 10);

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jPanel8);
        jPanel8.setBounds(0, 60, 1610, 10);

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jPanel7);
        jPanel7.setBounds(0, 150, 1610, 10);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPanel11);
        jPanel11.setBounds(-40, 60, 1620, 90);

        jPanel12.setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jPanel12);
        jPanel12.setBounds(-10, 440, 1640, 10);

        jPanel13.setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jPanel13);
        jPanel13.setBounds(0, 550, 1600, 10);
        getContentPane().add(jLabel17);
        jLabel17.setBounds(-150, 440, 0, 1090);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Source Sans Pro Black", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 204));
        jButton2.setText("X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(930, 0, 50, 40);
        jButton2.getAccessibleContext().setAccessibleDescription("");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Open Sans", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 123, 255));
        jLabel2.setText("DataSource.");
        jPanel3.add(jLabel2);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(-160, 0, 1330, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAnaliseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnaliseActionPerformed
        int delay = 1000;   // tempo de espera antes da 1ª execução da tarefa.
        int interval = 1000;  // intervalo no qual a tarefa será executada.

        incluirMaquina();
        Timer timer = new Timer();
        ProcessosMaquinaDAO pmDAO = new ProcessosMaquinaDAO();
        ColetaDadosMaquinaDAO cdmDAO = new ColetaDadosMaquinaDAO();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    Analisar();
                    while (true) {
                        pmDAO.insertProcesso();
                        cdmDAO.insertDadosMaquina();
                        Thread.sleep(3000);
                        break;
                    }

                } catch (InterruptedException | SQLException | IOException ex) {
                    Logger.getLogger(TelaMaqUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, delay, interval);

        try {
            Analisar();
        } catch (InterruptedException | SQLException | IOException ex) {
            Logger.getLogger(TelaMaqUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAnaliseActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaMaqUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMaqUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMaqUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMaqUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaMaqUsuario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnalise;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbCpuFisica;
    private javax.swing.JLabel lbCpuLogica;
    private javax.swing.JLabel lbDiscoC;
    private javax.swing.JLabel lbNomeCpu;
    private javax.swing.JLabel lbRamTotal;
    private javax.swing.JLabel lbSistemaOperacional;
    private rojerusan.componentes.RSProgressBarSinTextBeanInfo rSProgressBarSinTextBeanInfo1;
    private rojerusan.componentes.RSProgressCircle rsCPU;
    private rojerusan.componentes.RSProgressCircle rsDISCO;
    private rojerusan.componentes.RSProgressCircle rsRam;
    // End of variables declaration//GEN-END:variables
}
