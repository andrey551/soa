/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tad.itmo.repositories;

import com.tad.itmo.Entity.WorkerEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Never
 */
@Repository
public interface WorkerRepository 
        extends JpaRepository<WorkerEntity, Long>{
    Optional<WorkerEntity> findWorkerById(Long id);
    
    void deleteById(Long id);
    
    @Query(value = "SELECT AVG(SALARY) FROM WORKER", nativeQuery=true)
    double averageSalary();
    
    @Query(value = "SELECT (WORKER.NAME, COUNT(*)) FROM WORKER GROUP BY NAME ", nativeQuery=true)
    List<Pair<String, Integer>> groupCountByBName();
    
    @Query(value = "SELECT * FROM WORKER WHERE SALARY = :salary", nativeQuery=true)
    Optional<List<WorkerEntity>> poorWorkers(@Param("salary") float salary);
    
    
}
