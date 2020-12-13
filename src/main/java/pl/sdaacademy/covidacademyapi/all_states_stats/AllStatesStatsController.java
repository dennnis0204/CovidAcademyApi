package pl.sdaacademy.covidacademyapi.all_states_stats;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.covidacademyapi.model.StateStats;

@RestController
@RequestMapping("/states")
public class AllStatesStatsController {

    private final AllStatesStatsService allStatesStatsService;


    public AllStatesStatsController(AllStatesStatsService allStatesStatsService) {
        this.allStatesStatsService = allStatesStatsService;
    }

    @GetMapping
    public StateStats[] getCurrentStatesStats() {
        return allStatesStatsService.getAllStatesCurrentStats();
    }
}
