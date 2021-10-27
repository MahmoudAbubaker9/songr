package com.songr.songr.Repositories;

import com.songr.songr.Model.AlbumModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<AlbumModel, Long> {

}
