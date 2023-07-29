/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
            throw new RuntimeException("ERRO, sem conexão com o banco de dados, verifique a conexão com a rede.");
        }
    }

    public static void  closeConnection(Connection Connection){
        try {
            if (Connection != null){
                Connection.close();
                }
            }catch (Exception ex){
                throw new RuntimeException("ERRO, erro ao fechar a conexão com o bando de dados.");
            }
        }
    
    public static void  closeConnection(Connection Connection, PreparedStatement statement){
        try {
            if (Connection != null){
                Connection.close();
                }
            if (statement != null){
                statement.close();
            }
            }catch (Exception ex){
                throw new RuntimeException("ERRO, erro ao fechar a conexão com o bando de dados.");
            }
        }
    
    
    }





