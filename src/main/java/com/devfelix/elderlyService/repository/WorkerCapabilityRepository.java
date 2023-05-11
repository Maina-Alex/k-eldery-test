package com.devfelix.elderlyService.repository;

import com.devfelix.elderlyService.model.WorkerCapability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerCapabilityRepository extends JpaRepository<WorkerCapability,Long> {

    List<WorkerCapability> findAllByWorkerId(long workerId);
}
