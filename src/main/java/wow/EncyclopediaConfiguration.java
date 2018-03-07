package wow;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import java.util.Collections;
import java.util.Map;

public class EncyclopediaConfiguration extends Configuration {
    @NotNull
    private Map<String, Map<String, String>> urlsConfiguration = Collections.emptyMap();

    @JsonProperty("urlsConfiguration")
    public Map<String, Map<String, String>> getUrlsConfiguration() {
        return urlsConfiguration;
    }

    @JsonProperty("urlsConfiguration")
    public void setUrlsConfiguration(Map<String, Map<String, String>> urlsConfiguration) {
        final ImmutableMap.Builder<String, Map<String, String>> builder = ImmutableMap.builder();
        for (Map.Entry<String, Map<String, String>> entry : urlsConfiguration.entrySet()) {
            builder.put(entry.getKey(), ImmutableMap.copyOf(entry.getValue()));
        }
        this.urlsConfiguration = builder.build();
    }
}
