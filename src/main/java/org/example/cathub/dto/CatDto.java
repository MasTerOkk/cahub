package org.example.cathub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.cathub.model.Gender;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatDto {
    Long id;
    String breed;
    String nickname;
    Gender gender;
}
