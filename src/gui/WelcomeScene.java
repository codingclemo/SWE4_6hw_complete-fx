package gui;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WelcomeScene{
    
	public GridPane gridpane;
    public WelcomeScene(Stage stage) {
    	gridpane = new GridPane();
    	LoginDialog logindialog = new LoginDialog(stage);
        Text t = new Text();
        t.setText("Welcome to COMPLETE-FX");
        gridpane.add(t,1,1);
        gridpane.setMinSize(400, 100);
        
        HBox buttonBox = new HBox();
        buttonBox.setPadding(new Insets(5));
        
        Button loginButton = new Button("Login");
        loginButton.setId("login-button");
        loginButton.setPadding(new Insets(5));
        loginButton.setPrefSize(70, 20);
        buttonBox.getChildren().add(loginButton);
        loginButton.setOnAction(e-> logindialog.show());
        
        Button registerButton = new Button("Register");
        registerButton.setId("register-button");
        registerButton.setPadding(new Insets(5));
        registerButton.setPrefSize(70, 20);
        buttonBox.getChildren().add(registerButton);
        buttonBox.setSpacing(10);
        
        gridpane.add(buttonBox,1,2);
        
        gridpane.setId("welcome-pane");
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setBackground(new Background ( new BackgroundFill(Color.WHITESMOKE, null, null)));
    }
    
    public Scene getScene() {
        return new Scene(gridpane);
    }
    
    
}