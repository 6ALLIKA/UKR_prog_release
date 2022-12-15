package robot.dreams.ukr_prog_release.service.impl.factors;

import lombok.RequiredArgsConstructor;
import org.jline.reader.LineReader;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import robot.dreams.ukr_prog_release.models.enums.Factor;
import robot.dreams.ukr_prog_release.service.FactorService;

@Component
@RequiredArgsConstructor
public class DehydrationFactor extends HealthFactor implements FactorService {

    @Lazy
    private final LineReader reader;

    @Override
    public Factor factor() {
        return Factor.DEHYDRATION;
    }

    @Override
    protected String ask() {
        return this.reader.readLine("\n" + "You are dehydrated. Do you want to drink something? (y/n)" + " > ");
    }
}
