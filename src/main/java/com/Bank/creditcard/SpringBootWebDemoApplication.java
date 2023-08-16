package com.Bank.creditcard;
import com.Bank.creditcard.banking.dao.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import java.util.logging.Logger;

//http://localhost:8080/swagger-ui.html
//https://spring.io/blog/2021/11/29/spring-data-mongodb-relation-modelling
//https://www.baeldung.com/spring-boot-mongodb-auto-generated-field
//https://www.baeldung.com/spring-data-partial-update

@SpringBootApplication
public class SpringBootWebDemoApplication {
	Logger logger = Logger.getLogger(SpringBootWebDemoApplication.class.getSimpleName());

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args)
	{
		ConfigurableApplicationContext context =
				SpringApplication.run(SpringBootWebDemoApplication.class, args);
		System.out.println("application started");
	}

	@Bean
	public void init() {


	}
}



