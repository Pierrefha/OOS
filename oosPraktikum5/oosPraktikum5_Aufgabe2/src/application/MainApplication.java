/*
 * javafx application Paket, in dem sich um die Darstellung gekümmert wird
 */
package application;

import javafx.application.Application;
import javafx.stage.Stage;
import prak5gemklassen.Benutzer;
import prak5gemklassen.BenutzerVerwaltungAdmin;
import prak5gemklassen.UnsafePasswordException;
import prak5gemklassen.UserAlreadyExistsException;
import prak5gemklassen.UsernameToShortException;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import benutzerVerwaltung.*;

/*
 * Klasse die das Zusammenspiel der Objekte steuert
 * @author xddq
 */
public class MainApplication extends Application {
	
	
	/*
	 * Attribute, welche in start initialisiert werden, um auch von Außerhalb
	 *  der start methode darauf zugreifen zu können
	 */
	private Stage stage;
	private BenutzerVerwaltungAdmin bva;
	private String anmeldungErrorCaption, loginErrorCaption;
	
	/*
	 * Methode die durch launch aufgerufen wird. 
	 * Hier wird sich um die korrekte Instanziierung und Verwaltung der Fenster gekümmert.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			this.stage = primaryStage;
			//erstelle bva objekt
			BenutzerVerwaltungAdmin bvaObj = new BenutzerVerwaltungAdmin();
			this.bva = bvaObj;
			//abfrage, ob Datenhaltung initialisiert werden soll
			System.out.println("Wollen sie die Datenhaltung initialisieren?");
			System.out.println("0 für Ja, beliebiger anderer Wert für Nein.");
			BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
			int dbInitialisieren = Integer.parseInt(din.readLine());
			if(dbInitialisieren==0) {
				bvaObj.dbInitialisieren();
				System.out.println("Datenhaltung wurde initialisiert.");
			}
			else {
				System.out.println("Datenhaltung wurde nicht initialisiert.");
			}
			//rufe login scene auf
			loginScene();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Methode um die Login Scene aufzurufen
	 */
	public void loginScene() {
		//login scene erstellen mit Referenz auf dazugehörige fxml
		try {
		//set reference to application in LoginController
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Login.fxml"));
		GridPane root = (GridPane) loader.load();
		
		//those 3 lines are the same as, but now we can pass data to the controller
		//GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("Login.fxml"));
		
		Scene scene = new Scene(root,600,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//access controller and pass reference to MainApplication
		LoginController loginController = loader.getController();
		loginController.setMainApplication(this);
		loginController.setCaptionOfTextfield(this.loginErrorCaption);
		this.stage.setScene(scene);
		this.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Methode um die Anmeldung Scene aufzurufen
	 */
	public void anmeldungScene() {
		//anmeldung scene erstellen mit Referenz auf dazugehörige fxml
		try {
		//set reference to application in AnmeldungController
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Anmeldung.fxml"));
		GridPane root = (GridPane) loader.load();
		
		//those 3 lines are the same as, but now we can pass data to the controller
		//GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("Anmeldung.fxml"));
		
		Scene scene = new Scene(root,600,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//access controller and pass reference to MainApplication
		AnmeldungsController anmeldungController = loader.getController();
		anmeldungController.setMainApplication(this);
		anmeldungController.setCaptionOfTextfield(this.anmeldungErrorCaption);
		
		this.stage.setScene(scene);
		this.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	/*
	 * Methode um die Anwendung Scene aufzurufen
	 */
	public void anwendungScene() {
		//anwendung scene erstellen mit Referenz auf dazugehörige fxml
		try {
		//set reference to application in AnwendungsController
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Anwendung.fxml"));
		GridPane root = (GridPane) loader.load();
		
		//those 3 lines are the same as, but now we can pass data to the controller
		//GridPane root = (GridPane)FXMLLoader.load(getClass().getResource("Anwendung.fxml"));
		
		Scene scene = new Scene(root,600,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//access controller and pass reference to MainApplication
		AnwendungsController anwendungsController = loader.getController();
		
		this.stage.setScene(scene);
		this.stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * Methode die die Scene durch eine AnmeldungsScene ersetzt
	 * und den entsprechenden Controller aufruft
	 */
	public void neuAnmeldung() {
		this.anmeldungErrorCaption="";
		this.loginErrorCaption="";
		anmeldungScene();
	}
	
	/*
	 * Methode die versucht den übergebenen Benutzer in die BenutzerVerwaltung einzutragen.
	 * param benutzer: Benutzer der in die Benutzerverwaltung eingetragen werden soll
	 */
	public void neuerBenutzer(Benutzer benutzer) {
			try {
				bva.benutzerEintragen(benutzer);
				//wenn Erfolgreich, dann gehe zu Login Scene
				loginScene();
			} catch (UserAlreadyExistsException e) {
				this.anmeldungErrorCaption = "Benutzer existiert bereits!";
				anmeldungScene();
			} catch (UnsafePasswordException e) {
				this.anmeldungErrorCaption = "Unsafe Password! Mindestens 8 Zeichen lang!";
				anmeldungScene();
			} catch (UsernameToShortException e) {
				this.anmeldungErrorCaption = "Benutzername zu kurz! Mindestens 5 Zeichen lang!";
				anmeldungScene();
			}
		}
	
	/*
	 * Methode die versucht den Benutzer in das System einzuloggen.
	 * param benutzer: Benutzer der eingeloggt werden soll.
	 */
	void benutzerLogin(Benutzer benutzer) {
		//durch benutzerOK überprüfen, ob man Benutzer registrieren darf
		//vllt logik drehen!
		if(!bva.benutzerOK(benutzer)) {
			anwendungScene();
		}
		else {
			this.loginErrorCaption="Benutzer existiert nicht!";
			loginScene();
		}
	}

	
	/*
	 * main Methode die sich durch Aufruf von
	 *  launch um die Initialisierung der Stage kümmert.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
