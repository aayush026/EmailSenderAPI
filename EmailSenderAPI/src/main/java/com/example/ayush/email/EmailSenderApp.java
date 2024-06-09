package com.example.ayush.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import com.example.ayush.email.service.EmailSenderService;

@SpringBootApplication
public class EmailSenderApp {
	@Autowired
	private EmailSenderService emailSenderService;
	public static void main(String[] args) {
		SpringApplication.run(EmailSenderApp.class, args);
	}
 
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		emailSenderService.sendEmail("{ EMAIL ADDRESS OF THE MAIL RECEIVER }", "{ EMAIL SUBJECT }",
				"{ EMAIL CONTENT }");
	}
}
