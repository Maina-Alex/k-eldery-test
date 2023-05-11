package com.devfelix.elderlyService.service;

import com.devfelix.elderlyService.dto.WorkerDto;
import com.devfelix.elderlyService.model.Worker;
import com.devfelix.elderlyService.model.WorkerCapability;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WorkerService {
    Worker createWorker(WorkerDto workerDto);
    Worker getWorker(long id);
    List<WorkerCapability> addCapabilities(List<String> capabilities, long workerId);
    List<WorkerCapability> getWorkerCapabilities(long workerId);
    Page<Worker> getWorkers(Pageable pageable);

}
