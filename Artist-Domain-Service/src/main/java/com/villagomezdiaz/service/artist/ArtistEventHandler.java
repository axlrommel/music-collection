package com.villagomezdiaz.service.artist;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.villagomezdiaz.service.artist.domain.Artist;

@RepositoryEventHandler
public class ArtistEventHandler {

	@HandleBeforeCreate
	public void handleArtistSave(Artist artist) {
		if(artist.getGenre() != null) {
			artist.setGenre(artist.getGenre().toLowerCase());
		}
		
		if(artist.getName() != null) {
			artist.setName(artist.getName().toLowerCase());
		}
	}
}
