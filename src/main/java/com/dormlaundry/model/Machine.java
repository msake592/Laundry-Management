package com.dormlaundry.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MachineType type;

    @Enumerated(EnumType.STRING)
    private MachineStatus status;

    // JPA için zorunlu boş constructor
    protected Machine() {
    }

    public Machine(MachineType type, MachineStatus status) {
        this.type = type;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public MachineType getType() {
        return type;
    }

    public MachineStatus getStatus() {
        return status;
    }

    public void setStatus(MachineStatus status) {
        this.status = status;
    }
}