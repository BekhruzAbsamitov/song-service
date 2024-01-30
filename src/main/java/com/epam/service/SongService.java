package com.epam.service;

import com.epam.dto.MetadataDto;
import com.epam.entity.Metadata;

import com.epam.mapstruct.MetadataMapper;
import com.epam.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final MetadataMapper mapper;

    @Autowired
    public SongService(SongRepository songRepository, MetadataMapper mapper) {
        this.songRepository = songRepository;
        this.mapper = mapper;
    }

    public Integer save(MetadataDto metadata) {
        Metadata song = mapper.toMetadata(metadata);
        Metadata savedSong = songRepository.save(song);
        return savedSong.getId();
    }

    public MetadataDto getSong(Integer id) {
        return songRepository
                .findById(id)
                .map(mapper::toMetadataDto)
                .orElse(null);
    }

    public List<Integer> deleteSongs(String ids) {
        return Arrays.stream(ids.split(","))
                .map(Integer::valueOf)
                .filter(songRepository::existsById)
                .peek(songRepository::deleteById).toList();
    }
}
