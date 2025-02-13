package de.dhbw.verteiltesysteme.fetcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import de.dhbw.verteiltesysteme.shared.FetcherService;

@SpringBootApplication
@EnableScheduling
public class FetcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(FetcherApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	@SuppressWarnings("deprecation")
	RmiProxyFactoryBean fetcherService() {
		RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
		rmiProxyFactory.setServiceUrl("rmi://172.16.238.2:1099/FetcherService");
		rmiProxyFactory.setServiceInterface(FetcherService.class);
		return rmiProxyFactory;
	}

}
