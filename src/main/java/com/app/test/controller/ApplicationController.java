package com.app.test.controller;

import com.app.test.domain.dto.MaxModDto;
import com.app.test.domain.dto.MaxModOutputDto;
import com.app.test.service.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "buildnumber")
@Tag(name = "Pruebla técnica", description = "Prueba técnica con Backend en Spring-Boot y Java 11")
public class ApplicationController {

    final ApplicationService service;

    @Operation(
            summary = "Ejecutando el cálculo",
            description = "<ul><li><p>Se deben ingresar los números X, Y y N.<p></li>" +
                    "<li><p>Se deben ingresar todos los números: solo valores numéricos</p></li>" +
                    "<li><p>El número X no puede ser cero.</p></li>")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Integer.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) })
    })
    @PostMapping
    public ResponseEntity<Integer> maxModNumber(@RequestBody @Valid MaxModDto maxModDto){
        return ResponseEntity.ok(service.maxModNumber(maxModDto));
    }

    @Operation(
            summary = "Consultar los cálculos realizadoso",
            description = "<ul><li><p>Consulta la lista de todos los cálculos realizados.<p></li>")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = MaxModOutputDto.class), mediaType = "application/json") }),
    })
    @GetMapping("/all")
    public ResponseEntity<List<MaxModOutputDto>> allMaxMods(){
        return ResponseEntity.ok(service.findAllMaxMods());
    }
}
