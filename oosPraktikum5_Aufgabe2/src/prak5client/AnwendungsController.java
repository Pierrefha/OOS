/*
 * javafx application Paket, in dem sich um die Darstellung gekümmert wird
 */
package prak5client;

import javafx.application.Platform;
import javafx.scene.control.Button;

/*
 * Klasse die für die Logik unserer Anwendung Scene verantwortlich ist.
 * @author xddq
 */
public class AnwendungsController {
	
	//name button after given id with fx:id
	public Button abbrechenButton;
	
	/*
	 * Methode die Ausgeführt wird wenn wir auf unseren Button klicken.
	 * Schließt das Fenster und schrebt etwas in die Konsole.
	 */
	public void buttonClicked() {
		System.out.println("Abbrechen Button wurde betätigt.");
		//schließt Frame
    Platform.exit();
	}
	
}
