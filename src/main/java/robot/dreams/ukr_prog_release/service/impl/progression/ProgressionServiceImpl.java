package robot.dreams.ukr_prog_release.service.impl.progression;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import robot.dreams.ukr_prog_release.dao.ProgressionRepository;
import robot.dreams.ukr_prog_release.exception.AppNotFound;
import robot.dreams.ukr_prog_release.models.entity.Progression;
import robot.dreams.ukr_prog_release.service.RepositoryService;

@Service
@RequiredArgsConstructor
@Slf4j
@Qualifier("configurationService")
public class ProgressionServiceImpl implements RepositoryService<Progression> {

    private final ProgressionRepository configurationRepository;

    @Override
    public Progression save(Progression entity) {
        return configurationRepository.save(entity);
    }

    @Override
    public Progression update(Progression entity) {
        return configurationRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        configurationRepository.deleteById(id);
    }

    @Override
    public Progression get(Long id) {
        return configurationRepository.findById(id).orElseThrow(() -> new AppNotFound("Progression not found"));
    }

    @Override
    public Iterable<Progression> getAll() {
        return configurationRepository.findAll();
    }
}
