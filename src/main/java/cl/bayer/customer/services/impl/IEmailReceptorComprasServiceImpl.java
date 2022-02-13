package cl.bayer.customer.services.impl;

import cl.bayer.customer.model.entity.EmailBody;
import cl.bayer.customer.services.IEmailPortService;
import cl.bayer.customer.services.IEmailReceptorComprasService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class IEmailReceptorComprasServiceImpl implements IEmailReceptorComprasService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailPortServiceImpl.class);
	
    @Autowired
    private JavaMailSender sender;

	@Override
	public boolean sendEmailReceptorCompras(EmailBody emailBody) {
        LOGGER.info("EmailBody: {}", emailBody.toString());
        return sendEmailReceptorCompras(emailBody.getContent(),emailBody.getAverageContent(),emailBody.getFooterContent(),emailBody.getEmail(), emailBody.getSubject());
	}
	
	private boolean sendEmailReceptorCompras(String textMessage, String textAverageMessage, String textFooterMessage, String email, String subject) {
		boolean send = false;
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setTo(email);
            helper.setText(textMessage+"\r\n"+textAverageMessage+"\r\n\r\n"+textFooterMessage, true);
            helper.setSubject(subject);
            sender.send(message);
            send = true;
            LOGGER.info("Mail enviado exitosamente!");
        } catch (MessagingException e) {
            LOGGER.error("Hubo un error al enviar el mail: {}", e);
        }
        return send;
	}
}
