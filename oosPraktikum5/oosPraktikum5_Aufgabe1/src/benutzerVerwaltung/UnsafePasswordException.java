/**
 * Paket zum dritten Praktikum in OOS.
 */
package benutzerVerwaltung;

/**
 * Exception die ausgelöst wird, wenn das Password unter 8 Zeichen lang ist.
 * @author xddq
 *
 */
public class UnsafePasswordException extends Exception {

	/*
	 * Konstruktor der Exception
	 * param ausgabe: Auszugebener String der Exception
	 */
	public UnsafePasswordException(String ausgabe) {
		super(ausgabe);
	}
}
