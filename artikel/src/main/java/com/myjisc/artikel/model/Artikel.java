package com.myjisc.artikel.model;

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
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idArtikel;

    @NotNull
    @Column(name = "judul_artikel", nullable = false)
    private String judulArtikel;

    @NotNull
    @Column(name = "isi_artikel", nullable = false, length = 1000)
    private String isiArtikel;

    @OneToMany(mappedBy = "berita", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ImageModel> imageModels;

    @Column(name = "kategori")
   private List<String> kategori;

   @Column(name = "is_deleted")
   private boolean isDeleted = false;

}
