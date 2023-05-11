package com.devfelix.elderlyService.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class WorkerCapability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String capability;
    @ManyToOne
    private Worker worker;
}
