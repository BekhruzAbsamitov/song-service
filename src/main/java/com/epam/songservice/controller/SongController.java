package com.epam.songservice.controller;

import com.epam.songservice.payload.SongDTO;
import com.epam.songservice.payload.SongID;
import com.epam.songservice.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/song")
public class SongController {

    private final SongService songService;

    @PostMapping("/songs")
    public ResponseEntity<SongID> attachMetadata(@RequestBody SongDTO songDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(songService.attachMetadata(songDTO));
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<SongDTO> getSongById(@PathVariable Integer id) {
        return ResponseEntity.ok(songService.getSongMetadataById(id));
    }

    @DeleteMapping("/songs")
    public ResponseEntity<List<Integer>> deleteSong(@RequestParam List<Integer> ids) {
        return ResponseEntity.ok(songService.deleteSong(ids));
    }


}
