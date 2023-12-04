package com.app.test.service;

import com.app.test.domain.MaxMod;
import com.app.test.domain.dto.MaxModDto;
import com.app.test.domain.dto.MaxModOutputDto;
import com.app.test.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository repository;
    private final ModelMapper modelMapper = new ModelMapper();
    public Integer maxModNumber(MaxModDto maxModDto) {
        Integer x = maxModDto.getX();
        Integer y = maxModDto.getY();
        Integer n = maxModDto.getN();

        int k = n - (n - y) % x;
        save(maxModDto, k);
        return k;
    }

    protected void save(MaxModDto maxModDto, Integer k){
        if(exist(maxModDto)) return;

        MaxMod maxMod = this.modelMapper.map(maxModDto, MaxMod.class);
        maxMod.setK(k);
        repository.save(maxMod);
    }

    public List<MaxModOutputDto> findAllMaxMods(){
        return repository.findAll()
                .stream()
                .map(maxMod -> modelMapper.map(maxMod, MaxModOutputDto.class))
                .collect(Collectors.toList());
    }

    protected boolean exist(MaxModDto maxModDto){
        return repository.existMaxMod(maxModDto.getX(), maxModDto.getY(), maxModDto.getN());
    }
}
