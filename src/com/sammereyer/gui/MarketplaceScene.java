package com.sammereyer.gui;

import java.awt.Button;

import com.sammereyer.helper.DataTableModelOwnAlbum;
import com.sammereyer.helper.DataTableModelUsers;
import com.sammereyer.helper.MenuBarGenerator;
import com.sammereyer.helper.TableGeneratorOwnAlbum;
import com.sammereyer.helper.TableGeneratorUsers;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MarketplaceScene {

	public GridPane gridpane;
	public TableView<DataTableModelUsers> tableUsers;
	public TableView<DataTableModelOwnAlbum> tableOwnAlbum;
	public TableView<DataTableModelOwnAlbum> tableOtherUserAlbum;

	public MarketplaceScene(Stage stage) {
		gridpane = new GridPane();
		Text t = new Text();
		t.setText("Marketplace");
		t.setFont(new Font(20));
		gridpane.add(t, 1, 2);
		gridpane.setMinSize(500, 500);

		gridpane.setId("marketplace-scene");
		gridpane.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, null, null)));

		MenuBar menuBar = MenuBarGenerator.generateMenuBar(stage);

		gridpane.add(menuBar, 1, 1);

		HBox tableBoxFirstLine = new HBox();

		VBox tableBoxUsers = new VBox();
		Text userTableText = new Text();
		userTableText.setText("Users");
		tableUsers = TableGeneratorUsers.generateUserTable();
		tableBoxUsers.getChildren().addAll(userTableText, tableUsers);

		VBox tableboxSelectedUserCards = new VBox();
		Text selectedUserCardsText = new Text();
		selectedUserCardsText.setText("Selected User's Cards");
		tableOtherUserAlbum = TableGeneratorOwnAlbum.generateOwnAlbumTable();
		tableboxSelectedUserCards.getChildren().addAll(selectedUserCardsText, tableOtherUserAlbum);

		tableBoxFirstLine.getChildren().addAll(tableBoxUsers, tableboxSelectedUserCards);
		tableBoxUsers.setPadding(new Insets(20));
		tableboxSelectedUserCards.setPadding(new Insets(20));

		gridpane.add(tableBoxFirstLine, 1, 3);

		Separator separator = new Separator();

		gridpane.add(separator, 1, 4);

		HBox tableBoxSecondLine = new HBox();

		VBox tableboxOwnCards = new VBox();
		Text myCardsText = new Text();
		myCardsText.setText("My Cards");
		tableOwnAlbum = TableGeneratorOwnAlbum.generateOwnAlbumTable();
		tableboxOwnCards.getChildren().addAll(myCardsText, tableOwnAlbum);
		Button acceptDealButton = new Button();

		
		VBox proposeDealControls = new VBox();
		
		
		tableBoxSecondLine.getChildren().addAll(tableboxOwnCards);
		tableboxOwnCards.setPadding(new Insets(20));

		gridpane.add(tableBoxSecondLine, 1, 5);

	}

	public Scene getScene() {
		return new Scene(gridpane);
	}

}