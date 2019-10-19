/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.conexao;

import br.com.bandtec.datasource.model.teste.CpuUser;
import br.com.bandtec.datasource.model.teste.DiscoRigidoUser;
import br.com.bandtec.datasource.utils.GeracaoLog;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import oshi.SystemInfo;
import oshi.software.os.FileSystem;
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

    SystemInfo sistema = new SystemInfo();

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

    public void incluirTeste(FileSystem fileSystem) throws IOException, SQLException {

        PreparedStatement preparedStatment = null;
        //Pegando o total de memória RAM do computador.
        long totalRAM = sistema.getHardware().getMemory().getTotal();
//            convertendo para string
//            String MemRamTotal = String.valueOf(totalRAM);
        //Pegando a memória RAM que esta sendo usada.
        long RamDisponivel = sistema.getHardware().getMemory().getAvailable();
//            String MemRamDisponivel = String.valueOf(RamDisponivel);
        // Calculo para pegar a memoria ram USADA no SISTEMA
        long RamUsada = totalRAM - RamDisponivel;
//            String MemRamUso = String.valueOf(RamUsada);
        //Cálculo para dar a porcentagem de memória RAM que esta sendo utilizada.
        long PorcentagemRam = ((RamUsada * 100) / totalRAM);

        OSFileStore[] fsArray = fileSystem.getFileStores(); // pega as paticoes do HD
        List<Gpu> gpus = components.gpus; //  pega as GPU's do sistema

        DecimalFormat df = new DecimalFormat();
        df.applyPattern("##,00");
        cpuUso = sistema.getHardware().getProcessor().getSystemCpuLoadBetweenTicks() * 100;
        try {
            conn = DriverManager.getConnection(url);
            // parametros (?) na construcao da string de SQL
            String query = "insert into TB_MAQUINA_MAQU values(?,?,?,?,?,?,?,?,?,?,?);";

            preparedStatment = conn.prepareStatement(query);
            for (OSFileStore fs : fsArray) {
               
                long usadoDisco = fs.getUsableSpace();
                long totalDisco = fs.getTotalSpace();
                long disponivelDisco = totalDisco - usadoDisco;
                float porcentagem = (float) (100d * usadoDisco / totalDisco);

                for (final Gpu gpu : gpus) {
                    preparedStatment.setString(1, cpu.getNomeSistema());
                    preparedStatment.setString(2, cpu.getProcessadorNome());
                    preparedStatment.setString(3, df.format(cpuUso));  // colocar aqui a porcentagem da cpu
                    preparedStatment.setString(4, FormatUtil.formatBytes(totalRAM)); // colocar aqui quantidade de ram total
                    preparedStatment.setString(5, FormatUtil.formatBytes(RamUsada)); // colocar quantidade de ram disponivel
                    preparedStatment.setString(6, FormatUtil.formatBytes(RamDisponivel)); // colocar aqui a  quantidade de ram usada
                    preparedStatment.setString(7, FormatUtil.formatBytes(totalDisco)); // colocar aqui o total do HD
                    preparedStatment.setString(8, FormatUtil.formatBytes(usadoDisco)); // colocar aqui a QTD USO do HD
                    preparedStatment.setString(9, FormatUtil.formatBytes(disponivelDisco)); // colocar aqui a QTD DIPONIVEL do HD
                    preparedStatment.setString(10, gpu.name); // colocar aqui o nome da GPU
                    String nomeMaquina = sistema.getOperatingSystem().getNetworkParams().getHostName(); // pega a descrisao do tipo de maquina

                    preparedStatment.setString(11, nomeMaquina); // Descrisao da maquina

                    preparedStatment.executeUpdate();

                    System.out.println("Maquina incluida  com sucesso ! ! !");
                }
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

