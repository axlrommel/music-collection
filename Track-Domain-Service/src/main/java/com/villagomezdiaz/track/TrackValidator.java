package com.villagomezdiaz.track;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.villagomezdiaz.track.domain.Track;

public class TrackValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Track.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Track track = (Track) target;
		
		if(track.getAlbum() == null) {
			errors.rejectValue("album", "album.null", "Album is required.");
		}
	}

}
