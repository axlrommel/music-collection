package com.villagomezdiaz.service.artist;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


import com.villagomezdiaz.service.artist.domain.Artist;

public interface ArtistRepository extends MongoRepository<Artist, String> {

	@RestResource(path = "byName", rel = "artist")
	Artist findByName(@Param("name") String name);

    @RestResource(path = "byId", rel = "artist")
    Artist findById(@Param("id") String id);
}
