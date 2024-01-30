package com.epam.controller;

import com.epam.dto.MetadataDto;
import com.epam.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static com.epam.util.ValidateParam.isNotValid;

@RestController
@RequestMapping("/api/v1")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping("/song")
    public ResponseEntity<?> uploadMetadata(@RequestBody MetadataDto metadata) {
        Integer savedSongId = songService.save(metadata);
        return ResponseEntity.status(HttpStatus.OK).body(savedSongId);
    }

    @GetMapping("/song/{id}")
    public ResponseEntity<?> getSong(@PathVariable(value = "id") Integer id) {
        MetadataDto song = songService.getSong(id);
        if (Objects.isNull(song)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No song with id: " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(song);
    }

    @DeleteMapping("/song/{ids}")
    public ResponseEntity<?> deleteSong(@PathVariable(value = "ids") String ids) {
        if (isNotValid(ids)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("IDs length should be less than 200 characters");
        }
        List<Integer> deletedSongs = songService.deleteSongs(ids);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deletedSongs);
    }

}
