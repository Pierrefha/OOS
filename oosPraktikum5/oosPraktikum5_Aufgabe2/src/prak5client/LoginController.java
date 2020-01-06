/*
 * javafx application Paket, in dem sich um die Darstellung gekümmert wird
 */
package prak5client;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import prak5gemklassen.Benutzer;
/*
 * Klasse die für die Logik unserer Login Scene verantwortlich ist.
 * @author xddq
 */
public class LoginController {
	
	//private var that will be toggled
	private boolean neuAnmeldung =false;
	private boolean remoteFlag=false;
	
	//attribute of type MainApplication used for callback
	public MainApplication application;
	
	public TextField userID;
	public PasswordField password;
	
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
	 * method to toggle remoteFlag value on click of our checkbox
	 */
	public void remoteCheckboxClicked(){
		remoteFlag= (!remoteFlag);
		System.out.println(remoteFlag);
	}
	
	/*
	 * method to toggle neuAnmeldung value on click of our checkbox
	 */
	public void checkboxClicked(ActionEvent event){
		neuAnmeldung= (!neuAnmeldung);
		System.out.println(neuAnmeldung);
		application.setRemoteFlag(this.remoteFlag);
		//hier muss neuAnmeldung aufgerufen werden
		neuAnmeldung(event);
	}
	
	/*
	 * diese Methode ruft die MainApplication auf und übergibt den aufzurufenden controller
	 */
	public void neuAnmeldung(ActionEvent event) {
		application.setRemoteFlag(this.remoteFlag);
		application.neuAnmeldung();
	}
	
	
	/*
	 * method to create a user with our given input 
	 * and display it's string value
	 */
	public void buttonClicked() {
		Benutzer newUser = new Benutzer(userID.getText(),password.getText().toCharArray());
		//system.out.println führt immer die toString Methode der Object Klasse aus.
		application.benutzerLogin(newUser);
	}
	
}
