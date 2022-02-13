package cl.bayer.customer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.bayer.customer.model.entity.EmailBody;
import cl.bayer.customer.services.IEmailPortService;
import cl.bayer.customer.services.IEmailReceptorComprasService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/email")
public class EmailController {
	
    @Autowired
    private IEmailPortService service;
    
    @Autowired
    private IEmailReceptorComprasService receptorService;
    
    @PostMapping("/send")
    @ResponseBody
    public boolean SendEmail(@RequestBody EmailBody emailBody)  {
        return service.sendEmail(emailBody);
    }
    
    @PostMapping("/sendReceptorCompras")
    @ResponseBody
    public boolean sendEmailReceptorCompras(@RequestBody EmailBody emailBody)  {
        return receptorService.sendEmailReceptorCompras(emailBody);
    }

}
