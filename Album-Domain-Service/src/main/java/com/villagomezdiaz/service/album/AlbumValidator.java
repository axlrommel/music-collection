package com.villagomezdiaz.service.album;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.villagomezdiaz.service.album.domain.Album;

public class AlbumValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Album.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Album album = (Album)target;

		if(album.getArtist() == null) {
			errors.rejectValue("artist", "artist.null", "Artist is required.");
		}
		
	}

}
