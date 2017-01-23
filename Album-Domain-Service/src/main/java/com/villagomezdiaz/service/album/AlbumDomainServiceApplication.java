package com.villagomezdiaz.service.album;

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

import com.villagomezdiaz.service.album.domain.Album;


@SpringBootApplication
@EnableDiscoveryClient
public class AlbumDomainServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbumDomainServiceApplication.class, args);
	}
	
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		return new RepositoryRestConfigurerAdapter() {
			@Override
			public void configureValidatingRepositoryEventListener(
					ValidatingRepositoryEventListener validatingListener) {
				validatingListener.addValidator("beforeCreate", new AlbumValidator());
				validatingListener.addValidator("beforeSave", new AlbumValidator());
				
			}
		};
	}
	
	@Bean
	public ResourceProcessor<Resource<Album>> sessionProcessor() {
		return new ResourceProcessor<Resource<Album>>() {

			@Override
			public Resource<Album> process(Resource<Album> resource) {
				Album album = resource.getContent();
				resource.add(new Link("http://localhost:8080/artists/" + album.getArtist(), "artist"));
				return resource;
			}
		};
	}
}
