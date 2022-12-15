package robot.dreams.ukr_prog_release.service.impl.factors;

import robot.dreams.ukr_prog_release.models.entity.Configuration;
import robot.dreams.ukr_prog_release.models.entity.Programmer;
import robot.dreams.ukr_prog_release.models.enums.Factor;
import robot.dreams.ukr_prog_release.service.FactorService;

import java.time.LocalDateTime;
import java.util.Set;

public abstract class HealthFactor implements FactorService {

    @Override
    public boolean step(Programmer programmer, LocalDateTime now) {
        Configuration configuration = programmer.getConfiguration();
        Set<Factor> factors = programmer.getProgression().getFactors();
        boolean isNeedAttention = factors.contains(factor());
        if (isProceed(configuration)) {
            if (!isNeedAttention) {
                factors.add(factor());
                isNeedAttention = true;
            }
        }
        if (isNeedAttention) {
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
