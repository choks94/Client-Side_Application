/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.IzmeniPodatkeOClanuForma;

/**
 *
 * @author STEFAN94
 */
public class NitOsluskujIzmenjenClan extends Thread {

    IzmeniPodatkeOClanuForma ipocf;

    public NitOsluskujIzmenjenClan(IzmeniPodatkeOClanuForma ipocf) {
        this.ipocf = ipocf;
    }

    @Override
    public void run() {

        while (true) {
            if (ipocf.getTxtDatumRodjenja().getText().trim().isEmpty() || ipocf.getTxtEmail().getText().trim().isEmpty() || ipocf.getTxtIme().getText().trim().isEmpty()
                    || ipocf.getTxtKontaktTelefon().getText().trim().isEmpty() || ipocf.getTxtPrezime().getText().trim().isEmpty() || ipocf.getTxtjmbg().getText().trim().isEmpty()) {
                ipocf.getBtnSacuvajIzmenu().setEnabled(false);
            } else {
                ipocf.getBtnSacuvajIzmenu().setEnabled(true);
            }
        }
    }

}
