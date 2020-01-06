/**
 * Paket für die clientseitige Logik
 */
package prak5client;

import prak5gemklassen.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Klasse die sich mit dem Server verbindet 
 * und Methodenaufrufe an den ServerOrb weiterleitet.
 * @author xddq
 *
 */
public class ClientOrb {

	public Socket socket;
	public ObjectOutputStream os;
	public ObjectInputStream is;

	/*
	 * Konstruktor baut Verbindung zum Server auf
	 */
	public ClientOrb() {
		try {
			System.out.println("Client: Verbindungsaufbau auf Port 4711 zu Host address!");
			socket = new Socket("localhost", 4711);
			System.out.println("Verbindung hergestellt!");

			os = new ObjectOutputStream(socket.getOutputStream());
			is = new ObjectInputStream(socket.getInputStream());
			System.out.println("Streams initialisiert!");

		} catch (IOException e) {
			System.err.println(e.toString());
			// System.exit(1);
		}
	}
	
	/*
	 * Methoden die zum remote Server müssen
	 */
	
	/*
	 * Prüft ob der Benutzer bereits registriert ist.
	 * Falls ja -> false, nein -> true
	 * param: Benutzer der überprüft werden soll.
	 */
	public boolean benutzerOK(Benutzer benutzer) {
		//Umweg um einfach Streams zu verwenden:
		Object ergebnis;
		boolean result=false;

		// Eingabezeile an Server schicken
		try {
			//1 wird für BenutzerOK benutzt
			os.writeInt(1);
			os.writeObject(benutzer);
			os.flush();
			ergebnis = is.readObject();
			result = (boolean) ergebnis;
		} catch (IOException e) {
			System.err.println(e.toString());
			System.exit(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}

		System.out.println("BenutzerOK abgeschickt und antwort empfangen!");
		return result;
	}



/*
 * Prüft ob der Benutzer bereits registriert ist.
 * Falls ja -> false, nein -> true
 * param: Benutzer der überprüft werden soll.
 */
public void benutzerEintragen(Benutzer benutzer) throws UserAlreadyExistsException, UnsafePasswordException, UsernameToShortException {
	//Umweg um einfach Streams zu verwenden:
	Object ergebnis;

	// Eingabezeile an Server schicken
	try {
		//2 wird für benutzerEintragen benutzt
		os.writeInt(2);
		os.writeObject(benutzer);
		os.flush();
		ergebnis = is.readObject();
		ergebnis = (String)ergebnis;
		
		//check if exception got thrown (we pass strings because we have multiple exceptions)
		if(ergebnis.equals("exists")) {
			throw new UserAlreadyExistsException("Benutzer existiert bereits!");
		}
			else if (ergebnis.equals("unsafe")) {
				throw new UnsafePasswordException("Passwort zu kurz! Mindestens 8 Zeichen!");
			}
			else if (ergebnis.equals("short")) {
				throw new UsernameToShortException("Benutzername zu kurz! Mindestens 6 Zeichen!");
	}
	}
		catch (IOException e) {
		System.err.println(e.toString());
		System.exit(1);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		System.exit(1);
	}

	System.out.println("BenutzerOK abgeschickt und Antwort empfangen!");
}
}
