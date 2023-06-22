package ernestui.usermanagement.configuration.application;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ernest Joseph Nzalawahe
 * @created 19/06/2023 - 12:39
 * @project user-management
 */
@Configuration
@ConfigurationProperties (prefix = "user.management")
@PropertySource ("classpath:application.properties")
public class ApplicationConfiguration {
    private final Map<String, String> constants = new HashMap<>();

    public Map<String, String> getConstants() {
        return constants;
    }

    public String getConstant(String key){
        return constants.get(key);
    }
}
