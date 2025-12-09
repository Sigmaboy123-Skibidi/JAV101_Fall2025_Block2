package com.poly.controller;

import java.util.Properties;

import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.Authenticator;
import jakarta.mail.Message.RecipientType;

public class Lab5_B2_Mailer {
	public static void send(String from, String to, String subject, String body) {
		// Code send mail đặt ở đây
		// Thông số kết nối GMail
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		// Đăng nhập GMail
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				String username = "quangvvts02059@gmail.com";
				String password = "lcqt vkxm atnq qnqt";
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			// Tạo mail
			MimeMessage mail = new MimeMessage(session);
			mail.setFrom(new InternetAddress(from));
			mail.setRecipients(RecipientType.TO, to);
			mail.setSubject(subject, "utf-8");
			mail.setText(body, "utf-8", "html");
			mail.setReplyTo(mail.getFrom());
			// Gửi mail
			Transport.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
