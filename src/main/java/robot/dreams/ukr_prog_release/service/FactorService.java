package robot.dreams.ukr_prog_release.service;

import robot.dreams.ukr_prog_release.models.entity.Configuration;
import robot.dreams.ukr_prog_release.models.entity.Programmer;
import robot.dreams.ukr_prog_release.models.enums.Factor;
import robot.dreams.ukr_prog_release.models.enums.Level;

import java.time.LocalDateTime;
import java.util.Random;

public interface FactorService {
    Random RANDOM = new Random();
    int CHANCE_RANGE = 100;

    Factor factor();

    default boolean isProceed(Configuration configuration) {
        int chance = CHANCE_RANGE;
        double diapason = calculateDiapason(configuration, chance);
//        System.out.println(factor() + " " + diapason);
        double startPosition = RANDOM.nextDouble(0, chance - diapason);
        double chancePosition = RANDOM.nextDouble(0, CHANCE_RANGE);
        return chancePosition > startPosition && chancePosition < startPosition + diapason;
    }

    private double calculateDiapason(Configuration configuration, int chance) {
        return chance * factor().getChance() *
                getLevelDependOnFactor(factor(), configuration.getDeveloperLevel())
                * configuration.getDifficultyLevel().getCoefficient();
    }

    private double getLevelDependOnFactor(Factor factor, Level level) {
        return factor.isControlled() ? 1 : level.getCoefficient();
    }

    boolean step(Programmer programmer, LocalDateTime now);
}
