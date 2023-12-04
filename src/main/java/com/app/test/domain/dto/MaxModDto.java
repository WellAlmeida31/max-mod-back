package com.app.test.domain.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MaxModDto {
    @NotNull
    @Min(value = 1, message = "El número debe ser mayor que cero.")
    private Integer x;
    @NotNull( message = "El número no puede ser nulo.")
    private Integer y;
    @NotNull( message = "El número no puede ser nulo.")
    private Integer n;
}
