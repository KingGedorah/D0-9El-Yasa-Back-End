package com.myjisc.berita.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBeritaRequestDTO extends CreateBeritaRequestDTO{
    private long idBerita;
}
