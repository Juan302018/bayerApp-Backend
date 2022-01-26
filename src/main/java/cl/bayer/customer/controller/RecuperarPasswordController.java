package cl.bayer.customer.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.bayer.customer.exception.ModelNotFoundException;
import cl.bayer.customer.model.entity.EmailBody;
import cl.bayer.customer.model.entity.Usuario;
import cl.bayer.customer.services.IEmailPortService;
import cl.bayer.customer.services.IUsuarioService;

@Controller
@RequestMapping("/recuperarPassword")
public class RecuperarPasswordController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
    private IEmailPortService emailService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	
	@PostMapping("/correo/{email}")
	@ResponseBody
    public boolean RecuperarPassword(@PathVariable("email") String email)  {
		Usuario usuario = usuarioService.findByEmailUsuario(email);
		if (usuario == null) {
			throw new ModelNotFoundException("USUARIO NO ENCONTRADO!");
		}
		
		String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
	    String numbers = "0123456789";

	    // combine all strings
	    String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

	    // create random string builder
	    StringBuilder sb = new StringBuilder();

	    // create an object of Random class
	    Random random = new Random();

	    // specify length of random string
	    int length = 10;

	    for(int i = 0; i < length; i++) {

	      // generate random index number
	      int index = random.nextInt(alphaNumeric.length());

	      // get character specified by index
	      // from the string
	      char randomChar = alphaNumeric.charAt(index);

	      // append the character to string builder
	      sb.append(randomChar);
	    }

	    String randomString = sb.toString();
	    System.out.println("Nuevo Password: " + randomString);
	    
	    System.out.print(usuario);
		
	    String password = passwordEncoder.encode(randomString);
		usuario.setPassword(password);
		System.out.println("Nuevo Password: " + password);
		usuarioService.save(usuario);
		
		EmailBody emailBody = new EmailBody();
		emailBody.setSubject("Recuperación de contraseña de aplicacion Bayer Seminia");
		emailBody.setEmail(email);
		emailBody.setContent("Su nueva contraseña es " + randomString);
		emailBody.setAverageContent(" .Por seguridad de la cuenta , no debe compartir esta contraseña.");
		emailBody.setFooterContent("Por favor no responder a este correo.");
        return emailService.sendEmail(emailBody);
    }

}
