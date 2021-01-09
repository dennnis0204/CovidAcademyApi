package pl.sdaacademy.covidacademyapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.covidacademyapi.model.StateMetadata;
import pl.sdaacademy.covidacademyapi.model.StateStats;
import pl.sdaacademy.covidacademyapi.service.AllStatesService;

import java.util.List;

@RestController
@RequestMapping("/states")
public class AllStatesController {

    private final AllStatesService allStatesService;

    public AllStatesController(AllStatesService allStatesService) {
        this.allStatesService = allStatesService;
    }

    @GetMapping("/stats")
    public StateStats[] getCurrentStatesStats() {

        return allStatesService.getAllStatesCurrentStats();
    }

    @GetMapping("/metadata")
    public List<StateMetadata> getAllStatesMetadata() {

        return allStatesService.getAllStatesMetadata();
    }
}
