package robot.dreams.ukr_prog_release.service.impl.factors;

import robot.dreams.ukr_prog_release.models.entity.Configuration;
import robot.dreams.ukr_prog_release.models.entity.Programmer;
import robot.dreams.ukr_prog_release.models.enums.Factor;
import robot.dreams.ukr_prog_release.service.FactorService;

import java.time.LocalDateTime;
import java.util.Set;

public abstract class DurationFactor implements FactorService {
    private LocalDateTime lastTime = null;

    @Override
    public boolean step(Programmer programmer, LocalDateTime now) {
        Configuration configuration = programmer.getConfiguration();
        Set<Factor> factors = programmer.getProgression().getFactors();
        boolean timedFactor = factors.contains(factor());
        if (lastTime != null && now.minusHours(factor().getDuration().getHour()).isAfter(lastTime)) {
            lastTime = null;
            return true;
        }
        if (isProceed(configuration)) {
            if (timedFactor) {
                lastTime = null;
                factors.remove(factor());
                return true;
            } else {
                lastTime = now;
                factors.add(factor());
                return false;
            }
        } else {
            int random = 5;
            while (timedFactor && random > 0) {
                random--;
                boolean proceed = isProceed(configuration);
                if (proceed) {
                    lastTime = null;
                    factors.remove(factor());
                    return true;
                }
            }

        }
        return !timedFactor;
    }
}
