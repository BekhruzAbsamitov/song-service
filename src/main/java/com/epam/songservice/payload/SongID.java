package com.epam.songservice.payload;


public record SongID(Integer id) {

    public SongID(Integer id) {
        this.id = id;
    }
}
