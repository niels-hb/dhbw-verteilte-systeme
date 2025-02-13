package de.dhbw.verteiltesysteme.api.rmi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import de.dhbw.verteiltesysteme.shared.FetcherService;

@Configuration
@SuppressWarnings("deprecation")
public class RMIConfiguration {

    @Bean
    RmiServiceExporter exporter(FetcherService implementation) {
        System.setProperty("java.rmi.server.hostname", "172.16.238.2");

        Class<FetcherService> serviceInterface = FetcherService.class;

        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceInterface(serviceInterface);
        exporter.setService(implementation);
        exporter.setServiceName(serviceInterface.getSimpleName());

        return exporter;
    }

}
