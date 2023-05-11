package com.devfelix.elderlyService.repository;

import com.devfelix.elderlyService.model.Elderly;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElderlyRepository extends JpaRepository<Elderly,Long> {
    Optional<Elderly> findByNationalId(String nationalId);
}
