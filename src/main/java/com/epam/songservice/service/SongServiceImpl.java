package com.epam.songservice.service;

import com.epam.songservice.entity.Song;
import com.epam.songservice.exception.NotFoundException;
import com.epam.songservice.payload.SongDTO;
import com.epam.songservice.payload.SongID;
import com.epam.songservice.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    @Override
    public SongID attachMetadata(SongDTO songDTO) {
        Song song = Song.builder()
                .album(songDTO.album())
                .artist(songDTO.artist())
                .name(songDTO.name())
                .length(songDTO.length())
                .resourceId(songDTO.resourceId())
                .year(songDTO.year())
                .build();
        Song sabedSong = songRepository.saveAndFlush(song);
        return new SongID(sabedSong.getId());
    }

    @Override
    public SongDTO getSongMetadataById(Integer id) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Song with id - %s does not exists", id)));
        return song.mapToSongDTO();
    }

    @Override
    public List<Integer> deleteSong(List<Integer> ids) {
        List<Integer> deletedResources = new ArrayList<>();
        ids.stream().filter(songRepository::existsById).forEach(id -> {
            deletedResources.add(id);
            songRepository.deleteById(id);
        });
        return deletedResources;
    }
}
