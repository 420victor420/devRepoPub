package com.mkyong.common.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSendToException {
    private static String empId1;
//	public MailSendToException(){}

	public static void sendMail(String msg, String exception,String jrId,String empID) {
		if(empID.equalsIgnoreCase("")){
			empId1="";
		}else{
			empId1 ="</br><p style='font-family: arial; font-size: 14px;opacity:12;text-decoration:none;'>Emp ID - "+empID+"</br>";
		}
		final String emailId = "vivekdiscover16@gmail.com";
		final String emailPass = "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv";
		String host = "smtp.gmail.com";
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", emailId);
		props.put("mail.smtp.password", emailPass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		Session mailSession = javax.mail.Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(emailId, emailPass);
					}
				});
		try {
			Message message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress("" + emailId + ""));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("vivek.v@netconnectglobal.com"));
//			message.addRecipient(RecipientType.CC, new InternetAddress(
//					"sitaram.s@netconnectglobal.com"));
//			message.addRecipient(RecipientType.BCC, new InternetAddress(
//					"rohit.t@netconnectglobal.com"));
			message.setSubject(" Exception Mail - JR ID: "+jrId+ " in " + msg + "");
			
			message.setContent("<p style='font-family: arial; font-size: 13px;opacity:12;'>"+ exception + "</p></br>"
					+ ""+empId1+"", "text/html");
			Transport.send(message);
			System.out.println("Exception Mail Send");
		} catch (MessagingException e) {
			System.out.println("Exception in Mail Send"+e.getMessage());
		}
	}

}
