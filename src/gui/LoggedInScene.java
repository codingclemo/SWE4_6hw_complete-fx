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

public class LoggedInScene{
    
	public GridPane gridpane;
    public LoggedInScene() {
    	gridpane = new GridPane();
        Text t = new Text();
        t.setText("logged in");
        gridpane.add(t,1,1);
        gridpane.setMinSize(400, 100);
      
        gridpane.setId("welcome-pane");
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setBackground(new Background ( new BackgroundFill(Color.WHITESMOKE, null, null)));
    }
    
    public Scene getScene() {
        return new Scene(gridpane);
    }
    
    
}