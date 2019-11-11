/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.dao;

import br.com.bandtec.datasource.model.ProcessosMaquina;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.bandtec.datasource.utils.GeracaoLog;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import oshi.PlatformEnum;
import oshi.SystemInfo;

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


    public void insertProcesso() throws IOException {
        PreparedStatement preparedStatment = null;

        try {
            conn = DriverManager.getConnection(url);
            
//            criar um select com where para pegar a maquina que o usuario esta usando e inserir os processos nela

            // parametros (?) na construcao da string de SQL
            String query = "insert into TB_PROCESSOS_MAQUINA_PRMA values(?,?,?,?,?,1);";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            preparedStatment = conn.prepareStatement(query);

            for (int i = 0; i < 10; i++) {
                preparedStatment.setString(1, processosMaquina.getPidProcesso().get(i));
                preparedStatment.setString(2, processosMaquina.getNomeProcesso().get(i));
                preparedStatment.setInt(3, processosMaquina.getUsoCpuProcesso().get(i));
                preparedStatment.setString(4, processosMaquina.getUsoRamProcesso().get(i));
                preparedStatment.setString(5, processosMaquina.getDataHoraProcesso().format(formatter));
                preparedStatment.executeUpdate();
            }

        } catch (SQLException e) {
            GeracaoLog.GravarLog("Erro na Conexão:" + e);
            System.out.println("Erro na Conexão: " + e);
        } finally {
            try {
                preparedStatment.close();
                conn.close();
            } catch (SQLException e) {
                GeracaoLog.GravarLog("Erro na Conexão:" + e);
                System.out.println("Erro na Conexão:" + e);
            }
        }
    }
}
