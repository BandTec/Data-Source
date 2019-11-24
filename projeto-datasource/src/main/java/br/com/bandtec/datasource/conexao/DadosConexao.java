/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bandtec.datasource.conexao;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Guide
 */
public class DadosConexao {

    private final BasicDataSource dataSource;

    public DadosConexao() {
        dataSource​ = new​ BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://srvdatasource.database.windows.net:1433;databaseName=bddatasource");
        dataSource​.setUsername("userdatasource");
        dataSource​.setPassword("#Gfgrupo6b"); // ou sua senha
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }

}
