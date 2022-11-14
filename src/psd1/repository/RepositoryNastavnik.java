/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psd1.repository;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import psd1.domain.Nastavnik;
import psd1.domain.Zvanje;

/**
 *
 * @author pc
 */
public class RepositoryNastavnik extends DbRepository {

    List<Nastavnik> nastavnici;

    public void saveNastavnik(Nastavnik n, boolean update) throws SQLException {
        try {
            Connection conn = DBConnectionFactory.getInstance().getConnection();
            if (update == true) {
                String query = "update nastavnik set ime = ?, prezime = ?, zvanje_id = ? where id = ?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, n.getIme());
                pst.setString(2, n.getPrezime());
                pst.setInt(3, n.getZvanje().getId());
                pst.setInt(4, n.getId());
                System.out.println(query);
                pst.executeUpdate();
                pst.close();
                System.out.println("USPESAN UPDATE");
            } else {
                String query = "INSERT INTO nastavnik(ime,prezime,zvanje_id) VALUES (?,?,?)";
                PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, n.getIme());
                pst.setString(2, n.getPrezime());
                pst.setInt(3, n.getZvanje().getId());
                System.out.println(query);
                pst.executeUpdate();
                ResultSet rs = pst.getGeneratedKeys();
                if (rs.next()) {
                    n.setId(rs.getInt(1));
                }
                pst.close();
                System.out.println("USPESAN INSERT");

            }

            this.commit();

            this.disconnect();

        } catch (SQLException ex) {
            System.out.println("Neuspesnooooo" + ex);
            this.rollback();
        }
    }

    public List<Nastavnik> getAll() throws SQLException {
        nastavnici = new ArrayList<>();
        try {
            String query = "SELECT n.id,n.ime,n.prezime,n.zvanje_id,z.id,z.naziv from nastavnik n join zvanje z on(n.zvanje_id=z.id) ORDER BY z.id ";
            System.out.println(query);
            Statement st = DBConnectionFactory.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Nastavnik n = new Nastavnik();
                n.setId(rs.getInt("n.id"));
                n.setIme(rs.getString("n.ime"));
                n.setPrezime(rs.getString("n.prezime"));
                Zvanje z = new Zvanje();
                z.setId(rs.getInt("n.zvanje_id"));
                z.setNaziv(rs.getString("z.naziv"));
                n.setZvanje(z);

                nastavnici.add(n);

            }
            this.commit();
            rs.close();
            st.close();

        } catch (SQLException ex) {
            this.rollback();
            Logger.getLogger(RepositoryNastavnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.disconnect();
        return nastavnici;
    }

    public void removeNastavnik(int id) throws SQLException {
        try {
            String query = "DELETE FROM nastavnik where id=" + id;
            Statement stat = DBConnectionFactory.getInstance().getConnection().createStatement();
            stat.executeUpdate(query);
            this.commit();
            stat.close();
            this.disconnect();
            System.out.println("USpesno izbrisan nastavnik");
        } catch (SQLException ex) {
            this.rollback();
            Logger.getLogger(RepositoryNastavnik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sync(List<Nastavnik> toSave, List<Nastavnik> toDelete) throws SQLException {
        /*
        Ovde je moguce i primit samo `toSave` pa potom iz baze obrisati sve ID-eve
        koji se ne nalaze u listi za cuvanje
        
        Implementacija: `syncAdvanced()`
         */

        this.connect();

        for (Nastavnik n : toSave) {
            this.saveNastavnik(n, false);
        }

        for (Nastavnik n : toDelete) {
            this.removeNastavnik(n.getId());
        }

        this.disconnect();
    }
}
