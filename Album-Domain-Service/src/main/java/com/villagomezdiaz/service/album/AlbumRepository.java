package com.villagomezdiaz.service.album;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.villagomezdiaz.service.album.domain.Album;

public interface AlbumRepository extends MongoRepository<Album, String> {
	
	@RestResource(path = "byName", rel = "album")
	public Page<Album> findByName(@Param("name") String name, Pageable p);

    @RestResource(path = "byId", rel = "album")
    public Page<Album> findById(@Param("id") String id, Pageable p);
    
    @RestResource(path = "byArtist", rel = "album")
    public Page<Album> findByArtist(@Param("artist") String artist, Pageable p);

}
