package com.myjisc.berita.dto;

import org.mapstruct.Mapper;

import com.myjisc.berita.dto.request.CreateBeritaRequestDTO;
import com.myjisc.berita.dto.response.ReadBeritaResponseDTO;
import com.myjisc.berita.model.Berita;

@Mapper(componentModel = "spring")
public interface BeritaMapper {
    Berita createRestBeritaDTOToBerita(CreateBeritaRequestDTO createBeritaRequestDTO);
    
    ReadBeritaResponseDTO beritaToReadBeritaResponseDTO(Berita berita);  
}
