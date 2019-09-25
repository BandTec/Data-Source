/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.conexao;

import br.com.bandtec.datasource.model.GeracaoLog;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bandtec
 */
public class ConexaoBD {
   
    private final String hostName = ""; // host do banco
    private final String dbName = ""; // nome banco
    private final String user = ""; // usuario
    private final String password = ""; // senha
    private final String url = String.format("jdbc:sqlserver://%s:1433;"
            + "database=%s;"
            + "user=%s;"
            + "password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;"
            + "loginTimeout=30;", hostName, dbName, user, password);
    
    // Declaracao e inicializacao de uma variavel do tipo Connection que armazenara a conexao estabelecida
    private Connection conn = null;
           

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
            GeracaoLog.GravarLog("Conexão concluida");
            System.out.println("Connectado com sucesso ! ! !");
            // Se der erro no try verifica qual erro foi gerado
        } catch (SQLException e) {
            GeracaoLog.GravarLog("Erro na Conexão:"+ e);
            // se ClassNotFoundException o servidor (sql) nao foi encontrado, 	
        }
        // se der outro erro, apresenta a descricaoo do erro utilizando
        // a classe SQLException que trata de erros scripts slq
        return ret;

    }
    
}
