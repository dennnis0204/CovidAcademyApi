package pl.sdaacademy.covidacademyapi.service;

import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.model.StateMetadata;
import pl.sdaacademy.covidacademyapi.model.StateStats;
import pl.sdaacademy.covidacademyapi.repository.CovidTrackingApi;
import pl.sdaacademy.covidacademyapi.repository.StateMetadataRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class AllStatesService {

    private final CovidTrackingApi covidTrackingApi;
    private final StateMetadataRepository stateMetadataRepository;


    public AllStatesService(CovidTrackingApi covidTrackingApi, StateMetadataRepository stateMetadataRepository) {
        this.covidTrackingApi = covidTrackingApi;
        this.stateMetadataRepository = stateMetadataRepository;
    }

    public StateStats[] getAllStatesCurrentStats() {
        return covidTrackingApi.getAllStatesCurrentStats();
    }

    public List<StateMetadata> getAllStatesMetadata() {

        if (stateMetadataRepository.count() > 0) {
            return stateMetadataRepository.findAll();
        }

        List<StateMetadata> stateMetadata = Arrays.asList(covidTrackingApi.getAllStatesMetadata());

        return stateMetadataRepository.saveAll(stateMetadata);
    }
}
