package idrok.net.ngPrime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class NgPrimeApplication implements ApplicationRunner {



	public static void main(String[] args) {
		SpringApplication.run(NgPrimeApplication.class, args);



	}




	@Override
	public void run(ApplicationArguments args) throws Exception {





	}
}
