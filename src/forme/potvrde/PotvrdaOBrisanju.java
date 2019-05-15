/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.potvrde;

import domen.Clan;
import forme.ClanoviForma;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import operacije.Operacija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author STEFAN94
 */
public class PotvrdaOBrisanju extends javax.swing.JDialog {

    private int clanZaBrisanjeIndeks = -1;
    private Clan clanZaBrisanje = null;

    /**
     * Creates new form PotvrdaOBrisanju
     *
     * @param parent
     * @param modal
     */
    public PotvrdaOBrisanju(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.getContentPane().setBackground(java.awt.Color.lightGray);
        initComponents();
        ClanoviForma clanoviForma = (ClanoviForma) this.getParent();
        clanZaBrisanjeIndeks = clanoviForma.vratiIndeksSelektovanogClana();
        clanZaBrisanje = clanoviForma.vratiSelektovanogClana(clanZaBrisanjeIndeks);
        lblTekst.setText("Da li ste sigurni da zelite da obrisete clana: " + clanZaBrisanje.getIme() + " " + clanZaBrisanje.getPrezime() + "?");
        
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

        lblTekst = new javax.swing.JLabel();
        btnPotvrdi = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Obrisi clana?");

        lblTekst.setText("jLabel1");

        btnPotvrdi.setText("Potvrdi");
        btnPotvrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPotvrdiActionPerformed(evt);
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
                    .addComponent(lblTekst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPotvrdi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                        .addComponent(btnOdustani)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTekst, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPotvrdi)
                    .addComponent(btnOdustani))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed

        dispose();

    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnPotvrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPotvrdiActionPerformed

        KlijentskiZahtev klijentskiZahtev = new KlijentskiZahtev();
        klijentskiZahtev.setParametar(clanZaBrisanje);
        klijentskiZahtev.setOperacija(Operacija.OBRISI_CLANA);

        Komunikacija.getInstanca().posaljiKlijentskiZahtev(klijentskiZahtev);
        ServerskiOdgovor so = Komunikacija.getInstanca().primiServerskiOdgovor();

        JOptionPane.showMessageDialog(this, so.getPoruka());

        ClanoviForma clanoviForma = (ClanoviForma) this.getParent();
        if ((boolean) so.getOdgovor()) {
            clanoviForma.popuniTabeluClanova();
        }

        this.setVisible(false);
        clanoviForma.getBtnEvidentirajClanarinu().setEnabled(false);
        clanoviForma.getBtnIzmeniPodatkeOClanu().setEnabled(false);
        clanoviForma.getBtnObrisiClana().setEnabled(false);
        clanoviForma.getBtnEvidentirajClanarinu().setEnabled(false);
        this.dispose();

    }//GEN-LAST:event_btnPotvrdiActionPerformed

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
            java.util.logging.Logger.getLogger(PotvrdaOBrisanju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PotvrdaOBrisanju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PotvrdaOBrisanju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PotvrdaOBrisanju.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PotvrdaOBrisanju dialog = new PotvrdaOBrisanju(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnPotvrdi;
    private javax.swing.JLabel lblTekst;
    // End of variables declaration//GEN-END:variables
}