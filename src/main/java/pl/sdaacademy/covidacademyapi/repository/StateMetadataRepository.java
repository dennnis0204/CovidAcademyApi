package pl.sdaacademy.covidacademyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdaacademy.covidacademyapi.model.StateMetadata;

import java.util.Optional;

public interface StateMetadataRepository extends JpaRepository<StateMetadata, Long> {

    Optional<StateMetadata> findFirstByNameIgnoreCase(String name);
}
