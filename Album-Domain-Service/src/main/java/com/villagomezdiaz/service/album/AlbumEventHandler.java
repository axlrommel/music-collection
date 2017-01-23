package com.villagomezdiaz.service.album;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.villagomezdiaz.service.album.domain.Album;

@RepositoryEventHandler
public class AlbumEventHandler {

	@HandleBeforeCreate
	public void handleAlbumSave(Album album) {
		if(album.getName() != null) {
			album.setName(album.getName().toLowerCase());
		}
	}
}
