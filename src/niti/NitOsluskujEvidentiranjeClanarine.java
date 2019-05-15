/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.EvidentiranjeClanarine;

/**
 *
 * @author STEFAN94
 */
public class NitOsluskujEvidentiranjeClanarine extends Thread{
    
    EvidentiranjeClanarine ec;

    public NitOsluskujEvidentiranjeClanarine(EvidentiranjeClanarine ec) {
        this.ec = ec;
    }

    @Override
    public void run() {
    
        while(true){
            if((ec.getTxtCena().getText().trim().isEmpty()) || ((int)ec.getSpnBrojMeseci().getValue() < 1)){
                ec.getBtnEvidentiraj().setEnabled(false);
            }else{
                ec.getBtnEvidentiraj().setEnabled(true);
            }
            System.out.println();
        }
    }
    
    
}
