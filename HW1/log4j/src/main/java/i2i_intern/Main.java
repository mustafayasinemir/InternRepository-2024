package i2i_intern;
import java.time.LocalDateTime;
import java.time.ZoneId;


public class Main {

    public static void main(String[] args) {
            myTimerLoggings logger = new myTimerLoggings();
            LocalDateTime previousTime = LocalDateTime.now(ZoneId.of("Europe/Istanbul"));

            for (int i = 0; i < 18000; i++) {
                LocalDateTime currentTime = LocalDateTime.now(ZoneId.of("Europe/Istanbul"));

                logger.debug(String.format("%02d:%02d:%02d", currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond()));

                if (currentTime.getMinute() != previousTime.getMinute()) {
                    logger.info(String.format("%02d:%02d:%02d", currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond()));
                }

                if (currentTime.getHour() != previousTime.getHour()) {
                    logger.error(String.format("%02d:%02d:%02d", currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond()));
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                previousTime = currentTime;
            }

        }
    }
