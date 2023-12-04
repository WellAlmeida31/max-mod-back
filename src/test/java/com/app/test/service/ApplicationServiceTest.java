package com.app.test.service;

import com.app.test.domain.MaxMod;
import com.app.test.domain.dto.MaxModDto;
import com.app.test.repository.ApplicationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {
    @InjectMocks
    ApplicationService applicationService;
    @Mock ApplicationRepository repository;
    ModelMapper modelMapper = new ModelMapper();

    MaxModDto modDto;
    MaxMod maxMod = new MaxMod();

    @BeforeEach
    void setup(){
        modDto = new MaxModDto(7,5,12345);
        maxMod = modelMapper.map(modDto, MaxMod.class);
        maxMod.setK(12339);
    }

    @Test
    @DisplayName("Debe realizar correctamente el cálculo")
    void executeMaxModNumber(){

        int k = applicationService.maxModNumber(modDto);
        verify(repository).save(any(MaxMod.class));
        Assertions.assertEquals(12339, k);
    }

    @Test
    @DisplayName("Debe guardar la información del cálculo.")
    void saveMaxModNumber(){
        when(applicationService.exist(modDto)).thenReturn(false);
        when(repository.save(any())).thenReturn(maxMod);

        applicationService.save(modDto, 12339);
        verify(repository).existMaxMod(modDto.getX(), modDto.getY(), modDto.getN());
        verify(repository).save(any(MaxMod.class));
    }
}
