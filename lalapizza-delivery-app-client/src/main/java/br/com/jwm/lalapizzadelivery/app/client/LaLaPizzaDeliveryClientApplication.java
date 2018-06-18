package br.com.jwm.lalapizzadelivery.app.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"br.com.jwm.lalapizzadelivery.app.*"})
@EnableAutoConfiguration
public class LaLaPizzaDeliveryClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaLaPizzaDeliveryClientApplication.class, args);
	}
}
