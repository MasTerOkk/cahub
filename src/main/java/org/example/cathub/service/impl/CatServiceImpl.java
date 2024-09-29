package org.example.cathub.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.cathub.dto.CatDto;
import org.example.cathub.mapper.CatMapper;
import org.example.cathub.repository.CatRepository;
import org.example.cathub.service.CatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CatServiceImpl implements CatService {
    CatRepository catRepository;
    CatMapper catMapper;
    @Override
    public CatDto create(CatDto catDto) {
        if (catDto.getId() != null) {
            throw new RuntimeException("Id must be null");
        }
        return catMapper.modelToDto(catRepository.save(catMapper.dtoToModel(catDto)));
    }

    @Override
    public CatDto update(CatDto catDto) {
        if (catDto.getId() == null) {
            throw new RuntimeException("Id must be present");
        }
        return catMapper.modelToDto(catRepository.save(catMapper.dtoToModel(catDto)));
    }

    @Override
    public void delete(Long id) {
        catRepository.deleteById(id);
    }

    @Override
    public CatDto findById(Long id) {
        return catMapper.modelToDto(catRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Cat not found")));
    }

    @Override
    public List<CatDto> getAllCats() {
        return catRepository.findAll().stream().map(catMapper::modelToDto).toList();
    }
}
