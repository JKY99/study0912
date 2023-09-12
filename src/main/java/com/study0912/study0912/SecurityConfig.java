package com.study0912.study0912;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    

    public SecurityFilterChain filterChain(HttpSecurity http, final AuthenticationConfiguration authenticationConfiguration) throws Exception{
        http
            .csrf(c->c.disable())
            .cors(c->c.disable())
            .formLogin(config->config
                .permitAll())
            ;


        return http.build();
    }

}
