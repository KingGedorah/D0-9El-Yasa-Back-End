package com.myjisc.berita.dto.request;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Valid
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBeritaRequestDTO {
    @NotBlank
    private String judulBerita;

    @NotBlank
    private String isiBerita;

    private List<String> kategori;
    
    private byte[] imageBerita;
}
