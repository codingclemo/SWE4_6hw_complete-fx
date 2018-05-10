package com.sammereyer.gui;

import com.sammereyer.helper.MenuBarGenerator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AccountScene implements EventHandler<ActionEvent> {
    
	public GridPane gridpane;
	public Stage stage;
	public Text notification = new Text();
	
    public AccountScene(Stage stage)  {
    	gridpane = new GridPane();
        Text t = new Text();
        t.setFont(new Font(20));
        t.setText("Change your Account-Details");
        gridpane.add(t,1,2);
        gridpane.setMinSize(500, 500);
      
        gridpane.setId("account-scene");
        gridpane.setBackground(new Background ( new BackgroundFill(Color.WHITESMOKE, null, null)));
        
        MenuBar menuBar = MenuBarGenerator.generateMenuBar(stage);

        gridpane.add(menuBar,1,1);
        
        
        addLabelsAndTextFields(stage);

    }

	private void addLabelsAndTextFields(Stage stage) {
		
		this.stage = stage;
		TextField usernameTextField;
		PasswordField passwordTextField;
		TextField addressTextField;
		VBox registerDataPane;
		Button registerButton;
		Button cancelButton;
		
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
		registerButton = RegisterDialog.createTextButton("button-confirm", "Confirm");
		registerButton.setOnAction(this);

		cancelButton = RegisterDialog.createTextButton("button-cancel", "Cancel");
		cancelButton.setOnAction(this);

		HBox buttonBox = new HBox();
		buttonBox.setId("button-pane");
		buttonBox.getChildren().addAll(registerButton, cancelButton);
//		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setSpacing(10);
		buttonBox.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));

		registerDataPane = new VBox();
		registerDataPane.setId("register-pane");

		registerDataPane.getChildren().addAll(usernameInput, pwInput, addressInput, countryInput, regionInput,
				buttonBox);

		registerDataPane.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));
//		registerDataPane.setAlignment(Pos.CENTER);

		gridpane.add(registerDataPane,1,3);
		gridpane.add(notification,1,4);
		
	}

	public Scene getScene() {
        return new Scene(gridpane);
    }

	@Override
	public void handle(ActionEvent event) {
		try {
			if (((Button) event.getSource()).getId().equals("button-confirm")) {
				System.out.println("confirm button pressed");
				// taking care of logging in

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.initModality(Modality.WINDOW_MODAL);
				alert.setTitle("Register Status");
				alert.setHeaderText("Look, an Information Dialog");
				alert.setContentText("stuff is updated");
				alert.showAndWait().ifPresent(rs -> {
					if (rs == ButtonType.OK) {
						System.out.println("Pressed OK.");
						
//						notification.setText("Account Details updated!");
				        
						
					}
				});

			} else if (((Button) event.getSource()).getId().equals("button-cancel")) {
				System.out.println("cancel button pressed");
			}
		} catch (Exception e) {

		}
		
	}
    
    
}