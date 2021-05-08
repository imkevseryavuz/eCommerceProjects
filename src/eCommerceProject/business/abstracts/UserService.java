package eCommerceProject.business.abstracts;
import java.util.List;
import eCommerceProject.entities.concretes.User;

public interface UserService {
	void add(User user);
	List<User>getAll();
	void userVerify(User user, int verificationCode);
	User get(int id);

}
