/*
 * javafx application Paket, in dem sich um die Darstellung gekümmert wird
 */
package application;

import javafx.application.Platform;
import javafx.scene.control.*;
import prak5gemklassen.Benutzer;
import benutzerVerwaltung.*;
/*
 * Klasse die für die Logik unserer Anmeldung Scene verantwortlich ist.
 * @author xddq
 */
public class AnmeldungsController {
		
	//attribute of type MainApplication used for callback
	public MainApplication application;

	public TextField userID;
	public PasswordField passwordFirst;
	public PasswordField passwordSecond;
	
	/*
	 * Methode um die Referenz zur MainApplication zu setzen.
	 * param application: Referenz zur MainApplication
	 */
	void setMainApplication(MainApplication application) {
		this.application = application;
	}
	
	/*
	 * Methode um den Text des TextFelds zu setzen
	 * param caption: Text der Dargestellt werden soll
	 */
	void setCaptionOfTextfield(String caption) {
		userID.setText(caption);
	}
	
	
	/*
	 * method to create a user with our given input 
	 * and display it's string value
	 */
	public void buttonClicked() {
		//compare if both passwords match
		if(passwordFirst.getText().equals(passwordSecond.getText())) {
			//create userObj and print it and close scene
			Benutzer newUser = new Benutzer(userID.getText(),passwordFirst.getText().toCharArray());
			System.out.println(newUser.toString());
			application.neuerBenutzer(newUser);
		}
		else {
			userID.setText("Passwort != Wiederholung");
		}
	}
	
}
