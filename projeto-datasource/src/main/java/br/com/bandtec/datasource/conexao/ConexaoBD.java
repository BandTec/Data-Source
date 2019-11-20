/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.conexao;

import br.com.bandtec.datasource.model.teste.CpuUser;
import br.com.bandtec.datasource.utils.GeracaoLog;
import br.com.bandtec.datasource.view.TelaLogin;
import br.com.bandtec.datasource.view.TelaMaqUsuario;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import oshi.PlatformEnum;
import oshi.SystemInfo;
import oshi.hardware.NetworkIF;
import oshi.software.os.FileSystem;
import oshi.software.os.NetworkParams;
import oshi.software.os.OSFileStore;
import oshi.util.FormatUtil;

/**
 *
 * @author Bandtec
 */
public class ConexaoBD {

    private final String hostName = "srvdatasource.database.windows.net"; // host do banco
    private final String dbName = "bddatasource"; // nome banco
    private final String user = "userdatasource"; // usuario
    private final String password = "#Gfgrupo6b"; // senha
    private final String url = String.format("jdbc:sqlserver://%s:1433;"
            + "database=%s;"
            + "user=%s;"
            + "password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;"
            + "loginTimeout=30;", hostName, dbName, user, password);

    // Declaracao e inicializacao de uma variavel do tipo Connection que armazenara a conexao estabelecida
    private Connection conn = null;
    private double cpuUso;
    ResultSet rs;

    SystemInfo sistema = new SystemInfo();
    PlatformEnum nomeSistema = SystemInfo.getCurrentPlatformEnum();

    CpuUser cpu = new CpuUser();
    Components components = JSensors.get.components();

    //Métodos para fazer a conexao ao banco
    public boolean conectarBD() throws SQLException, IOException {

        boolean ret = false;

        // Tenta executar as instrucoes em try
        try {
            // A classe DriverManager abre uma conexao com o banco de dados.
            // A classe Connection designa um objeto, no caso con, para receber a conexao estabelecida
            conn = DriverManager.getConnection(url);
            // Seta a variavel de retorno com true
            ret = true;
            GeracaoLog.GravarLog("\nConexão concluida\n");
            System.out.println("\nConectado com sucesso ! ! !");
            // Se der erro no try verifica qual erro foi gerado
        } catch (SQLException e) {
            GeracaoLog.GravarLog("\nErro na Conexão: " + e);
            System.out.println("\nErro na Conexão: " + e);
            // se ClassNotFoundException o servidor (sql) nao foi encontrado, 	
        }
        // se der outro erro, apresenta a descricaoo do erro utilizando
        // a classe SQLException que trata de erros scripts slq
        return ret;

    }

    public boolean autenticarLogin(JTextField jTextFieldUsuario, JPasswordField jPasswordFieldSenha) throws SQLException {
        PreparedStatement ps = null;
        conn = DriverManager.getConnection(url);

        try {
            System.out.println();

            String query = "SELECT USUA_NO_EMAIL,USUA_CD_SENHA from TB_USUARIO_USUA where USUA_NO_EMAIL  = '" + jTextFieldUsuario.getText() + "'";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            rs.next();

            if (rs.getString("USUA_CD_SENHA").equals(jPasswordFieldSenha.getText())) {
                JOptionPane.showMessageDialog(null, "Seja Bem Vindo!");
                TelaMaqUsuario tela = new TelaMaqUsuario();
                tela.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Usuario ou Senha invalida!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuario inexistente! Digite um usuario cadastrado. ");

            try {
                conn.close();
                return false;
            } catch (SQLException ex1) {
                Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex1);
                return false;
            }

        }
        return true;
    }

    public void incluirTeste(FileSystem fileSystem, NetworkParams networkParams, NetworkIF[] networkIFs) throws IOException, SQLException {

        PreparedStatement preparedStatment = null;
        long totalRAM = sistema.getHardware().getMemory().getTotal();
        long RamDisponivel = sistema.getHardware().getMemory().getAvailable();
        long RamUsada = totalRAM - RamDisponivel;
        OSFileStore[] fsArray = fileSystem.getFileStores();
        List<Gpu> gpus = components.gpus;

        DecimalFormat df = new DecimalFormat();
        df.applyPattern("##,00");
        cpuUso = sistema.getHardware().getProcessor().getSystemCpuLoadBetweenTicks() * 100;
        try {
            conn = DriverManager.getConnection(url);
            // parametros (?) na construcao da string de SQL
            String query = "insert into TB_MAQUINA_MAQU values(?,?,?,?,?,?,?,?,?,?,?,?,?);";

            preparedStatment = conn.prepareStatement(query);

            preparedStatment.setString(1, cpu.getNomeSistema());
            preparedStatment.setString(2, cpu.getProcessadorNome());
            preparedStatment.setString(3, df.format(cpuUso));  // colocar aqui a porcentagem da cpu
            preparedStatment.setString(4, FormatUtil.formatBytes(totalRAM)); // colocar aqui quantidade de ram total
            preparedStatment.setString(5, FormatUtil.formatBytes(RamUsada)); // colocar quantidade de ram disponivel
            preparedStatment.setString(6, FormatUtil.formatBytes(RamDisponivel)); // colocar aqui a  quantidade de ram usada

            File[] disk = File.listRoots();
            for (File i : disk) {
                String nomeParticao = i.getAbsolutePath();
                if (nomeParticao.charAt(0) == 'C' || nomeParticao.charAt(0) == '/') {
                    for (OSFileStore fs : fsArray) {
                        long usadoDisco = fs.getUsableSpace();
                        long totalDisco = fs.getTotalSpace();
                        long disponivelDisco = totalDisco - usadoDisco;
                        float porcentagem = (float) (100d * usadoDisco / totalDisco);
                        preparedStatment.setString(7, FormatUtil.formatBytes(totalDisco)); // colocar aqui o total do HD
                        preparedStatment.setString(8, FormatUtil.formatBytes(usadoDisco)); // colocar aqui a QTD USO do HD
                        preparedStatment.setString(9, FormatUtil.formatBytes(disponivelDisco)); // colocar aqui a QTD DIPONIVEL do HD

                        if (!gpus.isEmpty()) {
                            for (final Gpu gpu : gpus) {
                                preparedStatment.setString(10, gpu.name); // colocar aqui o nome da GPU
                            }
                        } else {
                            preparedStatment.setString(10, "Nao tem placa de video");
                        }

//                      String nomeMaquina = sistema.getOperatingSystem().getNetworkParams().getDomainName(); // pega a descrisao do tipo de maquina
                        if (PlatformEnum.LINUX.equals(nomeSistema)) {
                            preparedStatment.setString(11, "Servidor");
                        } else {
                            preparedStatment.setString(11, "Notebook");
                        }
                        preparedStatment.setString(12, networkParams.getHostName());
                      
                        for (NetworkIF net : networkIFs) {
                             preparedStatment.setString(13, net.getMacaddr());
                        }

                        preparedStatment.executeUpdate();
                        System.out.println("Maquina incluida  com sucesso ! ! !");
                        break;
                    }
                }
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            GeracaoLog.GravarLog("Erro na Conexão:" + e);
        } finally {
            try {
                preparedStatment.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
