/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;


import forme.IzmeniPodatkeOKnjiziForma;

/**
 *
 * @author STEFAN94
 */
public class NitOsluskujIzmenjenaKnjiga extends Thread {

    forme.IzmeniPodatkeOKnjiziForma ipok;

    public NitOsluskujIzmenjenaKnjiga(IzmeniPodatkeOKnjiziForma ipok) {
        this.ipok = ipok;
    }

    @Override
    public void run() {

        while (true) {
            if (ipok.getTxtBrojStrana().getText().trim().isEmpty() || ipok.getTxtGodinaIzdanja().getText().trim().isEmpty()
                    || ipok.getTxtIsbn().getText().trim().isEmpty() || ipok.getTxtNaziv().getText().trim().isEmpty() || ipok.getTxtPisac().getText().trim().isEmpty()
                    || ipok.getTxtPismo().getText().trim().isEmpty() || ipok.getTxtPovez().getText().trim().isEmpty() || (int) ipok.getSpnBrojPrimeraka().getValue() < 0) {

                ipok.getBtnIzmeni().setEnabled(false);
            } else {
                ipok.getBtnIzmeni().setEnabled(true);
            }

            System.out.println();
        }
    }

}
