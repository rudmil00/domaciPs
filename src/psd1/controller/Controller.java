/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psd1.controller;

import java.sql.SQLException;
import java.util.List;
import psd1.domain.Nastavnik;
import psd1.domain.Zvanje;
import psd1.repository.RepositoryNastavnik;
import psd1.repository.RepositoryPredmet;
import psd1.repository.RepositoryZvanje;

/**
 *
 * @author pc
 */
public class Controller {

    private static Controller instance;
    private final RepositoryNastavnik repositoryNastavnik;
    private final RepositoryPredmet repositoryPredmet;
    private final RepositoryZvanje repositoryZvanje;

    private Controller() {
        repositoryNastavnik = new RepositoryNastavnik();
        repositoryPredmet = new RepositoryPredmet();
        repositoryZvanje = new RepositoryZvanje();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }

    public List<Zvanje> getAllZvanja() {
        return repositoryZvanje.getAllZvanja();

    }

    public void insertUpdate(Nastavnik n, boolean update) throws SQLException {
        repositoryNastavnik.saveNastavnik(n, update);
    }

    public List<Nastavnik> getAllNastavnici() throws SQLException {
        return repositoryNastavnik.getAll();
    }

    public void removeNastavnik(int id) throws SQLException {
        repositoryNastavnik.removeNastavnik(id);
    }

    public void sync(List<Nastavnik> toSave, List<Nastavnik> toDelete) throws SQLException {
        repositoryNastavnik.sync(toSave, toDelete);
    }
}
