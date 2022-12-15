package robot.dreams.ukr_prog_release.models.enums;

public enum Level implements Coefficient {
    JUNIOR(0.5),
    MIDDLE(1.0),
    SENIOR(2.0);

    private final Double coefficient;

    Level(Double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public Double getCoefficient() {
        return coefficient;
    }
}
