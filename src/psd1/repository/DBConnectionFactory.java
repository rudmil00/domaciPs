/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psd1.repository;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class DBConnectionFactory {

    private static DBConnectionFactory instance;
    private Connection connection;

    private DBConnectionFactory() {

    }

    public static DBConnectionFactory getInstance() {
        if (instance == null) {
            instance = new DBConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        try{
           if(connection==null || connection.isClosed()){
               String url="jdbc:mysql://localhost:3306/studentska_sluzba";
               String user="root";
               String pass="";
               
               connection=(Connection) DriverManager.getConnection(url, user, pass);
               connection.setAutoCommit(false);
               System.out.println("USpesna konekcija");
           }
        }catch(SQLException ex){
            System.out.println("Neuspesno pravljenje konekcije"+ex);
        }
           return connection;
    }
}
