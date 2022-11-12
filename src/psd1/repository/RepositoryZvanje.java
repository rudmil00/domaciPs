/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psd1.repository;

import java.util.List;
import psd1.domain.Zvanje;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class RepositoryZvanje extends DbRepository {

    List<Zvanje> zvanja=new ArrayList<>();

    public List<Zvanje> getAllZvanja() {
        try {
            String query = "SELECT id, naziv from zvanje";
            System.out.println(query);
            Connection conn = DBConnectionFactory.getInstance().getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                Zvanje zvanje = new Zvanje();
                zvanje.setId(rs.getInt("id"));
                zvanje.setNaziv(rs.getString("naziv"));
                zvanja.add(zvanje);
            }
            
            this.commit();
            statement.close();
            rs.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RepositoryZvanje.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return zvanja;

    }

}
