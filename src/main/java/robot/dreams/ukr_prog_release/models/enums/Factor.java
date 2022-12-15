package robot.dreams.ukr_prog_release.models.enums;

import java.time.LocalTime;
import java.util.Random;

public enum Factor implements Duration, Chance, Controlled {
    TURN_LIGHT(LocalTime.of(5,0), 0.5, false),
    HUNGRY(null, 0.2, false),
    DEHYDRATION(null, 0.2, false),
    SLEEP(LocalTime.of(8,0), 0.05, false),
    ROCKET_ALERT(LocalTime.of(Constants.random.nextInt(5), Constants.random.nextInt(60)), 0.1, false),
    PROD_BUG(LocalTime.of(Constants.random.nextInt(5), Constants.random.nextInt(60)), 0.05, true),
    ROCKET(null, 0.001, false),
    DISMISSAL(null, 0.01, true),
    ;

    private final LocalTime duration;
    private final Double chance;
    private final boolean controlled;

    Factor(LocalTime duration, Double chance, boolean controlled) {
        this.duration = duration;
        this.chance = chance;
        this.controlled = controlled;
    }

    @Override
    public LocalTime getDuration() {
        return duration;
    }

    @Override
    public Double getChance() {
        return chance;
    }

    @Override
    public boolean isControlled() {
        return controlled;
    }

    private static class Constants {
        private static final Random random = new Random();
    }
}
