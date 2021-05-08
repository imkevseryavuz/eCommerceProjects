package eCommerceProject.business.abstracts;
import eCommerceProject.entities.concretes.User;

public interface LoggerService {
	boolean validate(User user);
	boolean logIn(User user);

}
