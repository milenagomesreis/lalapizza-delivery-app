package br.com.jwm.lalapizzadelivery.app.backoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"br.com.jwm.lalapizzadelivery.app.*"})
public class LaLaPizzaDeliveryBackofficeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaLaPizzaDeliveryBackofficeApplication.class, args);
	}
}
