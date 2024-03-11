package com.myjisc.kelas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kelas")
public class Kelas {

    @Id
    private UUID idKelas = UUID.randomUUID();

    @NotNull
    @Column(name = "nama_kelas", nullable = false)
    private String namaKelas;

    @NotNull
    @Column(name = "deskripsi_kelas", nullable = false)
    private String deskripsiKelas;

    @NotNull
    @Column(name = "nuptk_guru", nullable = false)
    private Long nuptkGuru;

    @NotNull
    @Column(name = "daftar_nisn_siswa")
    private List<Long> nisnSiswa;

    @OneToMany(mappedBy = "kelas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MataPelajaran> listMataPelajaran;

    @NotNull
    @Column(name = "is_deleted")
    private boolean isDeleted = false;

}
