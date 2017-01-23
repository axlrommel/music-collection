package com.villagomezdiaz.service.artist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

	@Bean
	ArtistEventHandler artistEventHandler() {
		return new ArtistEventHandler();
	}
}
