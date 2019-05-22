package project.thangnd.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class SendEmail {

	private String emailToRecipient, emailSubject, emailMessage;
	private String emailFromRecipient = "dinhthangms96@gmail.com";
	
	private JavaMailSender mailSenderObj;
	public void SendEmailTo(String mailTo){
		emailSubject = "Đơn hàng mới";
		emailMessage = "Bạn có đơn hàng mới";
		emailToRecipient = mailTo;
		mailSenderObj.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mimMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimMsgHelperObj.setTo(emailToRecipient);
				mimMsgHelperObj.setSubject(emailSubject);
				mimMsgHelperObj.setText(emailMessage);
				mimMsgHelperObj.setFrom(emailFromRecipient);
				
			}
		});
	}
	
}
