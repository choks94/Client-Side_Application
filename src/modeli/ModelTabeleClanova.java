/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Clan;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author STEFAN94
 */
public class ModelTabeleClanova extends AbstractTableModel {
    
    ArrayList<Clan> listaClanova;
    
    public ModelTabeleClanova(ArrayList<Clan> listaClanova) {
        this.listaClanova = listaClanova;
    }
    
    @Override
    public int getRowCount() {
        return listaClanova.size();
    }
    
    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Clan clan = listaClanova.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return clan.getClanID();
            case 1:
                return clan.getIme();
            case 2:
                return clan.getPrezime();
            case 3:
                return clan.getDatumRodjenja();
            case 4:
                return clan.getKontaktTelefon();
            case 5:
                return clan.getEmail();
            case 6: 
                return clan.getJmbg();
            default:
                return "n/a";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Ime";
            case 2:
                return "Prezime";
            case 3:
                return "Datum rodjenja";
            case 4:
                return "Kontakt telefon";
            case 5:
                return "Email";
            case 6:
                return "JMBG";
            default:
                return "n/a";
        }
    }
    
    public void azurirajTabelu(ArrayList<Clan> listaClanova) {
        
        this.listaClanova = listaClanova;
        fireTableDataChanged();
        
    }
    
    public void dodajNovogClana(Clan noviClan) {
        
        listaClanova.add(noviClan);
        fireTableDataChanged();
        
    }
    
    public Clan vratiSelektovanogClana(int clanZaBrisanjeIndeks) {
        
        Clan selektovaniClan = null;
        for (Clan clan : listaClanova) {
            if (clanZaBrisanjeIndeks == listaClanova.indexOf(clan)) {
                selektovaniClan = clan;
            }
        }
        return selektovaniClan;
        
    }
    
}
