package eCommerceProject.business.concretes;
import eCommerceProject.business.abstracts.LoggerService;
import eCommerceProject.core.utilities.UserRule;
import eCommerceProject.entities.concretes.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LoggerManager implements LoggerService {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX=
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
	
	private boolean ifFirstNameCheckLength(User user) {
		if (user.getFirstName().length()<2) {
			System.out.println("Ad en az 2 karakter olmalıdır!");
			return false;
		}
		return true;
	}
	
	private boolean ifLastNameCheckLength(User user) {
		if (user.getLastName().length()<2) {
			System.out.println("Soyad en az 2 karakter olmalýdýr!");
			return false;
		}
		return true;
	}
	
	private boolean ifEmailFormatCheckValid(User email) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(email.geteMail()).find();
	}
	
	private boolean ifPasswordCheckLength(User user) {
		if (user.getPassword().length()<6) {
			System.out.println("Parola en az 6 karakter olmalýdýr!");
			return false;
		}
		return true;
	}

	private boolean isFirstandLastNameEmpty(User user) {
		if (user.geteMail()==null || user.getPassword()==null) {
			System.out.println("Kullanıcı adı veya parola eksik!");
			return false;
		}
		System.out.println("Sisteme giriş yapıldı!");
		return true;
	}
	
	@Override
	public boolean validate(User user) {
		boolean result=UserRule.Run(ifPasswordCheckLength(user),
				ifFirstNameCheckLength(user),
				ifLastNameCheckLength(user),
				ifEmailFormatCheckValid(user));
		return result;
	}

	@Override
	public boolean logIn(User user) {
		boolean result=UserRule.Run(isFirstandLastNameEmpty(user));
		return result;
	}

}
