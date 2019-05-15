/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import forme.potvrde.PotvrdaOIzmeniKnjige;
import domen.Knjiga;
import domen.Primerak;
import java.awt.Dimension;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import komunikacija.Komunikacija;
import static modeli.ModelTabeleKnjiga.getBufferedImage;
import operacije.Operacija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author STEFAN94
 */
public class IzmeniPodatkeOKnjiziForma extends javax.swing.JDialog {

    private Knjiga selektovanaKnjiga;
    private byte[] slika = null;
    private ArrayList<Primerak> primerciZaRashodovanje;
    private int brojPrimeraka;
    private Knjiga izmenjenaKnjiga;
    private String putanja;
    
    /**
     * Creates new form IzmeniPodatkeOKnjiziForma
     *
     * @param parent
     * @param modal
     */
    public IzmeniPodatkeOKnjiziForma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.getContentPane().setBackground(java.awt.Color.lightGray);
        initComponents();
        popuniPolja();
        popuniCombobox();
        popuniTabeluPrimeraka();
        putanja = "";
        txtIsbn.setEditable(false);
        primerciZaRashodovanje = new ArrayList<>();
        slika = selektovanaKnjiga.getSlika();
        niti.NitOsluskujIzmenjenaKnjiga noik = new niti.NitOsluskujIzmenjenaKnjiga(this);
        noik.start();
        
        Dimension screenSize, frameSize;
        int x, y;
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize = getSize();
        x = (screenSize.width - frameSize.width) / 2;
        y = (screenSize.height - frameSize.height) / 2;
        setLocation(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnDodajPrimerak = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        txtNaziv = new javax.swing.JTextField();
        txtPisac = new javax.swing.JTextField();
        txtGodinaIzdanja = new javax.swing.JTextField();
        txtPismo = new javax.swing.JTextField();
        txtBrojStrana = new javax.swing.JTextField();
        cmbZanr = new javax.swing.JComboBox<>();
        txtPovez = new javax.swing.JTextField();
        btnIzmeni = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        spnBrojPrimeraka = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPrimerci = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnSlika = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Izmena podataka o knjizi");

        jLabel1.setText("ISBN:");

        jLabel2.setText("Naziv:");

        jLabel3.setText("Pisac:");

        jLabel4.setText("Godina izdanja:");

        jLabel5.setText("Pismo:");

        jLabel6.setText("Broj strana:");

        jLabel7.setText("Zanr:");

        jLabel8.setText("Povez:");

        btnDodajPrimerak.setText("Dodaj primerak:");

        jLabel10.setText("Slika:");

        txtPismo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPismoActionPerformed(evt);
            }
        });

        cmbZanr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        jLabel11.setText("ID primerka knjige:");

        tblPrimerci.setBackground(new java.awt.Color(0, 102, 102));
        tblPrimerci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Status", "Rashoduj"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPrimerci);

        btnSlika.setText("Izmeni sliku");
        btnSlika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSlikaActionPerformed(evt);
            }
        });

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtIsbn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNaziv))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtPisac))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtGodinaIzdanja))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtPismo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtBrojStrana))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(cmbZanr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPovez))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnDodajPrimerak)
                                .addGap(18, 18, 18)
                                .addComponent(spnBrojPrimeraka))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(btnSlika, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzmeni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOdustani))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPisac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGodinaIzdanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPismo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBrojStrana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbZanr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPovez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajPrimerak)
                    .addComponent(spnBrojPrimeraka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel9)
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(btnSlika))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzmeni)
                    .addComponent(btnOdustani))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPismoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPismoActionPerformed

    }//GEN-LAST:event_txtPismoActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed

        int brojStrana = 0;
        try {
            brojStrana = Integer.parseInt(txtBrojStrana.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Molimo Vas da u polje 'broj strana' unosite samo brojeve");
            return;
        }
        if (brojStrana < 0) {
            JOptionPane.showMessageDialog(this, "Broj strana mora biti pozitivan broj");
            return;
        }

        String godinaIzdanja = txtGodinaIzdanja.getText();
        String godinaIzdanjaPattern = "^[1|2][0-9]{3}$";
        if (!godinaIzdanja.matches(godinaIzdanjaPattern)) {
            JOptionPane.showMessageDialog(this, "Molimo Vas da u polje 'godina izdanja' unesete validnu godinu");
            return;
        }

        String isbn = txtIsbn.getText();
        String naziv = txtNaziv.getText();
        String pisac = txtPisac.getText();
        String povez = txtPovez.getText();
        String pismo = txtPismo.getText();
        String zanr = (String) cmbZanr.getSelectedItem();

        DefaultTableModel dtm = (DefaultTableModel) tblPrimerci.getModel();
        int brojRedova = dtm.getRowCount();
        String nerazduzeniPrimerci = "";
        String rashodovaniPrimerci = "";
        int brojNerazduzenihPrimeraka = 0;
        int brojRashodovanihPrimeraka = 0;
        for (int i = 0; i < brojRedova; i++) {
            int id = (int) dtm.getValueAt(i, 0);
            String status = (String) dtm.getValueAt(i, 1);
            boolean selektovan = (boolean) dtm.getValueAt(i, 2);
            if (selektovan && status.equalsIgnoreCase("Nije zaduzen")) {
                Primerak p = new Primerak(id, selektovanaKnjiga.getIsbn(), status.equalsIgnoreCase("Zaduzen"), true);
                primerciZaRashodovanje.add(p);
            } else {
                if (selektovan && status.equalsIgnoreCase("Zaduzen")) {
                    brojNerazduzenihPrimeraka++;
                    nerazduzeniPrimerci += "\n ID:" + id;
                } else if (selektovan && status.equalsIgnoreCase("Rashodovan")) {
                    brojRashodovanihPrimeraka++;
                    rashodovaniPrimerci += "\n ID:" + id;
                }
            }
        }

        if (brojNerazduzenihPrimeraka > 0 || brojRashodovanihPrimeraka > 0) {
            String primerciObavestenje = "";
            if (brojNerazduzenihPrimeraka > 0) {
                primerciObavestenje = (brojNerazduzenihPrimeraka == 1) ? "Nerazduzeni primerak: " + nerazduzeniPrimerci : "Nerazduzeni primerci: " + nerazduzeniPrimerci;
            }
            String rashodovaniPrimerciObavestenje = "";
            if (brojRashodovanihPrimeraka > 0) {
                rashodovaniPrimerciObavestenje = (brojRashodovanihPrimeraka == 1) ? " Vec rashodovani primerak: " + rashodovaniPrimerci : "Vec rashodovani primerci: " + rashodovaniPrimerci;
            }
            JOptionPane.showMessageDialog(this, primerciObavestenje + "\n " + rashodovaniPrimerciObavestenje);
            return;
        }

        brojPrimeraka = (int) spnBrojPrimeraka.getValue();
        System.out.println("" + brojPrimeraka);
        if (brojPrimeraka < 0) {
            JOptionPane.showMessageDialog(this, "Broj primeraka mora biti pozitivan broj");
            return;
        }

        System.out.println("br: " + primerciZaRashodovanje.size());
        izmenjenaKnjiga = new Knjiga(isbn, naziv, pisac, godinaIzdanja, pismo, brojStrana, zanr, povez, slika, primerciZaRashodovanje);
        izmenjenaKnjiga.setBrojPrimeraka(brojPrimeraka);

        GlavnaForma glavnaForma = (GlavnaForma) this.getParent();
        ArrayList<Knjiga> listaKnjiga = glavnaForma.getListaKnjiga();
        for (Knjiga knjiga : listaKnjiga) {
            if (isbn.equals(knjiga.getIsbn()) && (!selektovanaKnjiga.equals(knjiga))) {
                JOptionPane.showMessageDialog(this, "Knjiga sa datim ISBN-om vec postoji");
                return;
            }
        }
        if(!isbn.equals(selektovanaKnjiga.getIsbn())){
            System.out.println("Moramo naci resenje!");
            return;
        }
       
        glavnaForma.setIzmenjenaKnjiga(izmenjenaKnjiga);
        PotvrdaOIzmeniKnjige potvrdaOIzmeniKnjige = new PotvrdaOIzmeniKnjige(glavnaForma, true);
        potvrdaOIzmeniKnjige.pack();
        potvrdaOIzmeniKnjige.setVisible(true);
        popuniTabeluPrimeraka();
        spnBrojPrimeraka.setValue(0);
        primerciZaRashodovanje = new ArrayList<>();

    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnSlikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSlikaActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("JPEG file", "jpg", "jpeg");
        fileChooser.setFileFilter(filter);
        fileChooser.showOpenDialog(null);
        File fajl = fileChooser.getSelectedFile();
        String fileName = fajl.getName();
        putanja = fajl.getAbsolutePath();
        btnSlika.setText(fileName);
        try {
            slika = Files.readAllBytes(fajl.toPath());
            ImageIcon sl = new ImageIcon(slika);
            Image image = sl.getImage();
            Image newimg = image.getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH);
            sl = new ImageIcon(newimg);
            BufferedImage bi = getBufferedImage(sl.getImage());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            slika = baos.toByteArray();
        } catch (IOException ex) {
            slika = selektovanaKnjiga.getSlika();
        }
        if (slika == null) {
            slika = selektovanaKnjiga.getSlika();
        }

    }//GEN-LAST:event_btnSlikaActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed

        dispose();

    }//GEN-LAST:event_btnOdustaniActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IzmeniPodatkeOKnjiziForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IzmeniPodatkeOKnjiziForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IzmeniPodatkeOKnjiziForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IzmeniPodatkeOKnjiziForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IzmeniPodatkeOKnjiziForma dialog = new IzmeniPodatkeOKnjiziForma(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDodajPrimerak;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnSlika;
    private javax.swing.JComboBox<String> cmbZanr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner spnBrojPrimeraka;
    private javax.swing.JTable tblPrimerci;
    private javax.swing.JTextField txtBrojStrana;
    private javax.swing.JTextField txtGodinaIzdanja;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtPisac;
    private javax.swing.JTextField txtPismo;
    private javax.swing.JTextField txtPovez;
    // End of variables declaration//GEN-END:variables

    private void popuniCombobox() {

        cmbZanr.removeAllItems();
        String[] zanrovi = Knjiga.LISTA_ZANROVA;

        for (int i = 0; i < zanrovi.length - 1; i++) {
            cmbZanr.addItem(zanrovi[i]);
        }

    }

    private void popuniPolja() {

        GlavnaForma glavnaForma = (GlavnaForma) this.getParent();
        int indeksSelektovaneKnjige = glavnaForma.vratiIndeksSelektovaneKnjige();
        selektovanaKnjiga = glavnaForma.vratiSelektovanuKnjigu(indeksSelektovaneKnjige);
        txtBrojStrana.setText("" + selektovanaKnjiga.getBrojStrana());
        txtGodinaIzdanja.setText(selektovanaKnjiga.getGodinaIzdanja());
        txtIsbn.setText(selektovanaKnjiga.getIsbn());
        txtNaziv.setText(selektovanaKnjiga.getNaziv());
        txtPisac.setText(selektovanaKnjiga.getPisac());
        txtPovez.setText(selektovanaKnjiga.getPovez());
        txtPismo.setText(selektovanaKnjiga.getPismo());
        cmbZanr.setSelectedItem(selektovanaKnjiga.getZanr());
        byte[] slika = selektovanaKnjiga.getSlika();

    }

    private void popuniTabeluPrimeraka() {

        KlijentskiZahtev kz = new KlijentskiZahtev();
        Primerak p = new Primerak();
        p.setIsbn(selektovanaKnjiga.getIsbn());
        kz.setParametar(p);
        kz.setOperacija(Operacija.VRATI_PRIMERKE);

        Komunikacija.getInstanca().posaljiKlijentskiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiServerskiOdgovor();
        ArrayList<Primerak> listaPrimeraka = (ArrayList<Primerak>) so.getOdgovor();

        DefaultTableModel dtm = (DefaultTableModel) tblPrimerci.getModel();
        if (dtm.getRowCount() > 0) {
            for (int i = dtm.getRowCount() - 1; i > -1; i--) {
                dtm.removeRow(i);
            }
        }

        for (Primerak primerak : listaPrimeraka) {
            dtm.addRow(new Object[]{primerak.getPrimerakId(), primerak.isRashodovan() ? "Rashodovan" : (primerak.isZaduzen() ? "Zaduzen" : "Nije zaduzen"), false});
        }
    }

    public javax.swing.JButton getBtnIzmeni() {
        return btnIzmeni;
    }

    public void setBtnIzmeni(javax.swing.JButton btnIzmeni) {
        this.btnIzmeni = btnIzmeni;
    }

    public javax.swing.JTextField getTxtBrojStrana() {
        return txtBrojStrana;
    }

    public void setTxtBrojStrana(javax.swing.JTextField txtBrojStrana) {
        this.txtBrojStrana = txtBrojStrana;
    }

    public javax.swing.JTextField getTxtGodinaIzdanja() {
        return txtGodinaIzdanja;
    }

    public void setTxtGodinaIzdanja(javax.swing.JTextField txtGodinaIzdanja) {
        this.txtGodinaIzdanja = txtGodinaIzdanja;
    }

    public javax.swing.JTextField getTxtIsbn() {
        return txtIsbn;
    }

    public void setTxtIsbn(javax.swing.JTextField txtIsbn) {
        this.txtIsbn = txtIsbn;
    }

    public javax.swing.JTextField getTxtNaziv() {
        return txtNaziv;
    }

    public void setTxtNaziv(javax.swing.JTextField txtNaziv) {
        this.txtNaziv = txtNaziv;
    }

    public javax.swing.JTextField getTxtPisac() {
        return txtPisac;
    }

    public void setTxtPisac(javax.swing.JTextField txtPisac) {
        this.txtPisac = txtPisac;
    }

    public javax.swing.JTextField getTxtPismo() {
        return txtPismo;
    }

    public void setTxtPismo(javax.swing.JTextField txtPismo) {
        this.txtPismo = txtPismo;
    }

    public javax.swing.JTextField getTxtPovez() {
        return txtPovez;
    }

    public void setTxtPovez(javax.swing.JTextField txtPovez) {
        this.txtPovez = txtPovez;
    }

    public javax.swing.JSpinner getSpnBrojPrimeraka() {
        return spnBrojPrimeraka;
    }

    public void setSpnBrojPrimeraka(javax.swing.JSpinner spnBrojPrimeraka) {
        this.spnBrojPrimeraka = spnBrojPrimeraka;
    }

}