package robot.dreams.ukr_prog_release.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import robot.dreams.ukr_prog_release.models.enums.Difficulty;
import robot.dreams.ukr_prog_release.models.enums.Level;

@Getter
@Setter
@ToString
@Entity(name = "configurations")
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", nullable = false)
    private Level developerLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficult", nullable = false)
    private Difficulty difficultyLevel;

    @Column(name = "deadline_days")
    private Long deadlineDays;
}
