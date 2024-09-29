package org.example.cathub.mapper;

import org.example.cathub.dto.CatDto;
import org.example.cathub.model.Cat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CatMapper {
    Cat dtoToModel(CatDto catDto);
    CatDto modelToDto(Cat cat);
}
