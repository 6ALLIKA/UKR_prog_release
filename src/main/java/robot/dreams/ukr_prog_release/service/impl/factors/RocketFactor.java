package robot.dreams.ukr_prog_release.service.impl.factors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import robot.dreams.ukr_prog_release.models.enums.Factor;
import robot.dreams.ukr_prog_release.service.FactorService;

@Component
@RequiredArgsConstructor
public class RocketFactor extends EndGameFactor implements FactorService {

    @Override
    public Factor factor() {
        return Factor.ROCKET;
    }
}
