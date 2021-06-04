package com.fredericoffs.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fredericoffs.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
