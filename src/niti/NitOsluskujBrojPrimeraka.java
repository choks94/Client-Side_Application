/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.ClanoviZaZaduzenje;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author STEFAN94
 */
public class NitOsluskujBrojPrimeraka extends Thread {
    
    ClanoviZaZaduzenje czz;

    public NitOsluskujBrojPrimeraka(ClanoviZaZaduzenje czz) {
        this.czz = czz;
    }

    @Override
    public void run() {
        int brojPrimeraka = czz.getBrojPrimeraka();
        while(true){
            if(brojPrimeraka > 0){
                czz.getBtnZaduzi().setEnabled(true);
            }else{
                czz.getBtnZaduzi().setEnabled(false);
            }
            System.out.println("Broj primeraka: "+brojPrimeraka);
            
        }
    }
    
    
}
