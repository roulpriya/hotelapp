package com.example.hotelreview;


import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class HealthMetrics extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

        if (true) {

            builder.up()
                    .withDetail("app", "Alive and Kicking")
                    .withDetail("error", "Nothing! I'm good.");
        } else {

            builder.down()
                    .withDetail("app", "Not Alive");
        }
    }
}
