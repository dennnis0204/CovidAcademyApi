package pl.sdaacademy.covidacademyapi.single_state_stats.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.sdaacademy.covidacademyapi.model.StateCurrentStats;

@Repository
public class SingleStateCovidTrackingApiRepository implements SingleStateCovidTrackingApi {

    private final String url;

    private final RestTemplate restTemplate;

    public SingleStateCovidTrackingApiRepository(@Value("${singlestatecovidtrackingapi.url}") String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    @Override
    public StateCurrentStats getStateCurrentStats(String state) {

        String requestUrl = String.format(url, state);

        return restTemplate.getForObject(requestUrl, StateCurrentStats.class);
    }
}
