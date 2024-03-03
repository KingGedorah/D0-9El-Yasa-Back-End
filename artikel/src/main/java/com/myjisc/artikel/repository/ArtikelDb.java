package com.myjisc.artikel.repository;

import com.myjisc.artikel.model.Artikel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ArtikelDb extends JpaRepository<Artikel, Long> {
}
