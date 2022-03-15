package br.com.letscode.finalprojectstarwars.repositories;

import br.com.letscode.finalprojectstarwars.models.Rebelde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExercitoRepository extends JpaRepository<Rebelde, UUID> {

}
