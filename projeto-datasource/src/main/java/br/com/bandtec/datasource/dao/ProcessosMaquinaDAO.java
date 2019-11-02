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
import oshi.SystemInfo;
import br.com.bandtec.datasource.utils.GeracaoLog;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

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
    SystemInfo sistema = new SystemInfo();
    ProcessosMaquina processosMaquina = new ProcessosMaquina();

    public void insertProcesso() throws IOException {

        PreparedStatement preparedStatment = null;
        try {
            conn = DriverManager.getConnection(url);
            // parametros (?) na construcao da string de SQL
            String query = "insert into TB_PROCESSOS_MAQUINA_PRMA values(?,?,?,?,?,1);";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            preparedStatment = conn.prepareStatement(query);
            preparedStatment.setInt(1, processosMaquina.getPidProcesso());
            preparedStatment.setString(2, processosMaquina.getNomeProcesso());
            preparedStatment.setString(3, processosMaquina.getUsoCpuProcesso());
            preparedStatment.setString(4, processosMaquina.getUsoRamProcesso());
            preparedStatment.setString(5, processosMaquina.getDataHoraProcesso().format(formatter));
            preparedStatment.executeUpdate();
            System.out.println("Processos incluidos  com sucesso !");
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
