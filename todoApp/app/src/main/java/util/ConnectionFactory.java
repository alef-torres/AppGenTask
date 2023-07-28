/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alef_
 */
public class ConnectionFactory {
    
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoapp";
    public static final String USER = "root";
    public static final String PASS = "";

    public static Connection getConnection(){
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("ERRO, sem conexão com o banco de dados");
        }
    }

    public static void  closeConnection(Connection Connection){
        try {
            if (Connection != null){
                Connection.close();
                }
            }catch (Exception ex){
                throw new RuntimeException("ERRO, erro ao fechar a conexão com o bando de dados");
            }
        }
    
    
    }





