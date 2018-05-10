package gui;

import javafx.scene.text.Text;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RegisterDialog implements EventHandler<ActionEvent> {

	Stage registerStage = new Stage();

	public VBox registerDataPane;
	private Button registerButton;
	private Button cancelButton;

	private Button createTextButton(String id, String caption) {
		Button button = new Button(caption);
		button.setId(id);
		button.setPadding(new Insets(5));
		button.setPrefSize(100, 30);
		return button;
	}

	public Stage stage;

	TextField usernameTextField;
	PasswordField passwordTextField;
	TextField addressTextField;

	public RegisterDialog(Stage stage) {

		this.stage = stage;
		Text t = new Text();
		t.setText("Enter your Credentials and click on confirm");

		Label usernameLabel = new Label("Username");
		usernameLabel.setAlignment(Pos.CENTER_LEFT);
		usernameTextField = new TextField();
		usernameTextField.setPromptText("enter user name");
		VBox usernameInput = new VBox();
		usernameInput.getChildren().addAll(usernameLabel, usernameTextField);
		usernameInput.setPadding(new Insets(5, 0, 10, 0));
		usernameInput.setMaxWidth(200);

		Label passwordLabel = new Label("Password");
		passwordLabel.setAlignment(Pos.CENTER_LEFT);
		passwordTextField = new PasswordField();
		passwordTextField.setPromptText("enter password");
		VBox pwInput = new VBox();
		pwInput.getChildren().addAll(passwordLabel, passwordTextField);
		pwInput.setPadding(new Insets(5, 0, 10, 0));
		pwInput.setMaxWidth(200);

		Label addressLabel = new Label("Address");
		addressLabel.setAlignment(Pos.CENTER_LEFT);
		addressTextField = new TextField();
		addressTextField.setPromptText("enter adress");
		VBox addressInput = new VBox();
		addressInput.getChildren().addAll(addressLabel, addressTextField);
		addressInput.setPadding(new Insets(5, 0, 10, 0));
		addressInput.setMaxWidth(200);

		Label countryLabel = new Label("Country");
		countryLabel.setAlignment(Pos.CENTER_LEFT);
		ObservableList<String> countries = FXCollections.observableArrayList("Austria", "Germany", "Switzerland");
		final ComboBox<String> countryComboBox = new ComboBox<String>(countries);
		VBox countryInput = new VBox();
		countryInput.getChildren().addAll(countryLabel, countryComboBox);
		countryInput.setPadding(new Insets(5, 0, 10, 0));
		countryInput.setMaxWidth(200);

		Label regionLabel = new Label("Region");
		regionLabel.setAlignment(Pos.CENTER_LEFT);
		ObservableList<String> regions = FXCollections.observableArrayList("upperaustria", "loweraustria", "vienna");
		final ComboBox<String> regionComboBox = new ComboBox<String>(regions);
		VBox regionInput = new VBox();
		regionInput.getChildren().addAll(regionLabel, regionComboBox);
		regionInput.setPadding(new Insets(5, 0, 10, 0));
		regionInput.setMaxWidth(200);

		// add buttons
		registerButton = createTextButton("button-register", "Register");
		registerButton.setOnAction(this);

		cancelButton = createTextButton("button-cancel", "Cancel");
		cancelButton.setOnAction(this);

		HBox buttonBox = new HBox();
		buttonBox.setId("button-pane");
		buttonBox.getChildren().addAll(registerButton, cancelButton);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(10);
		buttonBox.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));

		registerDataPane = new VBox();
		registerDataPane.setId("register-pane");

		registerDataPane.getChildren().addAll(t, usernameInput, pwInput, addressInput, countryInput, regionInput,
				buttonBox);

		registerDataPane.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
		registerDataPane.setAlignment(Pos.CENTER);

		Scene refactorScene = new Scene(new VBox(registerDataPane));

		registerStage.setScene(refactorScene);
		registerStage.initModality(Modality.WINDOW_MODAL);
		// LoginStage.initOwner(stage);
		registerStage.setResizable(false);
	}

	public void show() {
		registerStage.setTitle("Login");
		registerStage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			if (((Button) event.getSource()).getId().equals("button-register")) {
				System.out.println("register button pressed");
				Scene loggedInScene = new LoggedInScene(stage).getScene();
				// taking care of logging in

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.initModality(Modality.WINDOW_MODAL);
				alert.setTitle("Register Status");
				alert.setHeaderText("Look, an Information Dialog");
				alert.setContentText("You are either loged in nor not -> backend");
				alert.showAndWait().ifPresent(rs -> {
					if (rs == ButtonType.OK) {
						System.out.println("Pressed OK.");
						stage.setScene(loggedInScene);
						registerStage.close();
					}
				});

			} else if (((Button) event.getSource()).getId().equals("button-cancel")) {
				registerStage.close();
			}
		} catch (Exception e) {

		}

	}
}