package com.villagomezdiaz.service.artist;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.villagomezdiaz.service.artist.domain.Artist;

public class ArtistValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Artist artist = (Artist)target;

		if(artist.getName() == null) {
			errors.rejectValue("artist", "artist.null", "Artist is required.");
		}

	}

}
