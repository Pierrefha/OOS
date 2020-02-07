/**
 * Paket für die serverseitige Logik
 */
package prak5server;

import java.io.IOException;

/*
 * Klasse die für den Start des Servers zuständig ist.
 * @author xddq
 */
public class Server {

	/*
	 * Create Orb for Server in constructor
	 */
   public Server() throws IOException {
        ServerOrb servOrb = new ServerOrb();
    }
    
    public static void main(String[] args){
         try {
             Server launch = new Server();
             
         } catch (IOException ex) {
             System.err.println("Fehler beim Starten des Servers");
         }
    }
    
}
