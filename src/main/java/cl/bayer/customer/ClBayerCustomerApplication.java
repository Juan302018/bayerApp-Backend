package cl.bayer.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class ClBayerCustomerApplication implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(ClBayerCustomerApplication.class, args);
	}

	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String password = "agaray.2022";
		String password2 = "nlopez.2022";
		
		
			String bcryptPassword = passwordEncoder.encode(password);
			System.out.println(bcryptPassword);
			
			bcryptPassword = passwordEncoder.encode(password2);
			System.out.println(bcryptPassword);
		
	}

}
