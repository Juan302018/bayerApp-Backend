package cl.bayer.customer.services;

import cl.bayer.customer.model.entity.EmailBody;

public interface IEmailPortService {
	public boolean sendEmail(EmailBody emailBody);

}
