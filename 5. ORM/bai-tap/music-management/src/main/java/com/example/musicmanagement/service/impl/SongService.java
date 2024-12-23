package com.example.musicmanagement.service.impl;

import com.example.musicmanagement.model.Song;
import com.example.musicmanagement.repository.SongRepository;
import com.example.musicmanagement.service.ISongService;

import java.util.List;

public class SongService implements ISongService {

    private SongRepository repository = new SongRepository();

    @Override
    public List<Song> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Song song) {
        repository.save(song);
    }

    @Override
    public Song findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(Song song) {
        repository.update(song);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }
}
