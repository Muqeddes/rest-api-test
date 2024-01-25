package apiutilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadUtilities {
    AppConfig appConfig;
    UserPayload userPayload;
    ObjectMapper objectMapper;

    public String getUserPayload() {
        String payload = null;
        objectMapper = new ObjectMapper();
        appConfig = new AppConfig();

        userPayload = new UserPayload(Integer.parseInt(appConfig.readFromConfig("id")), appConfig.readFromConfig("username"), appConfig.readFromConfig("firstName"), appConfig.readFromConfig("lastName"), appConfig.readFromConfig("email"), appConfig.readFromConfig("password"), appConfig.readFromConfig("phone"), Integer.parseInt(appConfig.readFromConfig("userStatus")));

        try {
            payload = objectMapper.writeValueAsString(userPayload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return payload;


    }


}
