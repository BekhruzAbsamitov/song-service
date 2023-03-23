package com.epam.songservice.entity;

import com.epam.songservice.payload.SongDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    @Id
    @SequenceGenerator(
            name = "song_id_sequence",
            sequenceName = "song_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "song_id_sequence"
    )
    private Integer id;
    private String name;
    private String artist;
    private String album;
    private String length;
    private Integer resourceId;
    private String year;

    public SongDTO mapToSongDTO() {
        return new SongDTO(name, artist, album, length, resourceId, year);
    }
}
