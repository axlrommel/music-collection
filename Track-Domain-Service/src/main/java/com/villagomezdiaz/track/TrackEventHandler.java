package com.villagomezdiaz.track;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.villagomezdiaz.track.domain.Track;

@RepositoryEventHandler
public class TrackEventHandler {

	@HandleBeforeCreate
	public void handleTrackSave(Track track) {
		if(track.getName() != null) {
			track.setName(track.getName().toLowerCase());
		}
	}
}
