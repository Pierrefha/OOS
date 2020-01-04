/**
 * Paket zum zweiten Praktikum in OOS.
 */
package benutzerVerwaltung;

import java.io.Serializable;

/**
 * Klasse zur Darstellung eines Benutzers. Hier werden Logindaten gespeichert.
 * @author xddq
 */
public class Benutzer implements Serializable{
	
	//Attribute
	
	/*
	 * User Identifikationsnummer eines Benutzers
	 */
	String userId;
	
	/*
	 * Passwort eines Benutzers.
	 */
	char[] passWort;
	
	//Konstruktoren
	
	/*
	 * Default-Konstruktor:
	 */
	public Benutzer(){
	}
	
	/*
	 * Konstruktor der Benutzer mit übergebenen Werten initialisiert.
	 * @param userId: User Identifikationsnummer eines Benutzers.
	 * @param passWort: Passwort eines Benutzers.
	 */
	public Benutzer(String userId, char[] passWort){
		this.userId=userId;
		this.passWort=passWort;
	}
	
	
	/*
	 * Equals als Überlagerung der Methode der Object Klasse.
	 * @param obj: Object das mit dem Benutzer verglichen wird.
	 * @return true wenn die Objekte gleich sind, sonst false.
	 */
	public boolean equals(Object obj) {
		return ((obj != null) 
				&& (obj instanceof Benutzer)
				&& (this.userId.equals(((Benutzer) obj).userId))
				&& (String.copyValueOf(this.passWort).equals(String.copyValueOf(((Benutzer) obj).passWort))));
	}
	
	/*
	 * Standartmethode toString als Überlagerung.
	 * @return Darstellung des Benutzerobjekts als lesbaren String.
	 */
	public String toString() {
		return "Der Benutzer:"+userId+" hat das Passwort:"+String.copyValueOf(this.passWort);
	}
	
}
