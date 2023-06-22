package ernestui.usermanagement.utility;


import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
@EnableScheduling
public class ScheduleUtility {
    private final LoggerService logger;

    public ScheduleUtility(LoggerService logger) {
        this.logger = logger;

    }

    @Scheduled(fixedDelay = 1000, initialDelay = 5000)
    public void runScheduledService(){

    }

    @Scheduled(fixedDelay = 1000, initialDelay = 5000)
    public void processReceivedBatch(){

    }
}
