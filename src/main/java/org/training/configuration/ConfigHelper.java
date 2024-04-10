package org.training.configuration;

import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigCache;
import org.training.utils.EncryptionService;

import static com.codeborne.selenide.Configuration.pageLoadTimeout;
import static com.codeborne.selenide.Configuration.timeout;


public class ConfigHelper {

    private final GeneralConfig config;
    EncryptionService encrypter;

    @SneakyThrows
    public ConfigHelper() {
        config = ConfigCache.getOrCreate(GeneralConfig.class);
        encrypter = new EncryptionService(System.getProperty("ENCRYPT_KEY"));
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

    public String getTestUsername4() {
        return config.testUsername4();
    }

    @SneakyThrows
    public String getTestUserPassword4() {
        return encrypter.decrypt(config.testUserPassword4());
    }

    public String getTestUsername5() {
        return config.testUsername5();
    }

    @SneakyThrows
    public String getTestUserPassword5() {
        return encrypter.decrypt(config.testUserPassword5());
    }

    @SneakyThrows
    public String getAccessToken() {
        return encrypter.decrypt(config.accessToken());
    }

    public void setUpSelenide() {
        pageLoadTimeout = getPageLoadTimeout();
        timeout = getGeneralTimeout();
    }

    public Long getPageLoadTimeout() {
        return config.pageLoadTimeout();
    }

    public Long getGeneralTimeout() {
        return config.generalTimeout();
    }
}
