package com.dormlaundry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dormlaundry.model.Machine;

public interface MachineRepository extends JpaRepository<Machine, Long> {
}
