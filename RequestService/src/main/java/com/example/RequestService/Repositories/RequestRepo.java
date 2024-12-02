package com.example.RequestService.Repositories;

import com.example.RequestService.Classes.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<Requests, String> {
}
