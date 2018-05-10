package com.sammereyer.helper;

import gui.AccountScene;
import gui.AlbumScene;
import gui.MarketplaceScene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class MenuBarGenerator {

	public static MenuBar generateMenuBar(Stage stage) {
		Menu completeMenuAccount = new Menu();
		Label menuLabelAccount = new Label("Account");
		menuLabelAccount.setOnMouseClicked(e -> stage.setScene(new AccountScene(stage).getScene()));
		completeMenuAccount.setGraphic(menuLabelAccount);

		Menu completeMenuAlbum = new Menu();
		Label menuLabelAlbum = new Label("Album");
		menuLabelAlbum.setOnMouseClicked(e -> stage.setScene(new AlbumScene(stage).getScene()));
		completeMenuAlbum.setGraphic(menuLabelAlbum);

		Menu completeMenuMarketplace = new Menu();
		Label menuLabelMarketplace = new Label("Marketplace");
		menuLabelMarketplace.setOnMouseClicked(e -> stage.setScene(new MarketplaceScene(stage).getScene()));
		completeMenuMarketplace.setGraphic(menuLabelMarketplace);

		MenuBar menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(stage.widthProperty());
		menuBar.getMenus().addAll(completeMenuAccount, completeMenuAlbum, completeMenuMarketplace);
		return menuBar;

	}
}
