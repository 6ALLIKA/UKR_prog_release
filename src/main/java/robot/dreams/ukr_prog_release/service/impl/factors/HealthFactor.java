package robot.dreams.ukr_prog_release.service.impl.factors;

import robot.dreams.ukr_prog_release.models.Configuration;
import robot.dreams.ukr_prog_release.models.Programmer;
import robot.dreams.ukr_prog_release.models.enums.Factor;
import robot.dreams.ukr_prog_release.service.FactorService;

import java.time.LocalDateTime;
import java.util.Set;

public abstract class HealthFactor implements FactorService {
    private LocalDateTime lastTime = null;

    @Override
    public boolean step(Programmer programmer, LocalDateTime now) {
        Configuration configuration = programmer.getConfiguration();
        Set<Factor> factors = programmer.getProgression().getFactors();
        boolean isHungry = factors.contains(factor());
        if (isProceed(configuration)) {
            if (!isHungry) {
                factors.add(factor());
                isHungry = true;
            }
        }
        if (isHungry) {
            boolean eat = ask(factors);
            if (!eat) {
                programmer.getProgression().setHealthCondition(programmer.getProgression().getHealthCondition() - 1);
            } else {
                programmer.getProgression().setHealthCondition(programmer.getProgression().getHealthCondition() + 4);
            }
            return eat;
        }
        return true;
    }
    private boolean ask(Set<Factor> factors) {
        String answer = ask();
        while (answer == null || (!answer.equals("y") && !answer.equals("n"))) {
            answer = ask();
        }
        if (answer.equals("y")) {
            factors.remove(factor());
            return true;
        } else {
            return false;
        }
    }
    protected abstract String ask();
}
