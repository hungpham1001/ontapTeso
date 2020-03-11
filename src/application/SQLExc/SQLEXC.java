package application.SQLExc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import application.JDBCConnfig.JDBCDriver;
import application.validation.Validate;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class SQLEXC {
	public void login(String userName, String pass) throws SQLException {
		Validate valid = new Validate();
		if(valid.testRegex(userName, pass, ".")) {
			showAlert(AlertType.ERROR, "Please start with character or number");
		} else if(valid.testBlank(userName, pass, ".")) {
			showAlert(AlertType.ERROR, "Do not leave blank!");
		} else {
			Map<String, String> result = this.find(userName);
			if(result.get("user")!=null) {
				if(result.get("pass").equals(pass)) {
					showAlert(AlertType.INFORMATION, "Welcome "+userName);
				} else{
					showAlert(AlertType.ERROR, "Your password is incorrect! Please try again");
				}
			} else {
				showAlert(AlertType.ERROR, "Your user name is incorrect! Please try again");
			}
		}
	}
	public void regist(String userName, String pass, String address) {
		Validate valid = new Validate();
		if(valid.testRegex(userName, pass, address)) {
			showAlert(AlertType.ERROR, "Please start with character or number");
		} else if(valid.testBlank(userName, pass, address)) {
			showAlert(AlertType.ERROR, "Do not leave blank!");
		} else {
			Map<String, String> result = this.find(userName);
			if(result.get("user")==null) {
				String sql = "INSERT INTO members(id,pass_word,address) VALUES(?, ?, ?)";
				try {
					JDBCDriver jdbc = new JDBCDriver();
					Connection connect = jdbc.run();
					PreparedStatement prepare = connect.prepareStatement(sql);
					prepare.setString(1, userName);
					prepare.setString(2, pass);
					prepare.setString(3, address);
					prepare.executeUpdate();
					showAlert(AlertType.INFORMATION, "Create account success!");
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			} else {
				showAlert(AlertType.ERROR, "The User already existed");
			}
		}
	}
	public Map<String, String> find(String user) {
		System.out.println(user);
		String sql = "SELECT * FROM members WHERE id = ?";
		Map<String, String> map = new HashMap<String, String>();
		try {
			JDBCDriver jdbc = new JDBCDriver();
			Connection connect = jdbc.run();
			PreparedStatement prepare = connect.prepareStatement(sql);
			prepare.setString(1, user);
			ResultSet result = prepare.executeQuery();
			if(result.next()) {
				map.put("user", result.getNString("id"));
				map.put("pass", result.getNString("pass_word"));
			} else {
				map.put("user", null);
			}
			connect.close();
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void showAlert(Alert.AlertType alertType, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle("Information");
		alert.setHeaderText(message);
		alert.show();
	}
}
