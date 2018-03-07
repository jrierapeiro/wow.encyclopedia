package wow.health;

import com.codahale.metrics.health.HealthCheck;
import java.util.Map;

public class ConfigurationHealthCheck extends HealthCheck {
    private final Map<String, Map<String, String>> urlsConfiguration;

    public ConfigurationHealthCheck(Map<String, Map<String, String>> urlsConfiguration) {
        this.urlsConfiguration = urlsConfiguration;
    }

    @Override
    protected Result check() {
        if (!urlsConfiguration.containsKey("battleNetApi")) {
            return Result.unhealthy("battleNetApi is not configured");
        }

        return Result.healthy();
    }
}