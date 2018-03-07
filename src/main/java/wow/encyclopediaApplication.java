package wow;

import wow.health.ConfigurationHealthCheck;
import wow.resources.CharacterResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class encyclopediaApplication extends Application<encyclopediaConfiguration> {

    public static void main(final String[] args) throws Exception {
        new encyclopediaApplication().run(args);
    }

    @Override
    public String getName() {
        return "encyclopedia";
    }

    @Override
    public void initialize(final Bootstrap<encyclopediaConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final encyclopediaConfiguration configuration,
                    final Environment environment) {

        final CharacterResource characterResource = new CharacterResource(
                configuration.getUrlsConfiguration()
        );

        final ConfigurationHealthCheck healthCheck = new ConfigurationHealthCheck(
                configuration.getUrlsConfiguration()
        );

        environment.healthChecks().register("urlsConfiguration", healthCheck);
        environment.jersey().register(characterResource);
    }

}
