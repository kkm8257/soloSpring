package com.demo.demoproject;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/**", "/goHome","/goLogin","/h2_db/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf()
                .ignoringAntMatchers("/h2_db/**")
                .and()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .formLogin()
                .loginPage("/goLogin")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/goHome")
                .permitAll();



    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
