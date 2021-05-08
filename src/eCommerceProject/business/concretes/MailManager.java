package eCommerceProject.business.concretes;
import java.util.Random;
import eCommerceProject.business.abstracts.MailService;

public class MailManager implements MailService {
	int verificationCode;
	public MailManager() {
		Random random=new Random();
		this.verificationCode=random.nextInt(1000)*10;
	}
	@Override
	public int mailSend() {
		
		return this.verificationCode;
	}


}
