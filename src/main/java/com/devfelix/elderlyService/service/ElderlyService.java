package com.devfelix.elderlyService.service;

import com.devfelix.elderlyService.dto.ElderlyDto;
import com.devfelix.elderlyService.model.Elderly;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ElderlyService {
    Elderly createElderly(ElderlyDto elderlyDto);

    Elderly getElderly(long id);

    Page<Elderly> getElderlys(Pageable pageable);
}
