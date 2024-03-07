package com.myjisc.artikel.service;

import com.myjisc.artikel.dto.request.CreateArtikelRequestDTO;
import com.myjisc.artikel.dto.request.CreateArtikelRequestDTO;
import com.myjisc.artikel.model.Artikel;
import com.myjisc.artikel.repository.ArtikelDb;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.rmi.NoSuchObjectException;
import java.util.List;

@Service
@Transactional
public class ArtikelRestService {

    @Autowired
    private ArtikelDb artikelDb;

    @Autowired
    private ImageUtil imageUtil;

    public List<Artikel> retreiveAllArtikel() {
        return artikelDb.findAll();
    }

    public List<Artikel> retreiveAvailableArtikel() {
        return artikelDb.findAll();
    }

    public Artikel createRestArtikel (CreateArtikelRequestDTO artikelDTO, MultipartFile file) throws IOException {
        Artikel artikel = new Artikel();
        artikel.setJudulArtikel(artikelDTO.getJudulArtikel());
        artikel.setIsiArtikel(artikelDTO.getIsiArtikel());
        artikel.setKategori(artikelDTO.getKategori());

        byte[] imageArtikel = imageUtil.compressImage(file.getBytes());
        artikel.setImageArtikel(imageArtikel);

        artikelDb.save(artikel);

        return  artikel;
    }

    public byte[] getImage (String idArtikel) throws NoSuchObjectException {
        Artikel existingArtikel = artikelDb.findById(Long.valueOf(idArtikel)).get();

        if (existingArtikel != null) {
            byte[] image = imageUtil.decompressImage(existingArtikel.getImageArtikel());

            return image;
        } else {
            throw new NoSuchObjectException("Article not found");
        }

    }
}
