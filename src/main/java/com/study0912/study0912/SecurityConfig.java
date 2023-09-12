package com.study0912.study0912;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
            //SecurityContext를 명시적으로 저장하게 한다.
            .securityContext(securityContext -> securityContext
                .requireExplicitSave(true))
            .csrf(c->c.disable())
            .cors(c->c.disable())
            .authorizeHttpRequests(authorize -> authorize
                .anyRequest().authenticated())
            .formLogin(config->config
                .loginPage("/login/")   
                .permitAll())
            ;

        return http.build();
    }

}
