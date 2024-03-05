package com.myjisc.berita.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.myjisc.berita.dto.BeritaMapper;
import com.myjisc.berita.dto.request.CreateBeritaRequestDTO;
import com.myjisc.berita.model.Berita;
import com.myjisc.berita.service.BeritaRestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/berita")
public class BeritaRestController {
    @Autowired
    BeritaRestService beritaRestService;

    @Autowired
    BeritaMapper beritaMapper;

    @PostMapping("/create")
    public ResponseEntity createBerita(@Valid @RequestBody CreateBeritaRequestDTO beritaRequestDTO,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data");
        }

        Berita berita = beritaMapper.createRestBeritaDTOToBerita(beritaRequestDTO);
        beritaRestService.createRestBerita(berita);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(berita);
    }

}