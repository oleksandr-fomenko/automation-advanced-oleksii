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

    public String getTestUsername1() {
        return config.testUsername1();
    }

    @SneakyThrows
    public String getTestUserPassword1() {
        return encrypter.decrypt(config.testUserPassword1());
    }

    public String getTestUsername2() {
        return config.testUsername2();
    }

    @SneakyThrows
    public String getTestUserPassword2() {
        return encrypter.decrypt(config.testUserPassword2());
    }

    public String getTestUsername3() {
        return config.testUsername3();
    }

    @SneakyThrows
    public String getTestUserPassword3() {
        return encrypter.decrypt(config.testUserPassword3());
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
