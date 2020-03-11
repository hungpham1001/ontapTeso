package application.validation;

public class Validate {
	public boolean testRegex(String userName, String pass, String address) {
		if(pass.matches("^[<>]")||userName.matches("^[<>]")||address.matches("^[<>]")) {
			return true;
		}
		return false;
	}
	public boolean testBlank(String userName, String pass, String address) {
		if(pass.trim().isEmpty()||userName.trim().isEmpty()||address.trim().isEmpty()) {
			return true;
		}
		return false;
	}
}
