package robot.dreams.ukr_prog_release.service.impl.factors;

import org.springframework.stereotype.Component;
import robot.dreams.ukr_prog_release.models.enums.Factor;
import robot.dreams.ukr_prog_release.service.FactorService;

@Component
public class TurnLightFactor extends DurationFactor implements FactorService {

    @Override
    public Factor factor() {
        return Factor.TURN_LIGHT;
    }
}
