/**
 * Paket für die clientseitige Logik
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak5client;
import prak5gemklassen.Benutzer;
import prak5gemklassen.UnsafePasswordException;
import prak5gemklassen.UserAlreadyExistsException;
import prak5gemklassen.UsernameToShortException;

/**
 * Klasse die sich mit dem Server verbindet 
 * und Methodenaufrufe an den ServerOrb weiterleitet.
 * @author xddq
 *
 */
public class Client implements BenutzerVerwaltung{
    
    
	/*
	 * Weiterleitung der benutzerEintragen Methode an den ClientOrb
	 * param user: Benutzer der eingetragen werden soll
	 */
    @Override
    public void benutzerEintragen(Benutzer user) throws UserAlreadyExistsException, UnsafePasswordException, UsernameToShortException {
        ClientOrb clientOrb = new ClientOrb();
        clientOrb.benutzerEintragen(user);
    }

  	/*
  	 * Weiterleitung der benutzerOK Methode an den ClientOrb
  	 * param user: Benutzer der geprüft werden soll
  	 */
    @Override
    public boolean benutzerOK(Benutzer user) {
        ClientOrb clientOrb = new ClientOrb();
        return clientOrb.benutzerOK(user);        
     }
    
}
