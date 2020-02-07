/**
 * Paket für die serverseitige Logik
 */
package prak5server;

import prak5gemklassen.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Klasse die für die Delegation der Requests zum Server verantwortlich ist.
 * @author xddq
 */
public class ServerOrb {
//ganze Verarbeitung im Konstruktor:
	ServerOrb() throws IOException {
//Erzeugung des Dienstanbieters, sonst häufig durch
//main-Programm in extra Klasse Server:
		BenutzerVerwaltungAdmin bvAdmin = new BenutzerVerwaltungAdmin();
//Anlegen eines ServerSockets:
		ServerSocket server = new ServerSocket(4711);
		System.out.println("server läuft auf localhost über port 4711");
//Warten auf Verbindungsaufnahme durch Client:
		while (true) {
			Socket client = server.accept();
//Verbindung annehmen und korresp. Streams erzeugen:
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());

//Lesen der Methodenkodierung:
			int methode = in.readInt();
//Lesen des Parameters:
			try {
				boolean reply;
				String result;
			//Methodenimplementierungen durch Delegation an
			//Dienstanbieterobjekt:
						//Wenn BenutzerOK aufgerufen wird
						if (methode == 1) {
							Benutzer user = (Benutzer) in.readObject();
							reply = bvAdmin.benutzerOK(user);
							//result value in stream packen
							out.writeObject(reply);
						}
						//Wenn BenutzerEintragen aufgerufen wird
						if (methode == 2) {
							try {
								Benutzer user = (Benutzer) in.readObject();
								bvAdmin.benutzerEintragen(user);
								result="Success!";
								out.writeObject(result);
							} catch (UserAlreadyExistsException e) {
								result="exists";
								out.writeObject(result);
								//e.printStackTrace();
							} catch (UnsafePasswordException e) {
								result="unsafe";
								out.writeObject(result);
								//e.printStackTrace();
							} catch (UsernameToShortException e) {
								result="short";
								out.writeObject(result);
								//e.printStackTrace();
							}
						}
			} catch (ClassNotFoundException e) {
				System.out.println(
						"couldn't cast to benutzerObj. Something went really wrong");
				e.printStackTrace();
			}

//Sicherstellen, dass Ergebnis transportiert wird:
			out.flush();
		}
	}
}
