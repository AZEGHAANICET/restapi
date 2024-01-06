package com.example.lovecodeakalo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){


        UserDetails anicet = User.builder()
                .username("anicet")
                .password("{noop}anicet")
                .roles(RolePerson.EMPLOYEE.name(), RolePerson.MANAGER.name(), RolePerson.ADMIN.name())
                .build();

        UserDetails dora = User.builder()
                .username("dora")
                .password("{noop}dora")
                .roles(RolePerson.EMPLOYEE.name())
                .build();

        UserDetails francheska = User.builder()
                .username("francheska")
                .password("{noop}francheska")
                .roles(RolePerson.EMPLOYEE.name())
                .build();
        return new InMemoryUserDetailsManager(anicet, dora, francheska);



    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(conf->{
            conf
                    .requestMatchers(HttpMethod.GET, "/api/employees").hasRole(RolePerson.EMPLOYEE.name())
                    .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole(RolePerson.EMPLOYEE.name())
                    .requestMatchers(HttpMethod.POST, "/api/employees").hasRole(RolePerson.MANAGER.name())
                    .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole(RolePerson.MANAGER.name())
                    .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole(RolePerson.ADMIN.name());

        });

// use HTTP Basic authentification

        http.httpBasic(Customizer.withDefaults());


        // disable cross site request forgery CSRF
        http.csrf(csrf-> csrf.disable());
        return http.build();

    }
}
