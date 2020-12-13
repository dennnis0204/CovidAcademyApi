package pl.sdaacademy.covidacademyapi.all_states_metadata;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.covidacademyapi.model.StateMetadata;

@RestController
@RequestMapping("/states/metadata")
public class AllStatesMetadataController {

    private final AllStatesMetadataService allStatesMetadataService;

    public AllStatesMetadataController(AllStatesMetadataService allStatesMetadataService) {
        this.allStatesMetadataService = allStatesMetadataService;
    }

    @GetMapping
    public StateMetadata[] getAllStatesMetadata() {
        return allStatesMetadataService.getAllStatesMetadata();
    }
}
