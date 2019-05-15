/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Zaduzenje;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author STEFAN94
 */
public class ModelTabeleZaduzenjaClana extends AbstractTableModel {

    ArrayList<Zaduzenje> listaZaduzenja;

    public ModelTabeleZaduzenjaClana(ArrayList<Zaduzenje> listaZaduzenja) {
        this.listaZaduzenja = listaZaduzenja;
    }

    @Override
    public int getRowCount() {
        return listaZaduzenja.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zaduzenje z = listaZaduzenja.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return z.getKnjiga().getNaziv();
            case 1:
                return z.getKnjiga().getPisac();
            case 2:
                return z.getKnjiga().getIsbn();
            case 3:
                return z.getPrimerak().getPrimerakId();
            case 4:
                return z.getDatumZaduzenja();
            case 5:
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
                return "Naziv knjige";
            case 1:
                return "Pisac";
            case 2:
                return "ISBN";
            case 3:
                return "Primerak ID";
            case 4:
                return "Datum zaduzenja";
            case 5:
                return "Datum razduzenja";

            default:
                return "n/a";
        }
    }

    public Zaduzenje vratiSelektovanoZaduzenje(int indeksSelektovanogZaduzenja) {
        return listaZaduzenja.get(indeksSelektovanogZaduzenja);
    }

    public void azurirajTabelu(ArrayList<Zaduzenje> listaPretrazenihZaduzenja) {
        listaZaduzenja = listaPretrazenihZaduzenja;
        fireTableDataChanged();
    }

}
