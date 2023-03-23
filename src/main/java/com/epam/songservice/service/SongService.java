package com.epam.songservice.service;

import com.epam.songservice.payload.SongDTO;
import com.epam.songservice.payload.SongID;

import java.util.List;

public interface SongService {

    SongID attachMetadata(SongDTO songDTO);
    SongDTO getSongMetadataById(Integer id);

    List<Integer> deleteSong(List<Integer> ids);
}
