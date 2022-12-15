package robot.dreams.ukr_prog_release.service.impl.programmer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import robot.dreams.ukr_prog_release.models.entity.Programmer;
import robot.dreams.ukr_prog_release.service.RepositoryService;

@Service
@RequiredArgsConstructor
@Primary
@Slf4j
public class ProgrammerLoggingDecorator implements RepositoryService<Programmer> {
    private final RepositoryService<Programmer> repositoryService;

    @Override
    public Programmer save(Programmer entity) {
        Programmer save = repositoryService.save(entity);
        log.info("Programmer saved: " + entity);
        return save;
    }

    @Override
    public Programmer update(Programmer entity) {
        Programmer update = repositoryService.update(entity);
        log.info("Programmer updated: " + entity);
        return update;
    }

    @Override
    public void delete(Long id) {
        repositoryService.delete(id);
        log.info("Programmer deleted: " + id);
    }

    @Override
    public Programmer get(Long id) {
        Programmer entity = repositoryService.get(id);
        log.info("Programmer get: " + entity);
        return entity;
    }

    @Override
    public Iterable<Programmer> getAll() {
        Iterable<Programmer> entities = repositoryService.getAll();
        log.info("Programmer get all: " + entities);
        return entities;
    }
}
