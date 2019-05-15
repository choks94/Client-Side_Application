/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import forme.potvrde.PotvrdaONovomClanu;
import domen.Clan;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import niti.NitOsluskujNoviClan;
import operacije.Operacija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author STEFAN94
 */
public class DodajNovogClanaForma extends javax.swing.JDialog {

    Clan noviClan;

    public DodajNovogClanaForma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(java.awt.Color.lightGray);
        NitOsluskujNoviClan nonc = new NitOsluskujNoviClan(this);
        nonc.start();
        
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtDatumRodjenja = new javax.swing.JTextField();
        txtjmbg = new javax.swing.JTextField();
        txtKontaktTelefon = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novi clan");

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("Datum rodjenja(dd.MM.yyyy):");

        jLabel4.setText("JMBG:");

        jLabel5.setText("Kontakt telefon:");

        jLabel6.setText("Email:");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKontaktTelefon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(txtjmbg)
                            .addComponent(txtEmail)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIme)
                            .addComponent(txtPrezime)
                            .addComponent(txtDatumRodjenja)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSacuvaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOdustani)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDatumRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtjmbg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKontaktTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnOdustani))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed

        String ime = txtIme.getText();
        String prezime = txtPrezime.getText();
        String jmbgString = txtjmbg.getText();
        String kontaktTelefon = txtKontaktTelefon.getText();
        String datumRodjenjaString = txtDatumRodjenja.getText();
        String email = txtEmail.getText();
        long jmbg = 0;
        try {
            jmbg = Long.parseLong(jmbgString);
        } catch (Exception e) {
            email = "";
            JOptionPane.showMessageDialog(this, "Molimo Vas da unesete validne podatke u polje jmbg");
            return;
        }

        Date datumRodjenja = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            datumRodjenja = sdf.parse(datumRodjenjaString);
        } catch (Exception e) {
            datumRodjenjaString = "";
            JOptionPane.showMessageDialog(this, "Molimo Vas da unesete validne podatke u polje datum rodjenja");
            return;
        }

        String emailPattern = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
        if (!email.matches(emailPattern)) {
            JOptionPane.showMessageDialog(this, "Molimo Vas da unesete validnu email adresu");
            return;
        }

        String telefonPattern = "^(06)[0-9](/)[0-9]{6,7}$";
        if (!kontaktTelefon.matches(telefonPattern)) {
            JOptionPane.showMessageDialog(this, "Molimo Vas da unesete validan broj telefona");
            return;
        }

        ClanoviForma clanoviForma = (ClanoviForma) this.getParent();
        ArrayList<Clan> listaClanova = clanoviForma.vratiSveClanove();

        for (Clan clan : listaClanova) {
            if (jmbg == clan.getJmbg()) {
                JOptionPane.showMessageDialog(this, "Korisnik sa datim JMBG brojem vec postoji");
                return;
            }
            if (email.equals(clan.getEmail())) {
                JOptionPane.showMessageDialog(this, "Korisnik sa datim email-om vec postoji");
                return;
            }
        }
        
        KlijentskiZahtev klijentskiZahtev = new KlijentskiZahtev();
        klijentskiZahtev.setOperacija(Operacija.VRATI_SLEDECI_ID);
        klijentskiZahtev.setParametar(new Clan());
        
        Komunikacija.getInstanca().posaljiKlijentskiZahtev(klijentskiZahtev);
        ServerskiOdgovor serverskiOdgovor = Komunikacija.getInstanca().primiServerskiOdgovor();
        int idNovogClana = (int) serverskiOdgovor.getOdgovor();
        
        
        noviClan = new Clan(++idNovogClana, jmbg, ime, prezime, datumRodjenja, kontaktTelefon, email);

        clanoviForma.setNoviClan(noviClan);
        PotvrdaONovomClanu ponc = new PotvrdaONovomClanu(clanoviForma, true);
        ponc.pack();
        ponc.setVisible(true);


    }//GEN-LAST:event_btnSacuvajActionPerformed

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
            java.util.logging.Logger.getLogger(DodajNovogClanaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DodajNovogClanaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DodajNovogClanaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DodajNovogClanaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DodajNovogClanaForma dialog = new DodajNovogClanaForma(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtDatumRodjenja;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtKontaktTelefon;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtjmbg;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtnSacuvaj() {
        return btnSacuvaj;
    }

    public void setBtnSacuvaj(javax.swing.JButton btnSacuvaj) {
        this.btnSacuvaj = btnSacuvaj;
    }

    public javax.swing.JTextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(javax.swing.JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public javax.swing.JTextField getTxtIme() {
        return txtIme;
    }

    public void setTxtIme(javax.swing.JTextField txtIme) {
        this.txtIme = txtIme;
    }

    public javax.swing.JTextField getTxtKontaktTelefon() {
        return txtKontaktTelefon;
    }

    public void setTxtKontaktTelefon(javax.swing.JTextField txtKontaktTelefon) {
        this.txtKontaktTelefon = txtKontaktTelefon;
    }

    public javax.swing.JTextField getTxtPrezime() {
        return txtPrezime;
    }

    public void setTxtPrezime(javax.swing.JTextField txtPrezime) {
        this.txtPrezime = txtPrezime;
    }

    public javax.swing.JTextField getTxtjmbg() {
        return txtjmbg;
    }

    public void setTxtjmbg(javax.swing.JTextField txtjmbg) {
        this.txtjmbg = txtjmbg;
    }

    public javax.swing.JTextField getTxtDatumRodjenja() {
        return txtDatumRodjenja;
    }

    public void setTxtDatumRodjenja(javax.swing.JTextField txtDatumRodjenja) {
        this.txtDatumRodjenja = txtDatumRodjenja;
    }
}