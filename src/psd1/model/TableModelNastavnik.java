/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psd1.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import psd1.domain.Nastavnik;
import psd1.domain.Zvanje;

/**
 *
 * @author pc
 */
public class TableModelNastavnik extends AbstractTableModel {

    String[] columnName = new String[]{"ime", "prezime", "zvanje"};
    Class[] columnClass = new Class[]{String.class, String.class, Zvanje.class};
    List<Nastavnik> nastavnici;

    public  TableModelNastavnik(List<Nastavnik> nastavnici) {
        this.nastavnici = nastavnici;
    }

    @Override
    public int getRowCount() {
        return nastavnici.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Nastavnik n = nastavnici.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return n.getIme();
            case 1:
                return n.getPrezime();
            case 2:
                return n.getZvanje();

            default:
                return "n/a";
        }

    }



    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex >= 0 && columnIndex < columnName.length) {
            return (Class) columnClass[columnIndex];
        }
        return Object.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column >= 0 && column < columnName.length) {
            return columnName[column];
        }
        return "n/a";
    }
    
    
    public List<Nastavnik> getAll(){
        return nastavnici;
    }
    
    public Nastavnik getNastavnik(int index){
        return nastavnici.get(index);
                
    }
      public void add(Nastavnik n) {
        this.nastavnici.add(n);
        this.fireTableDataChanged();
    }
    
 
}
