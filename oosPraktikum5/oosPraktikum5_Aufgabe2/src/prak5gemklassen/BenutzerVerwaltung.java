/**
 * Paket zum dritten Praktikum in OOS.
 */
package prak5gemklassen;

/**
 * Interface das Schnittstelle zur Benutzerverwaltung zur Verfügung stellt.
 * @author xddq
 *
 */
public interface BenutzerVerwaltung {

	/*
	 * Methode um einen Benutzer im System einzutragen.
	 * @param benutzer: Objekt eines Benutzers, der im System eingetragen werden soll.
	 */
	public void benutzerEintragen(Benutzer benutzer) throws UserAlreadyExistsException,UnsafePasswordException,UsernameToShortException;
	
	/*
	 * Methode um zu überprüfen, ob Benutzer im System bereits existiert.
	 * @param benutzer: Objekt eines Benutzers, der überprüft werden soll.
	 * @return true wenn der Benutzer existiert, sonst false.
	 */
	public boolean benutzerOK(Benutzer benutzer);

}
