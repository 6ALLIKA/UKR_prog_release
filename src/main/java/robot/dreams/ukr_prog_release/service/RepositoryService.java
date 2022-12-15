package robot.dreams.ukr_prog_release.service;

import org.springframework.transaction.annotation.Transactional;

public interface RepositoryService<T> {

    @Transactional
    T save(T entity);

    @Transactional
    T update(T entity);

    @Transactional
    void delete(Long id);

    @Transactional(readOnly = true)
    T get(Long id);

    @Transactional(readOnly = true)
    Iterable<T> getAll();
}
