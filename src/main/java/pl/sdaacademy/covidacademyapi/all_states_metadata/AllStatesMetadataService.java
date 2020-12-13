package pl.sdaacademy.covidacademyapi.all_states_metadata;

import org.springframework.stereotype.Service;
import pl.sdaacademy.covidacademyapi.model.StateMetadata;
import pl.sdaacademy.covidacademyapi.repository.CovidTrackingApi;

@Service
public class AllStatesMetadataService {

    private final CovidTrackingApi covidTrackingApi;

    public AllStatesMetadataService(CovidTrackingApi covidTrackingApi) {
        this.covidTrackingApi = covidTrackingApi;
    }

    public StateMetadata[] getAllStatesMetadata() {
        return covidTrackingApi.getAllStatesMetadata();
    }
}
