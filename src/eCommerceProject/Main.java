package eCommerceProject;
import java.util.Scanner;

import eCommerceProject.business.abstracts.LoggerService;
import eCommerceProject.business.abstracts.UserService;
import eCommerceProject.business.concretes.LoggerManager;
import eCommerceProject.business.concretes.MailManager;
import eCommerceProject.business.concretes.UserManager;
import eCommerceProject.core.googleRegisterAdapters.GoogleManager;
import eCommerceProject.dataAccess.concretes.InMemoryUserDao;
import eCommerceProject.entities.concretes.User;





public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		LoggerService loggerManager=new GoogleManager();
		
		User realUser=new User();
		realUser.setId(1);
		realUser.setFirstName("Kevser");
		realUser.setLastName("Yavuz");
		realUser.seteMail("kevser.yavuz07@gmail.com");
		realUser.setPassword("deneme1");
		
		
		User fakeUser=new User();
		fakeUser.setId(2);
		fakeUser.setFirstName("Büþra");
		fakeUser.setLastName("Yavuz");
		fakeUser.seteMail("büþra@gmail.com");
		fakeUser.setPassword("deneme1");
		
		UserService userService=new UserManager(new InMemoryUserDao(),new LoggerManager(),new MailManager());
		userService.getAll();
		userService.add(realUser);
		
		int verificationCode=scanner.nextInt();
		userService.userVerify(fakeUser, verificationCode);
		
		userService.add(fakeUser);	

		
		
	
}
}	

