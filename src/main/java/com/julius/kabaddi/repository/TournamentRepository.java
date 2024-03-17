package com.julius.kabaddi.repository;

import com.julius.kabaddi.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface TournamentRepository extends JpaRepository<Tournament, String> {
}
