/**
 * Paket zum dritten Praktikum in OOS.
 */
package benutzerVerwaltung;

/**
 * Exception die Ausgelöst wird, wenn man versucht einen zu kurzen Benutzernamen zu verwenden.
 * @author xddq
 *
 */
public class UsernameToShortException extends Exception {

	/*
	 * Konstruktor der Exception
	 * param ausgabe: Auszugebener String der Fehlermeldung.
	 */
	public UsernameToShortException(String ausgabe) {
		super(ausgabe);
	}
}
