package eCommerceProject.signUpGoogle;

public class RegisterGoogle {
	public boolean register(int id, String firstName, String lastName, String eMail,String password) {
			if(firstName.length()>5 && lastName.length()>5 && eMail.length()>5 && password.length()>5) {
				return true;				
			}
		return false;
	}
}
