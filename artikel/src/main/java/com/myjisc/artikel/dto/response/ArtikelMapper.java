package com.myjisc.artikel.dto.response;

import com.myjisc.artikel.dto.request.CreateArtikelRequestDTO;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myjisc.artikel.model.Artikel;

@Mapper(componentModel = "spring")
public interface ArtikelMapper {
    Artikel createArtikelRequestDTOToArtikel(CreateArtikelRequestDTO createArtikelRequestDTO);
}
