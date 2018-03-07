package wow.client;

import wow.api.Character;

import org.glassfish.jersey.client.JerseyClient;

import java.util.Map;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class BattleNetClient {
    private final Map<String, String> battleNetApiConfiguration;
    private final JerseyClient client;

    public BattleNetClient(Map<String, String> battleNetApiConfiguration, JerseyClient client) {
        this.battleNetApiConfiguration = battleNetApiConfiguration;
        this.client = client;
    }

    public Character getCharacterData(String realm, String characterName, String locale){
        // https://eu.api.battle.net/wow/character/dun%20modr/kalitus?locale=en_GB&apikey=rhmt4p8kgq6s5uygr4y477vajrsep4rs
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
