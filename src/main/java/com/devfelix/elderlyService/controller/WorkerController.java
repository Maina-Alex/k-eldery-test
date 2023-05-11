package com.devfelix.elderlyService.controller;

import com.devfelix.elderlyService.dto.UniversalResponse;
import com.devfelix.elderlyService.dto.WorkerCapabilityDto;
import com.devfelix.elderlyService.dto.WorkerDto;
import com.devfelix.elderlyService.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/worker")
@RequiredArgsConstructor
public class WorkerController {
    private final WorkerService workerService;

    @PostMapping("/create")
    public Mono<ResponseEntity<UniversalResponse>> createWorker(@RequestBody WorkerDto workerDto){
        return Mono.just(workerService.createWorker(workerDto))
                .map(res-> UniversalResponse.builder().status(200)
                        .data(res).build())
                .map(ResponseEntity::ok);
    }

    @GetMapping("/get/{id}")
    public Mono<ResponseEntity<UniversalResponse>> getWorker(@PathVariable  long id){
        return Mono.just(workerService.getWorker(id))
                .map(res-> UniversalResponse.builder().status(200)
                        .data(res).build())
                .map(ResponseEntity::ok);
    }


    @PostMapping("/add/capabiity")
    public Mono<ResponseEntity<UniversalResponse>> addCapabiity(@RequestBody WorkerCapabilityDto workerCapabilityDto){
        return Mono.just(workerService.addCapabilities(workerCapabilityDto.capabilities(), workerCapabilityDto.workerId()))
                .map(res-> UniversalResponse.builder().status(200)
                        .data(res).build())
                .map(ResponseEntity::ok);
    }

    @GetMapping("/get/worker/{id}/capabiity")
    public Mono<ResponseEntity<UniversalResponse>> getWorkerCapabiity(@PathVariable long id ){
        return Mono.just(workerService.getWorkerCapabilities(id))
                .map(res-> UniversalResponse.builder().status(200)
                        .data(res).build())
                .map(ResponseEntity::ok);
    }

    @GetMapping("/get/workers")
    public Mono<ResponseEntity<UniversalResponse>> getWorkers(@RequestParam int page, int size){
        Pageable pageable= PageRequest.of(page,size);
        return Mono.just(workerService.getWorkers(pageable))
                .map(res-> UniversalResponse.builder().status(200)
                        .data(res).build())
                .map(ResponseEntity::ok);
    }


}
