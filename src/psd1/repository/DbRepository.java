/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psd1.repository;

import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class DbRepository {
    
    public void connect() throws SQLException{
        DBConnectionFactory.getInstance().getConnection();
    }
    
    public void disconnect() throws SQLException{
        DBConnectionFactory.getInstance().getConnection().close();
        System.out.println("USPESNO RASKIDANJE");
    }
    
    public void commit() throws SQLException{
        DBConnectionFactory.getInstance().getConnection().commit();
    }
    
    public void rollback() throws SQLException{
        DBConnectionFactory.getInstance().getConnection().rollback();
    }
}
