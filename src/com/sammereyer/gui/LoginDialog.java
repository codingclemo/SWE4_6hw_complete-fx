package com.sammereyer.gui;

import javafx.scene.text.Text;

import com.sammereyer.helper.ButtonGenerator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.stage.StageStyle;

public class LoginDialog implements EventHandler<ActionEvent> {

	Stage LoginStage = new Stage();

	public VBox credentialsPane;
	private Button confirmButton;
	private Button cancelButton;

	public Stage stage;

	TextField usernameTextField;
	PasswordField passwordTextField;

	public LoginDialog(Stage stage) {

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

		// add buttons
		confirmButton = ButtonGenerator.createTextButton("button-confirm", "Confirm");
		confirmButton.setOnAction(this);

		cancelButton = ButtonGenerator.createTextButton("button-cancel", "Cancel");
		cancelButton.setOnAction(this);

		HBox buttonBox = new HBox();
		buttonBox.setId("button-pane");
		buttonBox.getChildren().addAll(confirmButton, cancelButton);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(10);
		buttonBox.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));

		credentialsPane = new VBox();
		credentialsPane.setId("credentials-pane");

		credentialsPane.getChildren().addAll(t, usernameInput, pwInput, buttonBox);
		
		credentialsPane.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
		credentialsPane.setAlignment(Pos.CENTER);

		Scene loginScene = new Scene(new VBox(credentialsPane));

		LoginStage.setScene(loginScene);
		LoginStage.initModality(Modality.WINDOW_MODAL);
		LoginStage.initStyle(StageStyle.UTILITY);
		//LoginStage.initOwner(stage);
		LoginStage.setResizable(false);
	}

	public void show() {
		LoginStage.setTitle("Login");
		LoginStage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			if (((Button) event.getSource()).getId().equals("button-confirm")) {
				System.out.println("confirm button pressed");
				Scene loggedInScene = new LoggedInScene(stage).getScene();
				stage.setScene(loggedInScene);
				LoginStage.close();
			} else if (((Button) event.getSource()).getId().equals("button-cancel")){
				LoginStage.close();
			}
		} catch (Exception e) {

		}

	}
}