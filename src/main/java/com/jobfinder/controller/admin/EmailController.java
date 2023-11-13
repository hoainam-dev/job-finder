package com.jobfinder.controller.admin;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/sendEmail")
public class EmailController {
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(method = RequestMethod.GET)
	public String getForm() {
		return "email/emailForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String sendEmail(HttpServletRequest request, @RequestParam("attachFile") CommonsMultipartFile attachFile) {

		// reads form input
		final String emailTo = request.getParameter("mailTo");
		final String subject = request.getParameter("subject");
		final String message = request.getParameter("message");

		// for logging
		System.out.println("emailTo: " + emailTo);
		System.out.println("subject: " + subject);
		System.out.println("message: " + message);
		System.out.println("attachFile: " + attachFile.getOriginalFilename());

		mailSender.send(new MimeMessagePreparator() {

			@SuppressWarnings("unlikely-arg-type")
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				messageHelper.setTo(emailTo);
				messageHelper.setSubject(subject);
				messageHelper.setText(message);

				// determines if there is an upload file, attach it to the e-mail
				String attachName = attachFile.getOriginalFilename();
				if (!attachFile.equals("")) {
					messageHelper.addAttachment(attachName, new InputStreamSource() {

						@Override
						public InputStream getInputStream() throws IOException {
							return attachFile.getInputStream();
						}
					});
				}

			}

		});

		return "email/success";
	}
}
