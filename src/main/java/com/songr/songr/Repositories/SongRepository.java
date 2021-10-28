package com.songr.songr.Repositories;

import com.songr.songr.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByTitle(String title);
}
