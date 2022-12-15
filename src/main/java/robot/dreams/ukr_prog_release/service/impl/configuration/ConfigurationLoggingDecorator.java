package robot.dreams.ukr_prog_release.service.impl.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import robot.dreams.ukr_prog_release.models.entity.Configuration;
import robot.dreams.ukr_prog_release.service.RepositoryService;

@Service
@RequiredArgsConstructor
@Primary
@Slf4j
public class ConfigurationLoggingDecorator implements RepositoryService<Configuration> {
    private final RepositoryService<Configuration> repositoryService;

    @Override
    public Configuration save(Configuration entity) {
        Configuration save = repositoryService.save(entity);
        log.info("Configuration saved: " + entity);
        return save;
    }

    @Override
    public Configuration update(Configuration entity) {
        Configuration update = repositoryService.update(entity);
        log.info("Configuration updated: " + entity);
        return update;
    }

    @Override
    public void delete(Long id) {
        repositoryService.delete(id);
        log.info("Configuration deleted: " + id);
    }

    @Override
    public Configuration get(Long id) {
        Configuration entity = repositoryService.get(id);
        log.info("Configuration get: " + entity);
        return entity;
    }

    @Override
    public Iterable<Configuration> getAll() {
        Iterable<Configuration> entities = repositoryService.getAll();
        log.info("Configuration get all: " + entities);
        return entities;
    }
}
