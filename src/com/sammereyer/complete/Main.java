package com.sammereyer.complete;

import gui.WelcomeScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene welcomeScene = new WelcomeScene(primaryStage).getScene();
		
		primaryStage.setScene(welcomeScene);
		primaryStage.show();

	}

}
