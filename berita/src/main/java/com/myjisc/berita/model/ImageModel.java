package com.myjisc.berita.model;

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

    @Column(name = "image_name")
    private String imageName;

    @Lob
    @Basic(fetch = FetchType.EAGER)
    @Column(name = "image_data")
    private byte[] imageBerita;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_berita", referencedColumnName = "idBerita")
    private Berita berita;
}
