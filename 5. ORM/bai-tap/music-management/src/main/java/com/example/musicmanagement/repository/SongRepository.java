package com.example.musicmanagement.repository;

import com.example.musicmanagement.model.Song;

import javax.persistence.EntityTransaction;
import java.util.List;

public class SongRepository {
    public List<Song> findAll() {
        return BaseRepository.entityManager.createQuery("FROM Song", Song.class).getResultList();
    }

    public void save(Song song) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(song);
        transaction.commit();
    }

    public Song findById(int id) {
        return BaseRepository.entityManager.find(Song.class, id);
    }

    public void update(Song song) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(song);
        transaction.commit();
    }

    public void remove(int id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        Song song = findById(id);
        if (song != null) {
            BaseRepository.entityManager.remove(song);
        }
        transaction.commit();
    }
}
