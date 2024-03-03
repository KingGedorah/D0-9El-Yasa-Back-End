package com.myjisc.artikel.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "image_model")
public class ImageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageName;

    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "image")
    private byte[] imageArtikel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_artikel", referencedColumnName = "idArtikel")
    private Artikel artikel;
}
