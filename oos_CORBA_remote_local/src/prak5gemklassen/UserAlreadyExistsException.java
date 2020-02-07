/**
 * Paket zum dritten Praktikum in OOS.
 */
package prak5gemklassen;

/**
 * Exception die ausgelöst wird, wenn man versucht einen bereits bestehenden
 * Benutzer erneut im System zu registrieren.
 * @author xddq
 *
 */
public class UserAlreadyExistsException extends Exception {

	/*
	 * Konstruktor der Exception
	 * param ausgabe: Auszugebener String der Fehlermeldung.
	 */
	public UserAlreadyExistsException(String ausgabe) {
		super(ausgabe);
	}
	
	
}
