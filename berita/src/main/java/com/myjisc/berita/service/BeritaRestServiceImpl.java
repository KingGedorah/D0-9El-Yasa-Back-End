package com.myjisc.berita.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.myjisc.berita.dto.request.UpdateBeritaRequestDTO;
import com.myjisc.berita.model.Berita;
import com.myjisc.berita.repository.BeritaDb;

@Service
@Transactional
public class BeritaRestServiceImpl implements BeritaRestService{
    @Autowired
    private BeritaDb beritaDb;

    @Override
    public void createRestBerita(Berita berita) {
        beritaDb.save(berita);
    }

    @Override
    public List<Berita> retrieveRestAllBerita() {
        return beritaDb.findAll();
    }

    @Override
    public Berita getRestBeritaById(long id) {
        for (Berita berita : retrieveRestAllBerita()) {
            if (berita.getIdBerita() == id) {
                return berita;
            }
        }
        return null;
    }

    @Override
    public void deleteRestBerita(Berita berita) {
        berita.setDeleted(true);
        beritaDb.save(berita);
    }

    @Override
    public Berita updateRestBerita(UpdateBeritaRequestDTO beritaFromDTO) {
        Berita berita = getRestBeritaById(beritaFromDTO.getIdBerita());
        if (berita == null) {
            return null;
        }else {
            berita.setJudulBerita(beritaFromDTO.getJudulBerita());
            berita.setIsiBerita(beritaFromDTO.getIsiBerita());
            berita.setKategori(beritaFromDTO.getKategori());
            berita.setImageBerita(beritaFromDTO.getImageBerita());
            beritaDb.save(berita);
        }
        return berita;
    }
}
