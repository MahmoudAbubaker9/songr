package com.songr.songr;

import com.songr.songr.Model.AlbumModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void AlbumsTest() {
		AlbumModel newAlbum = new AlbumModel("The Shawshank Redemption", "Morgan Freeman", 230,40,"https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX1000_.jpg");
		Assertions.assertEquals("The Shawshank Redemption", newAlbum.getTitle());
		Assertions.assertEquals("Morgan Freeman", newAlbum.getArtist());
		Assertions.assertEquals(230, newAlbum.getSongCount());
		Assertions.assertEquals(40, newAlbum.getLength());
		Assertions.assertEquals("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX1000_.jpg", newAlbum.getImageUrl());
	}


    @Test
    void getArtist() {
        AlbumModel newAlbum = new AlbumModel("The Shawshank Redemption", "Morgan Freeman", 230,40,"https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX1000_.jpg");
        Assertions.assertEquals("Morgan Freeman",newAlbum.getArtist());
    }



}
