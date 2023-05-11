package com.devfelix.elderlyService.service;

import com.devfelix.elderlyService.dto.WorkerDto;
import com.devfelix.elderlyService.exception.ServiceException;
import com.devfelix.elderlyService.model.Worker;
import com.devfelix.elderlyService.model.WorkerCapability;
import com.devfelix.elderlyService.repository.WorkerCapabilityRepository;
import com.devfelix.elderlyService.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService{
    private final WorkerRepository workerRepository;
    private final WorkerCapabilityRepository workerCapabilityRepository;
    @Override
    public Worker createWorker(WorkerDto workerDto) {
        if(workerRepository.existsByNationalId(workerDto.nationalId())){
            throw new RuntimeException("Worker already exists");
        }
        Worker worker= Worker.builder()
                .available(workerDto.available())
                .firstName(workerDto.firstName())
                .lastName(workerDto.lastName())
                .nationalId(workerDto.nationalId())
                .location(workerDto.location())
                .build();

        return workerRepository.save(worker);
    }

    @Override
    public Worker getWorker(long id) {
        return workerRepository.findById(id).orElseThrow(()->
                new ServiceException("Worker not found"));
    }

    @Override
    public List<WorkerCapability> addCapabilities(List<String> capabilities, long workerId) {
        Worker worker=workerRepository.findById(workerId).orElseThrow(()->
                new ServiceException("Worker not found"));
        List<WorkerCapability> workerCapabilities= new ArrayList<>();
        for (String capability: capabilities) {
            WorkerCapability cap= WorkerCapability.builder()
                    .capability(capability)
                    .worker(worker)
                    .build();
            workerCapabilities.add(cap);
        }
        return workerCapabilityRepository.saveAll(workerCapabilities);
    }

    @Override
    public List<WorkerCapability> getWorkerCapabilities(long workerId) {
        return workerCapabilityRepository.findAllByWorkerId(workerId);
    }

    @Override
    public Page<Worker> getWorkers(Pageable pageable) {
        return workerRepository.findAll(pageable);
    }
}
