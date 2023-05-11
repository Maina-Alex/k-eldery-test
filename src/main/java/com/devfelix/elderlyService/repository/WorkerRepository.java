package com.devfelix.elderlyService.repository;

import com.devfelix.elderlyService.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
    boolean existsByNationalId(String nationalId);
}
