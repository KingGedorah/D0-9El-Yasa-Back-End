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
    private long idBerita;

    @NotNull
    @Column(name = "judul_artikel", nullable = false)
    private String judulBerita;

    @NotNull
    @Column(name = "isi_artikel", nullable = false, length = 1000)
    private String isiBerita;

    private List<String> kategori;

    @OneToMany(mappedBy = "artikel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ImageModel> imageModels;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;
}