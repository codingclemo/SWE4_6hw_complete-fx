package com.sammereyer.gui;

import com.sammereyer.helper.TableGeneratorOwnAlbum;
import com.sammereyer.helper.DataTableModelOwnAlbum;
import com.sammereyer.helper.MenuBarGenerator;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlbumScene{
    
	public GridPane gridpane;
	public TableView<DataTableModelOwnAlbum> table;
    public AlbumScene(Stage stage) {
    	gridpane = new GridPane();
        Text t = new Text();
        t.setText("My Album");
        t.setFont(new Font(20));
        gridpane.add(t,1,2);
        gridpane.setMinSize(500, 500);
        
        gridpane.setId("album-scene");
        gridpane.setBackground(new Background ( new BackgroundFill(Color.WHITESMOKE, null, null)));
        
        MenuBar menuBar = MenuBarGenerator.generateMenuBar(stage);
		
        gridpane.add(menuBar,1,1);
		
		VBox tablebox = new VBox();
		table = TableGeneratorOwnAlbum.generateOwnAlbumTable();
		tablebox.getChildren().add(table);
		tablebox.setPadding(new Insets(20));
				
        gridpane.add(tablebox, 1, 3);
                
    }

	public Scene getScene() {
        return new Scene(gridpane);
    }
    
    
}