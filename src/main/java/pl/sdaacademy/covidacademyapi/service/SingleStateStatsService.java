package pl.sdaacademy.covidacademyapi.service;

import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.exception.NoSuchStateNameException;
import pl.sdaacademy.covidacademyapi.model.StateMetadata;
import pl.sdaacademy.covidacademyapi.model.StateStats;
import pl.sdaacademy.covidacademyapi.repository.CovidTrackingApi;
import pl.sdaacademy.covidacademyapi.repository.StateMetadataRepository;

import java.util.Optional;

@Service
public class SingleStateStatsService {

    private final CovidTrackingApi covidTrackingApi;
    private final AllStatesService allStatesService;
    private final StateMetadataRepository stateMetadataRepository;


    public SingleStateStatsService(CovidTrackingApi covidTrackingApi, AllStatesService allStatesService, StateMetadataRepository stateMetadataRepository) {
        this.covidTrackingApi = covidTrackingApi;
        this.allStatesService = allStatesService;
        this.stateMetadataRepository = stateMetadataRepository;
    }

    public StateStats getStateCurrentStats(String state, String date) {

        if (stateMetadataRepository.count() == 0) {
            allStatesService.getAllStatesMetadata();
        }

        Optional<StateMetadata> stateMetadata = stateMetadataRepository.findFirstByNameIgnoreCase(state);

        if (stateMetadata.isEmpty()) {
            throw new NoSuchStateNameException("Bad state name, check your url address!");
        }

        String stateAcronym = stateMetadata.get().getState();

        return covidTrackingApi.getSingleStateStats(stateAcronym, date);
    }
}
