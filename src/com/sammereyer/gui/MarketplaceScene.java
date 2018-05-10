package com.sammereyer.gui;

import com.sammereyer.helper.MenuBarGenerator;

import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MarketplaceScene{
    
	public GridPane gridpane;
    public MarketplaceScene(Stage stage) {
    	gridpane = new GridPane();
        Text t = new Text();
        t.setText("Marketplace");
        t.setFont(new Font(20));
        gridpane.add(t,1,2);
        gridpane.setMinSize(500, 500);
      
        gridpane.setId("marketplace-scene");
        gridpane.setBackground(new Background ( new BackgroundFill(Color.WHITESMOKE, null, null)));
        
        MenuBar menuBar = MenuBarGenerator.generateMenuBar(stage);

		gridpane.add(menuBar,1,1);
        
    }

	public Scene getScene() {
        return new Scene(gridpane);
    }
    
    
}