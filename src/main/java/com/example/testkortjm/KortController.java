package com.example.testkortjm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class KortController {
    private final KortRepository kortRepository;

    @Autowired
    public KortController(KortRepository kortRepository) {
        this.kortRepository = kortRepository;
    }

    @PostMapping("/createKortstokk")
    public ResponseEntity<String> createKortstokk() {
        try {
            kortRepository.createKortstokk(); // Opprett kortstokk
            return ResponseEntity.ok("Kortstokk ble opprettet"); // Returnerer OK-status uten ID
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Feil ved opprettelse av kortstokk: " + e.getMessage());
        }
    }

    @PostMapping("/insertKort")
    public ResponseEntity<String> insertKort(@RequestParam("kortstokk_id") String kortstokkId, @RequestBody Kort kort) {
        try {
            kortRepository.insertKort(kortstokkId, kort);
            return ResponseEntity.ok("Kortet ble lagt til i kortstokken med ID: " + kortstokkId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Feil ved innsetting av kort: " + e.getMessage());
        }
    }

    @GetMapping("/getKortstokk")
    public ResponseEntity<List<Kort>> getKortstokk(@RequestParam("kortstokk_id") String kortstokkId) {
        try {
            List<Kort> kortList = kortRepository.getKortstokk(kortstokkId);
            return ResponseEntity.ok(kortList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }
}