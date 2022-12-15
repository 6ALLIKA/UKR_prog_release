package robot.dreams.ukr_prog_release.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import robot.dreams.ukr_prog_release.models.entity.Programmer;

public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {

}
