package com.villagomezdiaz.service.artist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;


@SpringBootApplication
@EnableDiscoveryClient
public class ArtistDomainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtistDomainServiceApplication.class, args);
	}
	
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		return new RepositoryRestConfigurerAdapter() {
			@Override
			public void configureValidatingRepositoryEventListener(
					ValidatingRepositoryEventListener validatingListener) {
				validatingListener.addValidator("beforeCreate", new ArtistValidator());
				validatingListener.addValidator("beforeSave", new ArtistValidator());
				
			}
		};
	}
}
