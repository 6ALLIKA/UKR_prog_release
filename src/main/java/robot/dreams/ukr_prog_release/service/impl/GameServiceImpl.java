package robot.dreams.ukr_prog_release.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import robot.dreams.ukr_prog_release.models.Programmer;
import robot.dreams.ukr_prog_release.service.GameService;
import robot.dreams.ukr_prog_release.service.RepositoryService;
import robot.dreams.ukr_prog_release.service.FactorService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final RepositoryService<Programmer> repositoryService;
    private final List<FactorService> factorServices;


    @Transactional(readOnly = true)
    @Override
    public void startGame(Long id) {
        Programmer programmer = repositoryService.get(id);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusDays(programmer.getConfiguration().getDeadlineDays());
        do {
            now = pastHour(programmer, now);
        } while (now.isBefore(end));
        if (programmer.getProgression().getProgression() >= 100) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
    }

    private LocalDateTime pastHour(Programmer programmer, LocalDateTime now) {
        boolean step = true;
        for (FactorService factorService : factorServices) {
            if (!factorService.step(programmer, now)) {
                step = false;
            }
        }
        now = now.plusHours(1);
        if (step) {
            programmer.getProgression().setProgression(programmer.getProgression().getProgression() + 1);
        }
        String format = String.format("Progression: [%-50s]", buildString('=', programmer.getProgression().getProgression() / 2));
        System.out.println(format);
        return now;
    }

    private String buildString(char c, int n) {
        char[] arr = new char[n];
        Arrays.fill(arr, c);
        return new String(arr);
    }
}
