package com.example.music.service.impl;

import com.example.music.model.Song;
import com.example.music.repository.SongRepository;
import com.example.music.service.IService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements IService {
    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song getSongById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void saveSong(Song song) {
        songRepository.save(song);
    }

    @Override
    @Transactional
    public void updateSong(Song song) {
        songRepository.save(song);
    }

    @Override
    @Transactional
    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
