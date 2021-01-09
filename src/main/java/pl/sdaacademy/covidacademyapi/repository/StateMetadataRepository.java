package pl.sdaacademy.covidacademyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdaacademy.covidacademyapi.model.StateMetadata;

public interface StateMetadataRepository extends JpaRepository<StateMetadata, Long> {

}
