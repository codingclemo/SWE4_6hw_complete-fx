package com.sammereyer.helper;

import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class ButtonGenerator {
	
	public static Button createTextButton(String id, String caption) {
		Button button = new Button(caption);
		button.setId(id);
		button.setPadding(new Insets(5));
		button.setPrefSize(100, 30);
		return button;
	}

}
