package application;
	

import java.sql.SQLException;

import application.Form.Form;
import application.SQLExc.SQLEXC;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Form form = new Form();
		BorderPane layout = new BorderPane();
		Scene scene = new Scene(layout,400,400);
		HBox hBox = new HBox();
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		try {
			layout.setPadding(new Insets(15, 20, 15, 20));
			Button loginButton = new Button("Login");
			Button registerButton = new Button("Regist");
			Button createButton = new Button("Create Account");
			Button backToLogin = new Button("Login");
			loginButton.setOnAction(event ->{
				try {
					SQLEXC jdbc = new SQLEXC();
					jdbc.login(form.userName.getText(), form.password.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			registerButton.setOnAction(event ->{
				primaryStage.setTitle("Register");
				hBox.getChildren().clear();
				hBox.getChildren().addAll(backToLogin, createButton);
				layout.setCenter(form.addGridPaneRegist());
			});
			backToLogin.setOnAction(event ->{
				primaryStage.setTitle("Login");
				hBox.getChildren().clear();
				hBox.getChildren().addAll(loginButton, registerButton);
				layout.setCenter(form.addGridPaneLogin());
			});
			createButton.setOnAction(event->{
				SQLEXC exc = new SQLEXC();
				exc.regist(form.userName.getText(), form.password.getText(), form.address.getText());
			});
			primaryStage.setTitle("Login");
			hBox.setSpacing(50);
			hBox.getChildren().addAll(loginButton, registerButton);
			layout.setBottom(hBox);
			layout.setCenter(form.addGridPaneLogin());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
;