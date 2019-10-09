/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.conexao;

import br.com.bandtec.datasource.model.CpuUser;
import br.com.bandtec.datasource.model.GeracaoLog;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    CpuUser cpu = new CpuUser();

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
//            GeracaoLog.GravarLog("Conexão concluida");
            System.out.println("Conectado com sucesso ! ! !");
            // Se der erro no try verifica qual erro foi gerado
        } catch (SQLException e) {
//            GeracaoLog.GravarLog("Erro na Conexão:" + e);
             System.out.println("Erro na Conexão:" + e);
            // se ClassNotFoundException o servidor (sql) nao foi encontrado, 	
        }
        // se der outro erro, apresenta a descricaoo do erro utilizando
        // a classe SQLException que trata de erros scripts slq
        return ret;

    }

    public void incluirTeste() throws IOException, SQLException {

        PreparedStatement preparedStatment = null;

        try {

            conn = DriverManager.getConnection(url);

            // parametros (?) na construcao da string de SQL
            String query = "insert into tb_maquina_usuario values(?,?,?,?,?,?,?,?,?,?,?);";

            preparedStatment = conn.prepareStatement(query);

            preparedStatment.setString(1, cpu.getNomeSistema());
            preparedStatment.setString(2, cpu.getProcessadorNome());
            preparedStatment.setString(3, "uso_CPU %");  // colocar aqui a porcentagem da cpu
            preparedStatment.setString(4, "ram_total"); // colocar aqui quantidade de ram total
            preparedStatment.setString(5, "ram_disponivel"); // colocar quantidade de ram disponivel
            preparedStatment.setString(6, "ram_usada"); // colocar aqui a  quantidade de ram usada
            preparedStatment.setString(7, "nome_GPU"); // colocar aqui o nome da GPU
            preparedStatment.setString(8, "temp_GPU"); // colocar aqui a temperatura da GPU
            preparedStatment.setString(9, "Disco_total"); // colocar aqui o total do HD
            preparedStatment.setString(10, "Disco_disponivel"); // colocar aqui a quantidade disponivel do HD
            preparedStatment.setString(11, "Disco_usado"); // colocar aqui a quantidade usada do HD

            preparedStatment.executeUpdate();
            
             System.out.println("Maquina incluida  com sucesso ! ! !");

        } catch (SQLException e) {
            e.printStackTrace();
//            GeracaoLog.GravarLog("Erro na Conexão:" + e);

        } finally {

            try {
                preparedStatment.close();
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
