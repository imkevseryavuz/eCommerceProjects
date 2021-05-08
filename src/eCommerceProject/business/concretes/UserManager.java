package eCommerceProject.business.concretes;
import java.util.ArrayList;
import java.util.List;

import eCommerceProject.business.abstracts.LoggerService;
import eCommerceProject.business.abstracts.MailService;
import eCommerceProject.business.abstracts.UserService;
import eCommerceProject.dataAccess.abstracts.UserDao;
import eCommerceProject.entities.concretes.User;

public class UserManager implements UserService {
	private UserDao userDao;
	private LoggerService loggerService;
	private MailService mailService;
	
	public UserManager(UserDao userDao, LoggerService loggerService, MailService mailService) {
		super();
		this.userDao = userDao;
		this.loggerService = loggerService;
		this.mailService = mailService;
	}
	
	List<User> users=new ArrayList<User>();
	public UserManager() {
		users.add((User) this.getAll());
	}
	
	@Override
	public void add(User user) {
		if (userCheck(user.geteMail()) &&loggerService.validate(user)) {
			userDao.add(user);
			System.out.println("Do�rulama Kodunuz Mail Olarak G�nderildi! Do�rulama Kodunuz: "+ mailService.mailSend());
			System.out.print("Do�rulama Kodunu Giriniz: ");
			return;			
		}
		System.out.println("Kullan�c� Bilgilerini Kontrol Ediniz!");
	}

	@Override
	public List<User> getAll() {
		List<User> result=this.userDao.getAll();
		return result;
	}


	@Override
	public void userVerify(User user, int verificationCode) {
		int result=mailService.mailSend();
		if (result==verificationCode) {
			
			System.out.println("Kullan�c� do�ruland�. �yeli�iniz Tamamland�!!! "+user.getFirstName());
		}
		else {
			System.out.println("Do�rulama kodunuz yanl��!");
		}
	}

	@Override
	public User get(int id) {
		User result=this.userDao.get(id);
		return result;
	}

	public boolean userCheck(String mail) {
		if (userDao.geteMail(mail)!=null) {
			System.out.println("Kullan�c� mevcut!");
			return false;
		}
		return true;
	}
}

