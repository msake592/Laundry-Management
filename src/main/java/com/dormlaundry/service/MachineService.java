package com.dormlaundry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dormlaundry.model.Machine;
import com.dormlaundry.model.MachineStatus;
import com.dormlaundry.repository.MachineRepository;

@Service
public class MachineService {

    private final MachineRepository machineRepository;
    //ctor injection
    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    public Machine addMachine(Machine machine) {
        return machineRepository.save(machine);
    }

    public List<Machine> getAllMachines() {
        return machineRepository.findAll();
    }

    public Optional<Machine> getMachineById(Long id) {
        return machineRepository.findById(id);
    }

    public Optional<Machine> markMachineAsBroken(Long id) {
        Optional<Machine> machineOpt = machineRepository.findById(id);

        if (machineOpt.isPresent()) {
            Machine machine = machineOpt.get();
            machine.setStatus(MachineStatus.BROKEN);
            machineRepository.save(machine);
        }

        return machineOpt;
    }

    public boolean deleteMachine(Long id){
        if(!machineRepository.existsById(id)){
            return false;
        }
        machineRepository.deleteById(id);
        return true;
    }
}