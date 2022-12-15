package robot.dreams.ukr_prog_release.models.enums;

public enum Difficulty implements Coefficient {
    EASY(1.0),
    MEDIUM(0.7),
    HARD(0.5),
    EXPERT(0.3)
    ;

    private final Double coefficient;

    Difficulty(Double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public Double getCoefficient() {
        return coefficient;
    }
}
