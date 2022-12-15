package robot.dreams.ukr_prog_release.service.impl.programmer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import robot.dreams.ukr_prog_release.dao.ProgrammerRepository;
import robot.dreams.ukr_prog_release.exception.AppNotFound;
import robot.dreams.ukr_prog_release.models.entity.Programmer;
import robot.dreams.ukr_prog_release.service.RepositoryService;

@Service
@RequiredArgsConstructor
@Log4j2
@Qualifier("programmerService")
public class ProgrammerServiceImpl implements RepositoryService<Programmer> {

    private final ProgrammerRepository programmerRepository;

    @Transactional
    @Override
    public Programmer save(Programmer entity) {
        return programmerRepository.save(entity);
    }

    @Transactional
    @Override
    public Programmer update(Programmer entity) {
        return programmerRepository.save(entity);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        programmerRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Programmer get(Long id) {
        return programmerRepository.findById(id).orElseThrow(() -> new AppNotFound("Programmer not found"));
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Programmer> getAll() {
        return programmerRepository.findAll();
    }
}
