package com.villagomezdiaz.service.album;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

	@Bean
	AlbumEventHandler albumEventHandler() {
		return new AlbumEventHandler();
	}
}
