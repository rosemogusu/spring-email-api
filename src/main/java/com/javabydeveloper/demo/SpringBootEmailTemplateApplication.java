package com.javabydeveloper.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.javabydeveloper.mail.service.EmailSenderService;
import com.javabydeveloper.model.Mail;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringBootEmailTemplateApplication implements ApplicationRunner {

	@Autowired
	private EmailSenderService emailService;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailTemplateApplication.class, args);}
		@Override
		public void run(ApplicationArguments args) throws Exception {

			log.info("START... Sending email");
			Mail mail = new Mail();
			mail.setFrom("rmogusu123@gmail.com.com");//replace with your desired email
			mail.setMailTo("rosemogusu@adalabsafrica.com.com");//replace with your desired email
			mail.setSubject("Email with Spring boot and thymeleaf template!");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("name", "Developer!");
			model.put("location", "United States");
			model.put("sign", "Java Developer");
			mail.setProps(model);
			emailService.sendEmail(mail);
			log.info("END... Email sent success");

		}


}
