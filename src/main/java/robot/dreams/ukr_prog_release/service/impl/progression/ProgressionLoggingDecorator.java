package robot.dreams.ukr_prog_release.service.impl.progression;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import robot.dreams.ukr_prog_release.models.entity.Progression;
import robot.dreams.ukr_prog_release.service.RepositoryService;

@Service
@RequiredArgsConstructor
@Primary
@Slf4j
public class ProgressionLoggingDecorator implements RepositoryService<Progression> {
    private final RepositoryService<Progression> repositoryService;

    @Override
    public Progression save(Progression entity) {
        Progression save = repositoryService.save(entity);
        log.info("Progression saved: " + entity);
        return save;
    }

    @Override
    public Progression update(Progression entity) {
        Progression update = repositoryService.update(entity);
        log.info("Progression updated: " + entity);
        return update;
    }

    @Override
    public void delete(Long id) {
        repositoryService.delete(id);
        log.info("Progression deleted: " + id);
    }

    @Override
    public Progression get(Long id) {
        Progression entity = repositoryService.get(id);
        log.info("Progression get: " + entity);
        return entity;
    }

    @Override
    public Iterable<Progression> getAll() {
        Iterable<Progression> entities = repositoryService.getAll();
        log.info("Progression get all: " + entities);
        return entities;
    }
}
