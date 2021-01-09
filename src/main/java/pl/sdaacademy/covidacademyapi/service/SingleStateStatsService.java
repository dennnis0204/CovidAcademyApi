package pl.sdaacademy.covidacademyapi.service;

import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.exception.NoSuchStateNameException;
import pl.sdaacademy.covidacademyapi.model.StateMetadata;
import pl.sdaacademy.covidacademyapi.model.StateStats;
import pl.sdaacademy.covidacademyapi.model.StateStatsDto;
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

    public StateStatsDto getStateCurrentStats(String state, String date) {

        if (stateMetadataRepository.count() == 0) {
            allStatesService.getAllStatesMetadata();
        }

        Optional<StateMetadata> stateMetadata = stateMetadataRepository.findFirstByNameIgnoreCase(state);

        if (stateMetadata.isEmpty()) {
            throw new NoSuchStateNameException("Bad state name, check your url address!");
        }

        String stateAcronym = stateMetadata.get().getState();

        StateStats singleStateStats = covidTrackingApi.getSingleStateStats(stateAcronym, date);

        return mapToStateStatsDto(singleStateStats);
    }

    private StateStatsDto mapToStateStatsDto(StateStats stateStats) {
        StateStatsDto stateStatsDto = new StateStatsDto();
        stateStatsDto.setState(stateStats.getState());
        stateStatsDto.setDateChecked(stateStats.getDateChecked());
        stateStatsDto.setNegative(stateStats.getNegative());
        stateStatsDto.setPositive(stateStats.getPositive());
        stateStatsDto.setDeathConfirmed(stateStats.getDeathConfirmed());
        stateStatsDto.setRecovered(stateStats.getRecovered());
        return stateStatsDto;
    }
}
