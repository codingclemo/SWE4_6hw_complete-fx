package com.sammereyer.gui;

import com.sammereyer.helper.ButtonGenerator;
import com.sammereyer.helper.DataTableModelOwnAlbum;
import com.sammereyer.helper.DataTableModelUsers;
import com.sammereyer.helper.MenuBarGenerator;
import com.sammereyer.helper.TableGeneratorOwnAlbum;
import com.sammereyer.helper.TableGeneratorUsers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView.TableViewSelectionModel;
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
	Text selectedUserText;
	Text selectedCardText;

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

		addMarketplaceFirstLine();

		addSeperator();

		addMarketplaceSecondLine();

		addListenersforTable();
	}

	private void addMarketplaceFirstLine() {
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
	}

	private void addSeperator() {
		Separator separator = new Separator();

		gridpane.add(separator, 1, 4);
	}

	private void addMarketplaceSecondLine() {
		HBox tableBoxSecondLine = new HBox();

		VBox tableboxOwnCards = new VBox();
		Text myCardsText = new Text();
		myCardsText.setText("My Cards");
		tableOwnAlbum = TableGeneratorOwnAlbum.generateOwnAlbumTable();
		Button acceptDealButton = ButtonGenerator.createTextButton("button-acceptDeal", "Accept Deal");
		Text acceptDealDescriptionText = new Text();
		acceptDealDescriptionText.setText("Click on a Row in your own cards and klick on 'Accept Deal' afterwards");
		tableboxOwnCards.getChildren().addAll(myCardsText, tableOwnAlbum, acceptDealDescriptionText, acceptDealButton);

		VBox proposeDealControls = new VBox();
		HBox selectedUserBox = new HBox();
		HBox selectedCardBox = new HBox();
		HBox makeOfferBox = new HBox();
		Text makeOfferDescriptionText = new Text();
		Text selectedUserDescriptionText = new Text();
		Text selectedCardDescriptionText = new Text();
		Text makeOfferButtonDescriptionText = new Text();
		TextField usernameTextField = new TextField();
		selectedUserText = new Text();
		selectedCardText = new Text();
		makeOfferDescriptionText.setText(
				"Select a user and afterwards select one of it cards.\nAfterwards add a value in the textbox and click on 'Make offer'");

		
		selectedCardDescriptionText.setText("Selected Card: ");
		selectedCardBox.getChildren().addAll(selectedCardDescriptionText, selectedCardText);
		
		selectedUserDescriptionText.setText("Selected User: ");
		selectedUserBox.getChildren().addAll(selectedUserDescriptionText, selectedUserText);
		
		makeOfferButtonDescriptionText.setText("Enter a value: ");
		usernameTextField.setPromptText("100");
		makeOfferBox.getChildren().addAll(makeOfferButtonDescriptionText,usernameTextField);

		Button makeOfferButton = ButtonGenerator.createTextButton("button-makeOffer", "Make Offer");

		proposeDealControls.getChildren().addAll(makeOfferDescriptionText, selectedUserBox, selectedCardBox,makeOfferBox,
				makeOfferButton);

		tableBoxSecondLine.getChildren().addAll(tableboxOwnCards, proposeDealControls);
		proposeDealControls.setPadding(new Insets(20));
		tableboxOwnCards.setPadding(new Insets(20));
		selectedUserBox.setPadding(new Insets(20));
		selectedCardBox.setPadding(new Insets(20));
		makeOfferBox.setPadding(new Insets(20));

		gridpane.add(tableBoxSecondLine, 1, 5);
	}

	private void addListenersforTable() {
		// source https://stackoverflow.com/questions/17388866/getting-selected-item-from-a-javafx-tableview
		tableUsers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observableValue, Object oldValue, Object newValue) {
				if (tableUsers.getSelectionModel().getSelectedItem() != null) {
					TableViewSelectionModel<DataTableModelUsers> selection = tableUsers.getSelectionModel();
					
					DataTableModelUsers derp = (DataTableModelUsers) selection.getSelectedItem();
					selectedUserText.setText(derp.getUsername());
					
					// TODO: add stuff for the other table
				}
			}
		});
		
		tableOtherUserAlbum.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<?> observableValue, Object oldValue, Object newValue) {
				if (tableOtherUserAlbum.getSelectionModel().getSelectedItem() != null) {
					TableViewSelectionModel<DataTableModelOwnAlbum> selection = tableOtherUserAlbum.getSelectionModel();
					
					DataTableModelOwnAlbum derp = (DataTableModelOwnAlbum) selection.getSelectedItem();
					selectedCardText.setText(derp.getId() + " " + derp.getName() + " " + derp.getTeam());
					
					// TODO: add stuff for the other table
				}
			}
		});
	}

	public Scene getScene() {
		return new Scene(gridpane);
	}

}