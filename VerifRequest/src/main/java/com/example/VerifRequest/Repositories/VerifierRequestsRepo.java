package com.example.VerifRequest.Repositories;

import com.example.VerifRequest.Classes.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerifierRequestsRepo extends JpaRepository<Requests, Long> {
}
