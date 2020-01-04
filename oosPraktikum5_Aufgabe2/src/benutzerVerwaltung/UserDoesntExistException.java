/**
 * Paket zum dritten Praktikum in OOS.
 */
package benutzerVerwaltung;

/**
 * @author xddq
 * Diese Ausnahme wird geworfen, wenn ein Benutzer gelöscht werden soll, der nicht im System existiert.
 */
public class UserDoesntExistException extends Exception {

	/*
	 * Konstruktor der Exception
	 * param ausgabe: Auszugebener String der Fehlermeldung.
	 */
	public UserDoesntExistException(String ausgabe) {
		super(ausgabe);
	}
}
