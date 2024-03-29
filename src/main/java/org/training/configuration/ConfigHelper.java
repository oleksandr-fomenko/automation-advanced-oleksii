package org.training.configuration;

import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigCache;
import org.training.utils.EncryptionService;

import static com.codeborne.selenide.Configuration.pageLoadTimeout;


public class ConfigHelper {

    private final GeneralConfig config;
    EncryptionService encrypter;

    @SneakyThrows
    public ConfigHelper() {
        config = ConfigCache.getOrCreate(GeneralConfig.class);
        encrypter = new EncryptionService(System.getenv("ENCRYPT_KEY"));
    }

    public String getBaseUrl() {
        return config.baseUrl();
    }

    public String getProjectName() {
        return config.projectName();
    }

    public String getTestUsername() {
        return config.testUsername();
    }

    @SneakyThrows
    public String getTestUserPassword() {
        return encrypter.decrypt(config.testUserPassword());
    }

    @SneakyThrows
    public String getAccessToken() {
        return encrypter.decrypt(config.accessToken());
    }

    public void setUpSelenide() {
        pageLoadTimeout = getPageLoadTimeout();
    }

    public Long getPageLoadTimeout() {
        return config.pageLoadTimeout();
    }
}
