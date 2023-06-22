package ernestui.usermanagement.utility;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;
import ernestui.usermanagement.configuration.application.ApplicationConfiguration;
import ernestui.usermanagement.configuration.database.DatabaseRepository;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.RequestBody;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.DeserializationFeature;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class UtilityService {

    private final LoggerService logger;
    private final DatabaseRepository database;
    private final DateUtility dateUtility;
    private final ApplicationConfiguration configuration;
    private final Gson jsonProcessor;
    private final HttpService httpService;
    private final StringUtility stringUtility;

    private static final String JSON_FILE_PATH = "data.json";


    public UtilityService(LoggerService logger, DatabaseRepository database, DateUtility dateUtility, ApplicationConfiguration configuration, Gson jsonProcessor, HttpService httpService, StringUtility stringUtility) {
        this.logger = logger;
        this.database = database;
        this.dateUtility = dateUtility;
        this.configuration = configuration;
        this.jsonProcessor = jsonProcessor;
        this.httpService = httpService;
        this.stringUtility = stringUtility;

    }

    public StringUtility getStringUtility() {
        return stringUtility;
    }

    public ApplicationConfiguration getConfiguration() {
        return configuration;
    }

    public LoggerService getLogger() {
        return logger;
    }

    public DatabaseRepository getDatabase() {
        return database;
    }

    public DateUtility getDateUtility() {
        return dateUtility;
    }

    public Gson getJsonProcessor() {
        return jsonProcessor;
    }

    public HttpService getHttpService() {
        return httpService;
    }

    public JsonMapper jsonMapper() {
        JsonMapper jsonMapper = new JsonMapper();
        jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return jsonMapper;
    }

    public String generateUniqueId() {
        return dateUtility.generateTimePrefix() + stringUtility.randomString();
    }

    public String cleanAccount(String acc) {
        if (StringUtils.substring(acc, 2, 3).equals("1")) {
            String start = StringUtils.substring(acc, 0, 2);
            String end = StringUtils.substring(acc, 3);
            return start + "J" + end;
        }
        return acc;
    }

    public String getTokenForEsbAccess() {
        RequestBody requestBody = new FormBody.Builder()
                .add("grant_type", "client_credentials")
                .add("scope", "common")
                .build();
        String type = "application/x-www-form-urlencoded";
        String token = getConfiguration().getConstant("token_token");
        String cookie = getConfiguration().getConstant("token_cookie");

        Headers headers = new Headers.Builder()
                .add("Content-Type", type)
                .add("Cookie", cookie)
                .add("Authorization", "Basic" + " " + token)
                .build();

        // You need to change api Endpoint
        String url = getConfiguration().getConstant("token_url");

        return getHttpService().getTokenProcessor(requestBody, headers, url);
    }
}
