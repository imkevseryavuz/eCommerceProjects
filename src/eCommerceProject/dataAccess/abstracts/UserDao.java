package eCommerceProject.dataAccess.abstracts;
import java.util.List;
import eCommerceProject.entities.concretes.User;

public interface UserDao {
	void add(User user);
	User get(int id);
	List<User> getAll();
	User geteMail(String mail);
}
