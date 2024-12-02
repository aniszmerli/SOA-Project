package com.example.RequestsManagement.Repositories;

import com.example.RequestsManagement.Classes.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestsManagementRepo extends JpaRepository<Requests, Long> {
}
