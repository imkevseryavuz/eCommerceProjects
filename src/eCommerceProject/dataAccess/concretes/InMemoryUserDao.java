package eCommerceProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceProject.dataAccess.abstracts.UserDao;
import eCommerceProject.entities.concretes.User;

public class InMemoryUserDao implements UserDao {
	List<User> users=new ArrayList<User>();

	@Override
	public void add(User user) {
		System.out.println("Kayýt Eklendi: "+user.getFirstName()+" "+user.getLastName());
	}

	@Override
	public User get(int id) {
		User user=users.stream()
				.filter(u-> u.getId()==id)
				.findFirst()
				.orElse(null);
		System.out.println("Kullanýcý: "+user.getFirstName()+" "+user.getLastName());
		return user;
	}

	@Override
	public List<User> getAll() {
		for (User user : users) {
			System.out.println(user.getFirstName());
		}
		System.out.println("*-*-*-*-*-*-*-*-*");
		return this.users;
	}

	@Override
	public User geteMail(String mail) {
		User user=users.stream()
				.filter(u->u.geteMail()==mail)
				.findFirst()
				.orElse(null);
		return user;
	}

}
