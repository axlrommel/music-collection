package com.villagomezdiaz.track;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.villagomezdiaz.track.domain.Track;

public interface TrackRepository extends MongoRepository<Track, String> {
	
	@RestResource(path = "byName", rel = "track")
	public Page<Track> findByName(@Param("name") String name, Pageable p);

    @RestResource(path = "byId", rel = "track")
    public Page<Track> findById(@Param("id") String id, Pageable p);
    
    @RestResource(path = "byAlbum", rel = "track")
    public Page<Track> findByAlbum(@Param("album") String album, Pageable p);
    

}
