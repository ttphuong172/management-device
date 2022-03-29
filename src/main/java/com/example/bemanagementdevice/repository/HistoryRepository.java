package com.example.bemanagementdevice.repository;

import com.example.bemanagementdevice.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History,Integer> {
}
