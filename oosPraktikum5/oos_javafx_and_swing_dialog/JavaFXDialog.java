import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class JavaFXDialog extends Application {
  private Stage primaryStage;
  private GridPane gridPane;

  private Label titleLabel = new Label("Mein qweqewq Frame");
  private Label nameLabel = new Label("Name");
  private TextField nameTextField = new TextField("hier sensible daten xD");
  private Label passwordLabel = new Label("Passwort");
  private PasswordField passwordField = new PasswordField();
  private CheckBox checkBox = new CheckBox("CheckBox");
  private Button runButton = new Button("Ausführen");

  @Override
  public void start(Stage primaryStage) throws Exception {
    this.primaryStage = primaryStage;
    gridPane = new GridPane();

    setupStageContents();
    addStageContentsToStage();
    setupScene();
  }

  // Erstellen & Konfigurieren der Szene
  private void setupScene() {
    gridPane.setHgap(10.0);
    gridPane.setVgap(10.0);
    gridPane.setPadding(new Insets(10, 10, 10, 10));

    primaryStage.setTitle("AnmeldungFrame");
    primaryStage.setScene(new Scene(gridPane, 350, 220));
    primaryStage.show();
  }

  // Erstellen des Inhalts der Stage
  private void setupStageContents() {
    Color labelColor = Color.rgb(102, 102, 153);

    titleLabel.setFont(new Font("Serif", 20));
    titleLabel.setTextFill(labelColor);

    nameLabel.setTextFill(labelColor);

    nameTextField.setDisable(true);
    nameTextField.setEditable(false);

    checkBox.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        boolean selected = checkBox.isSelected();

        nameTextField.setDisable(!selected);
        nameTextField.setEditable(selected);
        System.out.println(checkBox.isSelected());
      }
    });

    passwordLabel.setTextFill(labelColor);

    runButton.setOnAction(new RunButtonHandler());
  }

  // Hinzufügen der Inhalte der Stage
  private void addStageContentsToStage() {
    gridPane.add(titleLabel, 1, 0);
    gridPane.add(nameLabel, 0, 2);
    gridPane.add(nameTextField, 1, 2, 3, 1);
    gridPane.add(passwordLabel, 0, 3);
    gridPane.add(passwordField, 1, 3, 3, 1);
    gridPane.add(checkBox, 1, 5);
    gridPane.add(runButton, 3, 7);
  }

  public static void main(String[] args) {
    launch(args);
  }

  class RunButtonHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
      String name = nameTextField.getText();
      String password = passwordField.getText();

      System.out.println(name.equals(password));
    }
  }
}
