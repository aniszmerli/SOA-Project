package com.example.CheckClientService.Repositories;

import com.example.CheckClientService.Classes.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CheckClientRepo extends JpaRepository<Clients, String> {

    Optional<Clients> findById(String id);
}
