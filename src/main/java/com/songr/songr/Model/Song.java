package com.songr.songr.Model;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String title;
    int length;
    int trackNumber;

    @ManyToOne
    AlbumModel album;

    public Song() {
    }

    public Song(String title, int length, int trackNumber, AlbumModel album) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.album=album;
    }

    public Song(String title, int length) {
    }

    public Song(String title, int length, AlbumModel album) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public AlbumModel getAlbum() {
        return album;
    }

    public void setAlbum(AlbumModel album) {
        this.album = album;
    }
}
