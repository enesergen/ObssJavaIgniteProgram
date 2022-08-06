package com.enesergen.bookPortal.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    @NotBlank
    private String name;

    private int birthYear;

    private String birthPlace;
}
