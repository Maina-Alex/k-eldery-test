package com.devfelix.elderlyService.controller;

import com.devfelix.elderlyService.dto.ElderlyDto;
import com.devfelix.elderlyService.dto.UniversalResponse;
import com.devfelix.elderlyService.service.ElderlyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/elderly")
public class ElderlyController {
    private final ElderlyService elderlyService;

    @PostMapping("/add")
    public Mono<ResponseEntity<UniversalResponse>> addElderly(@Valid @RequestBody ElderlyDto movieDto){
        return Mono.just(elderlyService.createElderly(movieDto))
                .map(res-> UniversalResponse.builder().status(200)
                        .data(res).build())
                .map(ResponseEntity::ok);
    }

    @GetMapping("/get/{id}")
    public Mono<ResponseEntity<UniversalResponse>> getElderly(@PathVariable long id){
        return Mono.just(elderlyService.getElderly(id))
                .map(res-> UniversalResponse.builder().status(200)
                        .data(res).build())
                .map(ResponseEntity::ok);

    }

    @PostMapping("/all")
    public Mono<ResponseEntity<UniversalResponse>> getAllElderly(@RequestParam int page, @RequestParam int size, @RequestHeader long userId){
        Pageable pageable= PageRequest.of(page, size);
        return Mono.just(elderlyService.getElderlys(pageable))
                .map(res-> UniversalResponse.builder().status(200)
                        .data(res).build())
                .map(ResponseEntity::ok);
    }

}
