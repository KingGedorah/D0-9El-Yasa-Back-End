package com.myjisc.berita.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReadBeritaResponseDTO {
    private long idBerita;
    private String judulBerita;
    private String isiBerita;
    private List<String> kategori;
    private byte[] imageArtikel;
    private boolean isDeleted;
    
}
