package application.Layout;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class MainLayout {
	public BorderPane LayoutLogin(GridPane grid) {
		BorderPane layout = new BorderPane();
		layout.setPadding(new Insets(15, 20, 15, 20));
		Button loginButton = new Button();
		Button registerButton = new Button();
		loginButton.setText("Login");
		registerButton.setText("Regist");
		registerButton.setOnAction(e -> {
			this.LayoutRegist(grid);
		});
		HBox hBox = new HBox();
		hBox.setSpacing(50);
		hBox.getChildren().addAll(loginButton, registerButton);
		layout.setBottom(hBox);
		layout.setCenter(grid);
		return layout;
	}
	
	public BorderPane LayoutRegist(GridPane grid) {
		BorderPane layout = new BorderPane();
		layout.setPadding(new Insets(15, 20, 15, 20));
		Button registerButton = new Button();
		registerButton.setText("Create");
		layout.setCenter(grid);
		layout.setBottom(registerButton);
		BorderPane.setAlignment(registerButton, Pos.CENTER);
		return layout;
	}
}
