package org.example.cathub.service;

import org.example.cathub.dto.CatDto;

import java.util.List;

public interface CatService {
    CatDto create(CatDto catDto);
    CatDto update(CatDto catDto);
    void delete(Long id);
    CatDto findById(Long id);
    List<CatDto> getAllCats();
}
