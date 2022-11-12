/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psd1.domain;

/**
 *
 * @author pc
 */
public class Nastavnik {

    private int id;
    private String ime;
    private String prezime;
    private Zvanje zvanje;

    public Nastavnik() {
    }

    public Nastavnik(int id, String ime, String prezime, Zvanje zvanje) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.zvanje = zvanje;
    }

    public Nastavnik(String ime, String prezime, Zvanje zvanje) {

        this.ime = ime;
        this.prezime = prezime;
        this.zvanje = zvanje;
    }

//    public boolean isValid()
//    {
//        return !ime.isEmpty() && ime.matches("[a-zA-Z]+") && ime.length() <= 100 &&
//                !prezime.isEmpty() && prezime.matches("[a-zA-Z]+") && prezime.length() <= 100 &&
//                zvanje != null;
//    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Zvanje getZvanje() {
        return zvanje;
    }

    public void setZvanje(Zvanje zvanje) {
        this.zvanje = zvanje;

    }

    public boolean isValid() {
        return this.getIme().matches("[a-zA-Z]+") && this.getIme().length() < 100 && !this.getIme().isEmpty()
                && this.getPrezime().matches("[a-zA-Z]+") && this.getPrezime().length() < 100 && !this.getPrezime().isEmpty();
    }

    @Override
    public String toString() {
        return "Nastavnik{" + "id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", zvanje=" + zvanje + '}';
    }

}
