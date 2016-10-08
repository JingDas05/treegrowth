package com.treegrowth.web.security;

import com.treegrowth.model.security.Authority;
import com.treegrowth.web.security.userdetails.TgUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.treegrowth.model.security.Authority.USER;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private TgUserDetailsService tgUserDetailsService;

    @Autowired
    public void configGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(tgUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers(
                    "/api/**"
                )
                .permitAll()
                .anyRequest().hasRole(USER.name())
                .and()
            .formLogin()
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
            .logout()
                .permitAll()
                .and()
            .csrf()
                .disable();
    }
}
