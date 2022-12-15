package robot.dreams.ukr_prog_release.service.impl.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import robot.dreams.ukr_prog_release.dao.ConfigurationRepository;
import robot.dreams.ukr_prog_release.exception.AppNotFound;
import robot.dreams.ukr_prog_release.models.entity.Configuration;
import robot.dreams.ukr_prog_release.service.RepositoryService;

@Service
@RequiredArgsConstructor
@Slf4j
@Qualifier("configurationService")
public class ConfigurationServiceImpl implements RepositoryService<Configuration> {

    private final ConfigurationRepository configurationRepository;

    @Override
    public Configuration save(Configuration entity) {
        return configurationRepository.save(entity);
    }

    @Override
    public Configuration update(Configuration entity) {
        return configurationRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        configurationRepository.deleteById(id);
    }

    @Override
    public Configuration get(Long id) {
        return configurationRepository.findById(id).orElseThrow(() -> new AppNotFound("Configuration not found"));
    }

    @Override
    public Iterable<Configuration> getAll() {
        return configurationRepository.findAll();
    }
}
