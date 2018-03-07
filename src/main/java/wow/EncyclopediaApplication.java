package wow;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import wow.client.BattleNetClient;
import wow.health.ConfigurationHealthCheck;
import wow.resources.CharacterResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class EncyclopediaApplication extends Application<EncyclopediaConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EncyclopediaApplication().run(args);
    }

    @Override
    public String getName() {
        return "encyclopedia";
    }

    @Override
    public void initialize(final Bootstrap<EncyclopediaConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final EncyclopediaConfiguration configuration,
                    final Environment environment) {

        final JerseyClient client = JerseyClientBuilder.createClient();

        final BattleNetClient battleNetClient = new BattleNetClient(
                configuration.getUrlsConfiguration().get("battleNetApi"),
                client
        );

        final CharacterResource characterResource = new CharacterResource(
                configuration.getUrlsConfiguration(),
                battleNetClient
        );

        final ConfigurationHealthCheck healthCheck = new ConfigurationHealthCheck(
                configuration.getUrlsConfiguration()
        );

        environment.healthChecks().register("urlsConfiguration", healthCheck);
        environment.jersey().register(characterResource);
    }

}
