package com.example.music.service;

import com.example.music.model.Song;

import java.util.List;

public interface IService {
    List<Song> getAllSongs();

    Song getSongById(Long id);

    void saveSong(Song song);

    void updateSong(Song song);

    void deleteSong(Long id);
}
