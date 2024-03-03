package com.myjisc.berita.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "berita")
public class Berita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBerita;

    @NotNull
    @Column(name = "judul_berita", nullable = false)
    private String judulBerita;

    @NotNull
    @Column(name = "isi_berita", nullable = false, length = 1000)
    private String isiBerita;

    @Column(name = "kategori")
    private List<String> kategori;

    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "image")
    private byte[] imageArtikel;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;
}