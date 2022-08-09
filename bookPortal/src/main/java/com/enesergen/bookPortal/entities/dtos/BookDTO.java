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
public class BookDTO {
    @NotBlank
    private String isbn;
    private String name;
    private int pageSize;
    private String imageUrl;
    private String description;
    private long authorId;
}
