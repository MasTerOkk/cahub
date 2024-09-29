package org.example.cathub.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.cathub.dto.CatDto;
import org.example.cathub.service.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cat")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CatController {
    CatService catService;
    @GetMapping
    public ResponseEntity<List<CatDto>> getAll() {
        return ResponseEntity.ok(catService.getAllCats());
    }

    @GetMapping("/{catId}")
    public ResponseEntity<CatDto> getById(@PathVariable Long catId) {
        return ResponseEntity.ok(catService.findById(catId));
    }

    @PostMapping
    public ResponseEntity<CatDto> create(@RequestBody CatDto catDto) {
        return ResponseEntity.ok(catService.create(catDto));
    }

    @PutMapping
    public ResponseEntity<CatDto> update(@RequestBody CatDto catDto) {
        return ResponseEntity.ok(catService.update(catDto));
    }

    @DeleteMapping("/{catId}")
    public ResponseEntity<String> delete(@PathVariable Long catId) {
        catService.delete(catId);
        return ResponseEntity.noContent().build();
    }
}
