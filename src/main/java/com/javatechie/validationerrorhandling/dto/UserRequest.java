package com.javatechie.validationerrorhandling.dto;

import com.javatechie.validationerrorhandling.entity.Gender;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserRequest {
    @NotBlank
    private String name;
    @Email
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "Not a valid phone number")
    private String mobile;
    private Gender gender;
    @Min(10)
    @Max(100)
    private int age;
    @NotBlank
    private String nationality;
}
