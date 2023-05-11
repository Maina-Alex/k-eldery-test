package com.devfelix.elderlyService.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(indexes = @Index(columnList = "nationalId"))
public class Elderly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String nationalId;
    private int age;
    private String location;
    private String county;
    private boolean isAlive;
    private Date createdOn;

    @PrePersist
    public void persist(){
        createdOn= new Date();
        isAlive=true;
    }
}
