package com.myjisc.berita.restcontroller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.myjisc.berita.dto.BeritaMapper;
import com.myjisc.berita.dto.request.CreateBeritaRequestDTO;
import com.myjisc.berita.dto.request.UpdateBeritaRequestDTO;
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

        byte[] image = beritaRequestDTO.getImageBerita();
        // beritaRestService.processImage(image);

        Berita berita = beritaMapper.createRestBeritaDTOToBerita(beritaRequestDTO);
        beritaRestService.createRestBerita(berita);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("status", 200, "success", "message", "data", berita));
    }

    @GetMapping("/view-all")
    public ResponseEntity viewAllBerita() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("status", 200, "success", "message", "data", beritaRestService.retrieveRestAllBerita()));
    }

    @GetMapping("/{idBerita}")
    public ResponseEntity viewBerita(@PathVariable("idBerita") Long idBerita) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("status", 200, "success", "message", "data",
                        beritaRestService.getRestBeritaById(idBerita)));
    }

    @PutMapping("/ubah")
    public ResponseEntity updateBerita(
            @Valid @RequestBody UpdateBeritaRequestDTO beritaRequestDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data");
        }
        Berita berita = beritaRestService.updateRestBerita(beritaRequestDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("status", 200, "success", "message", "data", berita));
    }

}