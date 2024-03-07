package com.myjisc.berita.dto.request;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBeritaRequestDTO extends CreateBeritaRequestDTO{
    @Valid
    private long idBerita;
}
