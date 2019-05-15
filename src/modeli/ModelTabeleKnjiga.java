/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Knjiga;
import domen.Primerak;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author STEFAN94
 */
public class ModelTabeleKnjiga extends AbstractTableModel {

    private String[] columns;
    private Object[][] rows;

    public ModelTabeleKnjiga(String[] columns, Object[][] rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public Class getColumnClass(int column) {
        if (column == 8) {
            return Icon.class;
        } else {
            return getValueAt(0, column).getClass();
        }
    }

    public void azurirajTabelu(Object[][] rows) {

        this.rows = rows;
        fireTableDataChanged();

    }

    public Knjiga vratiKnjigu(int indeks) throws IOException {
        Knjiga knjiga = null;

        String isbn = (String) rows[indeks][0];
        String naziv = (String) rows[indeks][1];
        String pisac = (String) rows[indeks][2];
        String godinaIzdanja = (String) rows[indeks][3];
        String pismo = (String) rows[indeks][4];
        int brojStrana = (int) rows[indeks][5];
        String zanr = (String) rows[indeks][6];
        String povez = (String) rows[indeks][7];
        ImageIcon icon = (ImageIcon) rows[indeks][8];
        byte[] slika = null;
        if (rows[indeks][8] != null) {
            BufferedImage bi = getBufferedImage(icon.getImage());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);

            slika = baos.toByteArray();
        }
        ArrayList<Primerak> listaPrimeraka = (ArrayList<Primerak>) rows[indeks][9];

        knjiga = new Knjiga(isbn, naziv, pisac, godinaIzdanja, pismo, brojStrana, zanr, povez, slika, listaPrimeraka);

        return knjiga;

    }

    public static BufferedImage getBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        BufferedImage bimage = new BufferedImage(img.getWidth(null),
                img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }

    @Override
    public int getRowCount() {
        return rows.length;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return rows[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {

        return this.columns[column];
    }

}
