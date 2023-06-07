package com.saucedemo.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties"
})

public interface AuthorizationConfig extends Config {
    @Key("login")
    String login();

    @Key("password")
    String password();
}
