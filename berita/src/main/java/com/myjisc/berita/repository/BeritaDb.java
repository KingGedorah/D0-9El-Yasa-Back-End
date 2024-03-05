package com.myjisc.berita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myjisc.berita.model.Berita;

public interface BeritaDb extends JpaRepository<Berita, Long>{
}
