package cl.bayer.customer.services;

import cl.bayer.customer.model.entity.EmailBody;

public interface IEmailReceptorComprasService {
	public boolean sendEmailReceptorCompras(EmailBody emailBody);
}
