package com.example.ClientService.Repositories;

import com.example.ClientService.Classes.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client, String> {

    Optional<Client> findById(String id);
}
