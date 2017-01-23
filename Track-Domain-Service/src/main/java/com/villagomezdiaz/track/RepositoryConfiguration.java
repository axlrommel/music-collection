package com.villagomezdiaz.track;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

	@Bean
	TrackEventHandler trackEventHandler() {
		return new TrackEventHandler();
	}
}
