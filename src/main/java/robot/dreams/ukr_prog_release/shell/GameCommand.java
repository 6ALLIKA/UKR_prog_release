package robot.dreams.ukr_prog_release.shell;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import robot.dreams.ukr_prog_release.models.entity.Configuration;
import robot.dreams.ukr_prog_release.models.entity.Programmer;
import robot.dreams.ukr_prog_release.models.entity.Progression;
import robot.dreams.ukr_prog_release.models.enums.Difficulty;
import robot.dreams.ukr_prog_release.models.enums.Level;
import robot.dreams.ukr_prog_release.service.GameService;
import robot.dreams.ukr_prog_release.service.RepositoryService;

@ShellComponent
@Slf4j
@RequiredArgsConstructor
public class GameCommand {
    private final RepositoryService<Programmer> programmerRepositoryService;
    private final RepositoryService<Progression> progressionRepositoryService;
    private final RepositoryService<Configuration> configurationRepositoryService;
    private final GameService gameService;

    @ShellMethod(value = "test")
    public void test() {
        Progression progression = new Progression();
        progressionRepositoryService.save(progression);
        Configuration configuration = new Configuration();
        configuration.setDeadlineDays(1L);
        configuration.setDeveloperLevel(Level.JUNIOR);
        configuration.setDifficultyLevel(Difficulty.EASY);
        configurationRepositoryService.save(configuration);
        Programmer programmer = new Programmer();
        programmer.setName("test");
        programmer.setConfiguration(configuration);
        programmer.setProgression(progression);
        programmerRepositoryService.save(programmer);
    }

    @ShellMethod(value = "start")
    public void start(Long id) {
        gameService.startGame(id);
    }

    @ShellMethod(value = "all")
    public void all() {
        Iterable<Programmer> all = programmerRepositoryService.getAll();
        System.out.println();
        System.out.println();
        System.out.println();
        all.forEach(System.out::println);
    }
}  