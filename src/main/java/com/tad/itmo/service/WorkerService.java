package com.tad.itmo.service;

import com.tad.itmo.Entity.WorkerEntity;
import com.tad.itmo.repositories.WorkerRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

/**
 *
 * @author Never
 */

@Service
@RequiredArgsConstructor
public class WorkerService {
    private final WorkerRepository workerRepo;
    
    @Autowired
    public WorkerService(WorkerRepository workerRepo) {
        this.workerRepo = workerRepo;
    }
    
    public boolean addWorker(WorkerEntity workerToAdd) {
        this.workerRepo.save(workerToAdd);
    }
    public Optional<WorkerEntity> getWorkerById(Long id) {
        return workerRepo.findById(id);
    }
    
    public List<WorkerEntity> getWorkers() {
        return workerRepo.findAll();
    }
    
    
    public boolean updateWorker(WorkerEntity workerToUpdate) {
       return workerRepo.save(workerToUpdate) != null;
    }
    
    public void deleteUser(Long id) {
        workerRepo.deleteById(id);
    }
    
    public double averageWorkerSalary() {
        return workerRepo.averageSalary();
    }
    
    public List<Pair<String , Integer>> groupByName() {
        return workerRepo.groupCountByBName();
    } 
    
    public Optional<List<WorkerEntity>> poorWorker(float salary) {
        return workerRepo.poorWorkers(salary);
    }
}
