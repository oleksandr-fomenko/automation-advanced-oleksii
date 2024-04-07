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

    @Config.Key("env.username.1")
    String testUsername1();

    @Config.Key("env.user.password.1")
    String testUserPassword1();

    @Config.Key("env.username.2")
    String testUsername2();

    @Config.Key("env.user.password.2")
    String testUserPassword2();

    @Config.Key("env.username.3")
    String testUsername3();

    @Config.Key("env.user.password.3")
    String testUserPassword3();

    @Config.Key("env.username.4")
    String testUsername4();

    @Config.Key("env.user.password.4")
    String testUserPassword4();

    @Config.Key("env.username.5")
    String testUsername5();

    @Config.Key("env.user.password.5")
    String testUserPassword5();

    @Config.Key("env.access.token")
    String accessToken();

    @Config.Key("page.load.timeout")
    Long pageLoadTimeout();

    @Config.Key("general.timeout")
    Long generalTimeout();
}
