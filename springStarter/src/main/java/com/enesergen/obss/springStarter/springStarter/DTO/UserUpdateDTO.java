package com.enesergen.obss.springStarter.springStarter.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
public class UserUpdateDTO {
    @NotBlank
    private String password;
}
