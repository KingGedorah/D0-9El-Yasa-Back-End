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
@Table(name = "artikel")
public class Berita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "judul_artikel", nullable = false)
    private String judulBerita;

    @NotNull
    @Column(name = "isi_artikel", nullable = false, length = 1000)
    private String isiBerita;

    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "image")
    private byte[] imageBerita;

    private List<String> kategori;

}