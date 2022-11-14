/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psd1.model;

import java.util.List;
import psd1.domain.Nastavnik;
import psd1.domain.Zvanje;

/**
 *
 * @author pc
 */
public class TableModelNastavnikExtended extends TableModelNastavnik {

    public TableModelNastavnikExtended(List<Nastavnik> nastavnici) {
        super(nastavnici);

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        Nastavnik n = nastavnici.get(rowIndex);
        if (n.getZvanje()==null || n.getZvanje().getId() != 5 ) {
            if (columnIndex <= 2) {
                return true;
            }

        }
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Nastavnik n = nastavnici.get(rowIndex);
        switch (columnIndex) {
            case 0:
                n.setIme((String) aValue);
                break;
            case 1:
                n.setPrezime((String) aValue);
                break;

            case 2:
                n.setZvanje((Zvanje) aValue);
                break;
            default:
                break;
        }
    }

    public void remove(int selectedRow) {
        nastavnici.remove(selectedRow);
        fireTableDataChanged();
    }

}
