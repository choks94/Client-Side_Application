/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.UnesiNovuKnjiguForma;

/**
 *
 * @author STEFAN94
 */
public class NitOsluskujNovaKnjiga extends Thread {

    UnesiNovuKnjiguForma unkf;

    public NitOsluskujNovaKnjiga(UnesiNovuKnjiguForma unkf) {
        this.unkf = unkf;
    }

    @Override
    public void run() {

        while (true) {
            if ( unkf.getTxtBrojStrana().getText().trim().isEmpty()
                    || unkf.getTxtGodinaIzdanja().getText().trim().isEmpty() || unkf.getTxtIsbn().getText().trim().isEmpty()
                    || unkf.getTxtNaziv().getText().trim().isEmpty() || unkf.getTxtPisac().getText().trim().isEmpty() || unkf.getTxtPismo().getText().trim().isEmpty()
                    || unkf.getTxtPovez().getText().trim().isEmpty() || (int)unkf.getSpnBrojPrimeraka().getValue() <= 0) {
                unkf.getBtnUnesi().setEnabled(false);
            } else {
                unkf.getBtnUnesi().setEnabled(true);
            }

            System.out.println();

        }
    }

}
