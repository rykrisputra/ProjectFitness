package com.fitness.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitness.main.entity.History;

public interface HistoryRepository extends JpaRepository<History, Long>{

}
