package robot.dreams.ukr_prog_release.service.impl.factors;

import robot.dreams.ukr_prog_release.models.entity.Programmer;
import robot.dreams.ukr_prog_release.service.FactorService;

import java.time.LocalDateTime;

public abstract class EndGameFactor implements FactorService {
    private LocalDateTime lastTime = null;

    @Override
    public boolean step(Programmer programmer, LocalDateTime now) {
        if (isProceed(programmer.getConfiguration())) {
            throw new RuntimeException("End game");
        }
        return true;
    }
}
