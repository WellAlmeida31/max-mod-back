package com.app.test.controller;

import com.app.test.domain.dto.MaxModDto;
import com.app.test.domain.dto.MaxModOutputDto;
import com.app.test.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("buildnumber")
public class ApplicationController {

    final ApplicationService service;

    @PostMapping
    public ResponseEntity<Integer> maxModNumber(@RequestBody @Valid MaxModDto maxModDto){
        return ResponseEntity.ok(service.maxModNumber(maxModDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MaxModOutputDto>> allMaxMods(){
        return ResponseEntity.ok(service.findAllMaxMods());
    }
}
