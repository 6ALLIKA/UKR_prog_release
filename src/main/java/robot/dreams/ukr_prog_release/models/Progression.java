package robot.dreams.ukr_prog_release.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import robot.dreams.ukr_prog_release.models.enums.Factor;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity(name = "progressions")
public class Progression {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "health_condition", columnDefinition = "int default 100")
    private Integer healthCondition;
    
    @Column(name = "work_degradation", columnDefinition = "int default 100")
    private Integer workDegradation;

    @Column(columnDefinition = "int default 0")
    private Integer progression;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Factor.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "configuration_factor", joinColumns = @JoinColumn(name = "configuration_id"))
    @Column(name = "factor", nullable = false)
    private Set<Factor> factors = new HashSet<>();
    
}
