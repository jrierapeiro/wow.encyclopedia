package wow.client;

import wow.api.Character;

import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;

import java.util.Map;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class BattleNetClient {
    private final Map<String, String> battleNetApiConfiguration;

    public BattleNetClient(Map<String, String> battleNetApiConfiguration) {
        this.battleNetApiConfiguration = battleNetApiConfiguration;
    }

    public Character getCharacterData(String realm, String characterName, String locale){
        // https://eu.api.battle.net/wow/character/dun%20modr/kalitus?locale=en_GB&apikey=rhmt4p8kgq6s5uygr4y477vajrsep4rs
        final JerseyClient client = new JerseyClientBuilder().createClient();

        final String url = String.format("%s/character/%s/%s?locale=%s&apikey=%s",
                this.battleNetApiConfiguration.get("url"),
                realm,
                characterName,
                locale,
                this.battleNetApiConfiguration.get("key")
                );

        WebTarget webTarget = client.target(url);
        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        return response.readEntity(Character.class);
    }
}
