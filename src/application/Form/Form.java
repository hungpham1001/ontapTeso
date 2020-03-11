package application.Form;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Form {
	public TextField userName;
	public PasswordField password;
	public TextField address;
	public GridPane addGridPaneLogin() {
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10,10,10,10));
		Label userLabel = new Label("User: ");
		userName = new TextField();
		userName.setPromptText("Username");
		Label passLabel = new Label("Pass: ");
		password = new PasswordField();
		password.setPromptText("Password");
		grid.add(userLabel, 0, 0);
		grid.add(userName, 1, 0);
		grid.add(passLabel, 0, 1);
		grid.add(password, 1, 1);
		return grid;
	}
	public GridPane addGridPaneRegist() {
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10,10,10,10));
		Label userLabel = new Label("User: ");
		userName = new TextField();
		userName.setPromptText("Username");
		Label passLabel = new Label("Pass: ");
		password = new PasswordField();
		Label addressLable = new Label("Address: ");
		address = new TextField();
		address.setPromptText("Address");
		
		grid.add(userLabel, 0, 0);
		grid.add(userName, 1, 0);
		grid.add(passLabel, 0, 1);
		grid.add(password, 1, 1);
		grid.add(addressLable, 0, 2);
		grid.add(address, 1, 2);
		return grid;
	}
}
