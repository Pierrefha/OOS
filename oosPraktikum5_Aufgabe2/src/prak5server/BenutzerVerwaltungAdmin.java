/**
 * Paket zum dritten Praktikum in OOS.
 */
package prak5server;

import prak5gemklassen.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Diese Klasse implementiert die Schnittstelle Benutzerverwaltung 
 * und stellt den Administrator des Systems dar.
 * @author xddq
 */
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {

	
	//Attribute 
	/*
	 * Datenstruktur zur Implementierung der Datenhaltung.
	 * HashMap, da jede Benutzeridentifikationsnummer eindeutig und zu einem Benutzer gehörig.
	 */	
	//private um anderen Nutzern den Zugriff zu verweigern.
	//In P3 angepasst, jetzt nur noch Referenz auf eine Datenstruktur.
	private HashMap<String, Benutzer> alleBenutzer;
	
	
	/*
	 * Methode um eine HashMap zu erzeugen und sie zu serialisieren.
	 */
	public void dbInitialisieren() {
		try {
			alleBenutzer = new HashMap<String, Benutzer>();
			FileOutputStream fs = new FileOutputStream("users");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(alleBenutzer);
			os.close();
		} catch (FileNotFoundException e) {
			System.out.println("Datei wurde nicht gefunden!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ObjectOutputStream konnte nicht geöffnet werden!");
			e.printStackTrace();
		}
	}
	
	/*
	 * Methode um Benutzer in das System einzutragen.
	 * param benutzer: Benutzer der in das System eingetragen werden soll.
	 * throws UserAlreadyExcistsException falls Benutzer bereits existiert.
	 * throws UnsafePasswordException falls das Password unter 8 Zeichen lang ist.
	 * throws UsernameToShortException falls der Benutzername unter 5 Zeichen lang ist.
	 */
	@Override
	public void benutzerEintragen(Benutzer benutzer) throws UserAlreadyExistsException, UnsafePasswordException, UsernameToShortException {
		//deserialisieren der Datenstruktur
		try {
			FileInputStream fs = new FileInputStream("users");
			ObjectInputStream os = new ObjectInputStream(fs);
			alleBenutzer = (HashMap<String, Benutzer>) os.readObject();
			os.close();
		} catch (FileNotFoundException e) {
			System.out.println("Datei wurde nicht gefunden!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ObjectInputStream konnte nicht geöffnet werden!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Die Klasse HashMap<String, Benutzer> existiert nicht!");
			e.printStackTrace();
		}
		
		if (benutzer.userId==null || benutzer.userId.length() <= 5) {

			throw new UsernameToShortException("Benutzername muss mindestens 5 Zeichen lang sein!");
		}
		else if (benutzer.passWort == null || String.copyValueOf(benutzer.passWort).length() <=8){
			throw new UnsafePasswordException("Benutzerpasswort muss mindestens 8 Zeichen lang sein!");
		}
		if(alleBenutzer.containsKey(benutzer.userId)) {
			throw new UserAlreadyExistsException("Benutzer ist bereits im System registriert!");
		}
		else {
			alleBenutzer.put(benutzer.userId, benutzer);
			//serialisieren der Datenstruktur
			try {
				FileOutputStream fs = new FileOutputStream("users");
				ObjectOutputStream os = new ObjectOutputStream(fs);
				os.writeObject(alleBenutzer);
				os.close();
			} catch (FileNotFoundException e) {
				System.out.println("Datei wurde nicht gefunden!");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("ObjectOutputStream konnte nicht geöffnet werden!");
				e.printStackTrace();
			}
		}
		
	}

	
	/*
	 * Methode die überprüft, ob der Benutzer bereits registriert ist.
	 * param benutzer: Benutzerobjekt das überprüft wird.
	 * return false, wenn der Benutzer bereits existiert, sonst true.
	 */
	@Override
	public boolean benutzerOK(Benutzer benutzer) {
		//deserialisieren der Datenstruktur
		try {
			FileInputStream fs = new FileInputStream("users");
			ObjectInputStream os = new ObjectInputStream(fs);
			alleBenutzer = (HashMap<String, Benutzer>) os.readObject();
			os.close();
		} catch (FileNotFoundException e) {
			System.out.println("Datei wurde nicht gefunden!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ObjectInputStream konnte nicht geöffnet werden!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Die Klasse HashMap<String, Benutzer> existiert nicht!");
			e.printStackTrace();
		}
		//überprüfe ob Datenstruktur den Benutzer enthält
		boolean reply=true;
		if(alleBenutzer.containsKey(benutzer.userId)) {
			reply =false;
		}
		return reply;
	}
	
	
	/*
	 * Methode die einen bereits registrierten Benutzer löscht.
	 * param benutzer: Benutzerobjekt das gelöscht werden soll.
	 */
	public void benutzerLöschen(Benutzer benutzer) throws UserDoesntExistException {
		
		//deserialisieren der Datenstruktur
		try {
			FileInputStream fs = new FileInputStream("users");
			ObjectInputStream os = new ObjectInputStream(fs);
			alleBenutzer = (HashMap<String, Benutzer>) os.readObject();
			os.close();
		} catch (FileNotFoundException e) {
			System.out.println("Datei wurde nicht gefunden!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ObjectInputStream konnte nicht geöffnet werden!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Die Klasse HashMap<String, Benutzer> existiert nicht!");
			e.printStackTrace();
		}
		
		//check if user exists
		if(!alleBenutzer.containsKey(benutzer.userId)) {
			throw new UserDoesntExistException("Benutzer existiert nicht im System.");
		}
		
			
		//jetzt können wir sicher sein, dass der Benutzer existiert 
		alleBenutzer.remove(benutzer.userId);
	
			//serialisieren der Datenstruktur
			try {
				FileOutputStream fs = new FileOutputStream("users");
				ObjectOutputStream os = new ObjectOutputStream(fs);
				os.writeObject(alleBenutzer);
				os.close();
			} catch (FileNotFoundException e) {
				System.out.println("Datei wurde nicht gefunden!");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("ObjectOutputStream konnte nicht geöffnet werden!");
				e.printStackTrace();
			}
		}
}
