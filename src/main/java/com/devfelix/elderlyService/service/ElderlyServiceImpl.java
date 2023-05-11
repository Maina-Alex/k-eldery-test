package com.devfelix.elderlyService.service;

import com.devfelix.elderlyService.dto.ElderlyDto;
import com.devfelix.elderlyService.exception.ServiceException;
import com.devfelix.elderlyService.model.Elderly;
import com.devfelix.elderlyService.repository.ElderlyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ElderlyServiceImpl implements ElderlyService{
    private final ElderlyRepository elderlyRepository;

    @Override
    public Elderly createElderly(ElderlyDto elderlyDto) {
        //check if Elderly exists
        Elderly elderly=elderlyRepository.findByNationalId(elderlyDto.nationalId())
                .orElse(null);
        if(elderly!=null){
            throw new ServiceException("Elderly already exists");
        }
        Elderly elderly1=Elderly.builder()
                .firstName(elderlyDto.firstName())
                .lastName(elderlyDto.lastName())
                .age(elderlyDto.age())
                .nationalId(elderlyDto.nationalId())
                .county(elderlyDto.county())
                .location(elderlyDto.location())
                .build();

        return elderlyRepository.save(elderly1);
    }

    @Override
    public Elderly getElderly(long id) {
        return elderlyRepository.findById(id)
                .orElseThrow(()-> new ServiceException("Elderly already exists"));
    }

    @Override
    public Page<Elderly> getElderlys(Pageable pageable) {
        return elderlyRepository.findAll(pageable);
    }
}
