/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author STEFAN94
 */
public class Komunikacija {

    

    public static Komunikacija getInstanca() {
        if (instanca == null) {
            instanca = new Komunikacija();
        }
        return instanca;
    }

    Socket socket;

    private Komunikacija() {
        
    }

    private static Komunikacija instanca;

    public void poveziSE(String localhost, int port) throws IOException {
//        try {
//            socket = new Socket(localhost, port);
//        } catch (IOException ex) {
//            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(new PovezivanjeForma(), "Neuspesno povezivanje");
//        }
        
        socket = new Socket(localhost, port);

    }

    public void posaljiKlijentskiZahtev(KlijentskiZahtev klijentskiZahtev) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(klijentskiZahtev);
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ServerskiOdgovor primiServerskiOdgovor() {
        ServerskiOdgovor serverskiOdgovor = new ServerskiOdgovor();

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            serverskiOdgovor = (ServerskiOdgovor) objectInputStream.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serverskiOdgovor;
    }

}
