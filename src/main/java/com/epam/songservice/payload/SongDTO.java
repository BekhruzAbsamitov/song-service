package com.epam.songservice.payload;


public record SongDTO(
        String name,
        String artist,
        String album,
        String length,
        Integer resourceId,
        String year
) {
}
