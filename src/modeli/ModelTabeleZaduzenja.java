/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Zaduzenje;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author STEFAN94
 */
public class ModelTabeleZaduzenja extends AbstractTableModel {

    boolean oboj = false;
    ArrayList<Zaduzenje> listaZaduzenja;

    public ModelTabeleZaduzenja(ArrayList<Zaduzenje> listaZaduzenja) {
        this.listaZaduzenja = listaZaduzenja;
    }

    @Override
    public int getRowCount() {
        return listaZaduzenja.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zaduzenje z = listaZaduzenja.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return z.getClan().getIme();
            case 1:
                return z.getClan().getPrezime();
            case 2:
                return z.getClan().getJmbg();
            case 3:
                return z.getClan().getEmail();
            case 4:
                return z.getClan().getKontaktTelefon();
            case 5:
                return z.getDatumZaduzenja();
            case 6:
                return z.getClan().getJmbg();
            case 7:
                if (z.getDatumRazduzenja() != null) {
                    return z.getDatumRazduzenja();
                } else {
                    return "Nije razduzena";
                }
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Ime";
            case 1:
                return "Prezime";
            case 2:
                return "JMBG";
            case 3:
                return "Email";
            case 4:
                return "Kontakt telefon";
            case 5:
                return "Datum zaduzenja";
            case 6:
                return "JMBG";
            case 7:
                return "Datum razduzenja";
            default:
                return "n/a";
        }
    }

    public void azurirajTabelu(ArrayList<Zaduzenje> listaZaduzenja) {
        this.listaZaduzenja = listaZaduzenja;
        fireTableDataChanged();
    }

    public Zaduzenje vratiSelektovanoZaduzenje(int indeks) {
        return listaZaduzenja.get(indeks);
    }

    public void osvezi() {
        fireTableDataChanged();
    }
}
