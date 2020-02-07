
/*
 * import javafx packages
 */
//somehow wildcard * is not workign with javafx?!
import javafx.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/*
 * Unterschied zu Swing: Bei Swing haben wir keine Stage?!
 */
/*
 * dialog class has to extend application to be implemented as applet
 */
public class JavaFXDialogWithListener extends Application {
	// create references for our stage and layout
	Stage primaryStage;

	GridPane gridPane;

	// create references for the objects we will use in our stage
	Label caption;

	TextField inputName;

	PasswordField inputPass;

	CheckBox cb;

	Button loginButton;

	/*
	 * this method will be executed by the launch command. here we create a stage,
	 * create our objects for the stage put them onto the layout and set up the
	 * scene with our layout
	 */
	@Override
	public void start(Stage arg0) throws Exception {
		this.primaryStage = new Stage();
		gridPane = new GridPane();
		createObjectsForStage();
		prepareLayout();
		setUpScene();
	}

	/*
	 * in this method we create our objects and set the references accordingly
	 */
	public void createObjectsForStage() {
		this.caption = new Label("I'm a great caption for this scene");
		this.inputName = new TextField(); // can also keep
																															// this empty.
		this.inputPass = new PasswordField();
		this.cb = new CheckBox();
		this.loginButton = new Button("login");
		// add eventhandler using anonymous class that extends
		// EventHandler<ActionEvent>
		// we ALWAYS need to overwrite the handle method.
		// which will be called when we click something
		this.cb.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println(cb.isSelected());
			}
		});
		
		//same for the loginButton
		this.loginButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (inputName.getText().equals("Admin")) {
					System.out.println("erfolgreich eingeloggt!");
				} else {
					System.out.println("name oder pw falsch..");
				}
			}
		});

	}

	/*
	 * now we put the objects onto our layout method header add(obj,X,Y)
	 */
	public void prepareLayout() {
		this.gridPane.add(caption, 0, 0);
		this.gridPane.add(inputName, 1, 1);
		this.gridPane.add(inputPass, 1, 2);
		this.gridPane.add(cb, 0, 3);
		this.gridPane.add(loginButton, 1, 3);
	}

	/*
	 * now we give our stage a title, add the scene and display it
	 */
	public void setUpScene() {
		this.primaryStage.setTitle("Ich bin ein toller Fenstername");
		this.primaryStage.setScene(new Scene(this.gridPane, 400, 600));
		this.primaryStage.show();
	}

	// create main here to startup the dialog
	public static void main(String args[]) {
		launch(args);
	}

}
