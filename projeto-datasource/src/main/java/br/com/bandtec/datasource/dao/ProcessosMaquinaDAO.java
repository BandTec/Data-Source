/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.dao;

import br.com.bandtec.datasource.conexao.DadosConexao;
import br.com.bandtec.datasource.model.ProcessosMaquina;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.bandtec.datasource.utils.GeracaoLog;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author Guide
 */
public class ProcessosMaquinaDAO {

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

    private Connection conn = null;

    ProcessosMaquina processosMaquina = new ProcessosMaquina();
    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    OperatingSystem os = si.getOperatingSystem();
    DadosConexao dadosConexao = new DadosConexao();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());

    public void insertProcesso() throws IOException {
        PreparedStatement preparedStatment = null;
        String nomeMaquina = si.getOperatingSystem().getNetworkParams().getHostName();

        String sql = "SELECT ID_MAQU_CD_MAQUINA FROM  [DBO].[TB_MAQUINA_MAQU] WHERE MAQU_NOME ='" + nomeMaquina + "'";
        Long id = jdbcTemplate.queryForObject(sql, Long.class);

//        List queryIdMaquina = jdbcTemplate.queryForList("SELECT ID_MAQU_CD_MAQUINA FROM  [DBO].[TB_MAQUINA_MAQU] WHERE MAQU_NOME = ?;", nomeMaquina);
        try {
            conn = DriverManager.getConnection(url);

            String query = "insert into TB_PROCESSOS_MAQUINA_PRMA values(?,?,?,?,?," + id + ")";
//            String query = "insert into TB_PROCESSOS_MAQUINA_PRMA values(?,?,?,?,?,1)";

            preparedStatment = conn.prepareStatement(query);

            for (int i = 0; i < 10; i++) {
                preparedStatment.setString(1, processosMaquina.getPidProcesso().get(i));
                preparedStatment.setString(2, processosMaquina.getNomeProcesso().get(i));
                preparedStatment.setInt(3, processosMaquina.getUsoCpuProcesso().get(i));
                preparedStatment.setString(4, processosMaquina.getUsoRamProcesso().get(i));
                preparedStatment.setString(5, processosMaquina.getDataHoraProcesso().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
                preparedStatment.executeUpdate();
            }

        } catch (SQLException e) {
            GeracaoLog.GravarLog("Erro na Conexão:" + e);
            System.out.println("Erro na Conexão: " + e);
        } finally {
            try {
                System.out.println("Dez Processos foram incluidos!!!");
                preparedStatment.close();
                conn.close();
            } catch (SQLException e) {
                GeracaoLog.GravarLog("Erro na Conexão:" + e);
                System.out.println("Erro na Conexão:" + e);
            }
        }
    }
}
