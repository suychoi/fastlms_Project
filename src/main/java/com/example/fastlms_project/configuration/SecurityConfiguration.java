package com.example.fastlms_project.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/",
                "/member/register")
                .permitAll();

        http.formLogin()
                .loginPage("/member/login")
                .permitAll();

        super.configure(http);
    }
}
