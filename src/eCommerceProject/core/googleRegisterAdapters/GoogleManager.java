package eCommerceProject.core.googleRegisterAdapters;

import eCommerceProject.business.abstracts.LoggerService;
import eCommerceProject.core.utilities.UserRule;
import eCommerceProject.entities.concretes.User;
import eCommerceProject.signUpGoogle.RegisterGoogle;


public class GoogleManager implements LoggerService {
	RegisterGoogle registerGoogle=new RegisterGoogle();
	@Override
	public boolean validate(User user) {
		boolean result=false;
		result=registerGoogle.register(user.getId(), user.getFirstName(), user.getLastName(), user.geteMail(),user.getPassword());
		if(result!= true) {
			return false;
		}
		System.out.println("Google ile kayýt olundu!");
		return true;
	}

	@Override
	public boolean logIn(User user) {
		boolean result=UserRule.Run(isFirstandLastNameEmpty(user));
		return result;
	}
	private boolean isFirstandLastNameEmpty(User user) {
		if (user.geteMail()==null || user.getPassword()==null) {
			System.out.println("Kullanýcý adý veya parola eksik!");
			return false;
		}
		System.out.println("Sisteme giriþ yapýldý!");
		return true;
	}
}
