package com.myjisc.berita.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.myjisc.berita.model.Berita;
import com.myjisc.berita.repository.BeritaDb;

@Service
@Transactional
public class BeritaRestService {
    @Autowired
    private BeritaDb beritaDb;

    public void createRestBerita(Berita berita) {
        beritaDb.save(berita);
    }

    public List<Berita> retrieveRestAllBerita() {
        return beritaDb.findAll();
    }

    public Berita getRestBeritaById(long id) {
        for (Berita berita : retrieveRestAllBerita()) {
            if (berita.getIdBerita() == id) {
                return berita;
            }
        }
        return null;
    }

    public void deleteRestBerita(Berita berita) {
        berita.setDeleted(true);
        beritaDb.save(berita);
    }

}
