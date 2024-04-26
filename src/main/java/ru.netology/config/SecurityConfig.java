package ru.netology.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("zaur")
                .password("{noop}123")
                .roles("READ")
                .and()
                .withUser("oleg")
                .password("{noop}789")
                .roles("WRITE")
                .and()
                .withUser("ivan")
                .password("{noop}abc")
                .roles("DELETE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .and()
                .authorizeRequests()
                .anyRequest().authenticated();
    }

}