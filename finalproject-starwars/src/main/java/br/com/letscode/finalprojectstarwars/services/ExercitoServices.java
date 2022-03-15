package br.com.letscode.finalprojectstarwars.services;

import br.com.letscode.finalprojectstarwars.models.Rebelde;
import br.com.letscode.finalprojectstarwars.repositories.ExercitoRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExercitoServices {

    final ExercitoRepository exercitoRepository;

    public ExercitoServices(ExercitoRepository exercitoRepository) {
        this.exercitoRepository = exercitoRepository;
    }

    @Transactional
    public Rebelde save(Rebelde rebelde) {
        return exercitoRepository.save(rebelde);
    }

    public List<Rebelde> findAll() {
        return exercitoRepository.findAll();
    }

    public Optional<Rebelde> findById(UUID id) {
        return exercitoRepository.findById(id);
    }

    @Transactional
    public void delete(Rebelde rebelde) {
        exercitoRepository.delete(rebelde);
    }

    public boolean validTransaction (String item1, String item2) {
        return true;
    }
}
