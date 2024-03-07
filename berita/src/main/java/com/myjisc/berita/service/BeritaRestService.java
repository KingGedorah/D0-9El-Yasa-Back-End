package com.myjisc.berita.service;

import java.util.List;

import com.myjisc.berita.dto.request.UpdateBeritaRequestDTO;
import com.myjisc.berita.model.Berita;

public interface BeritaRestService {
    void createRestBerita(Berita berita);
    List<Berita> retrieveRestAllBerita();
    Berita getRestBeritaById(long id);
    void deleteRestBerita(Berita berita);
    Berita updateRestBerita(UpdateBeritaRequestDTO beritaFromDTO);
}
