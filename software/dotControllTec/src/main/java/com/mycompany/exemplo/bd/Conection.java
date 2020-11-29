/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exemplo.bd;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Aluno
 */
public class Conection {

    private final BasicDataSource datasource;
       // Construtor
    public Conection() {
        this.datasource = new BasicDataSource();
        this.datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.datasource.setUrl("jdbc:sqlserver://banco123.database.windows.net:1433;database=Banco123;user=gustavo@banco123;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        this.datasource.setUsername("gustavo");
        this.datasource.setPassword("Yudi2001");
    }
    
    
    // Getter

    public BasicDataSource getDatasource() {
        return datasource;
    }
}
