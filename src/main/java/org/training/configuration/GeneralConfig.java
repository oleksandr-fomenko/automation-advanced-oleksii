package org.training.configuration;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:${env}/application.properties",
        "classpath:${env}/selenide.properties"
})
public interface GeneralConfig extends Config {
    @Config.Key("env.url")
    String baseUrl();

    @Config.Key("env.project.name")
    String projectName();

    @Config.Key("env.username")
    String testUsername();

    @Config.Key("env.user.password")
    String testUserPassword();

    @Config.Key("env.access.token")
    String accessToken();

    @Config.Key("page.load.timeout")
    Long pageLoadTimeout();
}
