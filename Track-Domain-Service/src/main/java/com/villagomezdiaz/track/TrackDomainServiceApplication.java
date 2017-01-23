package com.villagomezdiaz.track;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;

import com.villagomezdiaz.track.domain.Track;

@SpringBootApplication
@EnableDiscoveryClient
public class TrackDomainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackDomainServiceApplication.class, args);
	}
	
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		return new RepositoryRestConfigurerAdapter() {
			@Override
			public void configureValidatingRepositoryEventListener(
					ValidatingRepositoryEventListener validatingListener) {
				validatingListener.addValidator("beforeCreate", new TrackValidator());
				validatingListener.addValidator("beforeSave", new TrackValidator());
			}
		};
	}
	
	@Bean
	public ResourceProcessor<Resource<Track>> sessionProcessor() {
		return new ResourceProcessor<Resource<Track>>() {

			@Override
			public Resource<Track> process(Resource<Track> resource) {
				Track track = resource.getContent();
				resource.add(new Link("http://localhost:8080/albums/" + track.getAlbum(), "album"));
				return resource;
			}
		};
	}
}
