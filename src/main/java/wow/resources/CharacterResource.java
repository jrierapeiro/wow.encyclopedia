package wow.resources;

import wow.api.Character;
import wow.client.BattleNetClient;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.Optional;

@Path("/character/{realm}/{characterName}")
@Produces(MediaType.APPLICATION_JSON)
public class CharacterResource {
    private final Map<String, Map<String, String>> urlsConfiguration;
    private final BattleNetClient battleNetClient;

    public CharacterResource(Map<String, Map<String, String>> urlsConfiguration, BattleNetClient battleNetClient) {
        this.urlsConfiguration = urlsConfiguration;
        this.battleNetClient = battleNetClient;
    }

    @GET
    @Timed
    public Character getCharacter(@PathParam("realm") String realm, @PathParam("characterName") String characterName,  @QueryParam("locale") Optional<String> locale) {
        // https://eu.api.battle.net/wow/character/dun%20modr/kalitus?locale=en_GB&apikey=rhmt4p8kgq6s5uygr4y477vajrsep4rs
        final String definedLocale =  locale.orElse("en_GB");
        return battleNetClient.getCharacterData(realm, characterName, definedLocale);
    }
}