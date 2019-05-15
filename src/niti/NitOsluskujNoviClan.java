/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.DodajNovogClanaForma;

/**
 *
 * @author STEFAN94
 */
public class NitOsluskujNoviClan extends Thread {

    DodajNovogClanaForma dncf;

    public NitOsluskujNoviClan(DodajNovogClanaForma dncf) {
        this.dncf = dncf;
    }

    @Override
    public void run() {

        while (true) {
            if (dncf.getTxtDatumRodjenja().getText().trim().isEmpty() || dncf.getTxtEmail().getText().trim().isEmpty() || dncf.getTxtIme().getText().trim().isEmpty()
                    || dncf.getTxtKontaktTelefon().getText().trim().isEmpty() || dncf.getTxtPrezime().getText().trim().isEmpty() || dncf.getTxtjmbg().getText().trim().isEmpty()) {
                dncf.getBtnSacuvaj().setEnabled(false);

            } else {
                dncf.getBtnSacuvaj().setEnabled(true);

            }
            System.out.println();

        }
    }

}
