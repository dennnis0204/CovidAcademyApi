package pl.sdaacademy.covidacademyapi.states_stats.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.sdaacademy.covidacademyapi.model.StateCurrentStats;

@Repository
public class CovidTrackingApiRepository implements CovidTrackingApi {

    private final String url;

    private final RestTemplate restTemplate;

    public CovidTrackingApiRepository(@Value("${covidtrackingapi.url}") String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    @Override
    public StateCurrentStats[] getAllStatesCurrentStats() {
        return restTemplate.getForObject(url, StateCurrentStats[].class);
    }
}
