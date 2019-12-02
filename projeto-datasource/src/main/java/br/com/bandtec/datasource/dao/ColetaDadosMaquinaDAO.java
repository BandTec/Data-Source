/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.dao;

import br.com.bandtec.datasource.conexao.DadosConexao;
import br.com.bandtec.datasource.model.ColetaDadosMaquina;
import br.com.bandtec.datasource.model.Maquina;
import br.com.bandtec.datasource.utils.GeracaoLog;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author aluno
 */
public class ColetaDadosMaquinaDAO {

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

    ColetaDadosMaquina coletaDadosMaquina = new ColetaDadosMaquina();
    SystemInfo si = new SystemInfo();
    HardwareAbstractionLayer hal = si.getHardware();
    OperatingSystem os = si.getOperatingSystem();
    DadosConexao dadosConexao = new DadosConexao();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());

    public void insertDadosMaquina() throws IOException {
        PreparedStatement preparedStatment = null;
        String nomeMaquina = si.getOperatingSystem().getNetworkParams().getHostName();
        String sql = "SELECT ID_MAQU_CD_MAQUINA FROM  [DBO].[TB_MAQUINA_MAQU] WHERE MAQU_NOME ='" + nomeMaquina + "'";
        Long id = jdbcTemplate.queryForObject(sql, Long.class);

        try {
            conn = DriverManager.getConnection(url);
            // String query = "insert into TB_COLETA_DADOS_CODA values(?,?,?,?,1);";
            String query = "insert into TB_COLETA_DADOS_CODA values(?,?,?,?," + id + ");";
            preparedStatment = conn.prepareStatement(query);
            preparedStatment.setString(1, coletaDadosMaquina.getUsoCPU() + " %");
            preparedStatment.setString(2, coletaDadosMaquina.getUsoRam() + " %");
            preparedStatment.setString(3, coletaDadosMaquina.getUsoDisco() + " %");
            preparedStatment.setString(4, coletaDadosMaquina.getDataHoraColeta()
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
            preparedStatment.executeUpdate();

        } catch (SQLException e) {
            GeracaoLog.GravarLog("Erro na Conexão:" + e);
            System.out.println("Erro na Conexão: " + e);
        } finally {
            try {
                System.out.println("Dados da maquina foram incluidos!!!");
                preparedStatment.close();
                conn.close();
            } catch (SQLException e) {
                GeracaoLog.GravarLog("Erro na Conexão:" + e);
                System.out.println("Erro na Conexão:" + e);
            }
        }
    }

}
