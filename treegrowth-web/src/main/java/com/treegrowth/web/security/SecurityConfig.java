package com.treegrowth.web.security;

import com.treegrowth.web.security.userdetails.TgUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jersey.JerseyProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.filter.CompositeFilter;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableOAuth2Client
@EnableAuthorizationServer
@Order(6)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private TgUserDetailsService tgUserDetailsService;
//    /**oauth2*/
//    @Autowired
//    private OAuth2ClientContext oAuth2ClientContext;

    /**add passwordEncoder*/
    @Autowired
    public void configGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers(
                            "../static/css/**",
                            "/index",
                            "/api/**",
                            "/login/**",
                            "/webjars/**",
                            "oauth/**")
                    .permitAll()
                    //.antMatchers("/user/**").hasRole("USER")
                    .and()
                .exceptionHandling()
                    .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/"))
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login-error")
                    .and()
                .logout()
                    .logoutSuccessUrl("/")
                    .permitAll()
                    .and()
                .csrf()
                    .disable();
//                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                    .and()
//                .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(tgUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

/** oauth2 sso*/

//    @Bean
//    public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(filter);
//        registration.setOrder(-100);
//        return registration;
//    }
//
//    @Bean
//    @ConfigurationProperties("github")
//    public ClientResources github() {
//        return new ClientResources();
//    }
//
//    @Bean
//    @ConfigurationProperties("facebook")
//    public ClientResources facebook() {
//        return new ClientResources();
//    }
//
//    private Filter ssoFilter() {
//        CompositeFilter filter = new CompositeFilter();
//        List<Filter> filters = new ArrayList<>();
//        filters.add(ssoFilter(github(),"/login/github"));
//        filters.add(ssoFilter(facebook(),"/login/facebook"));
//        filter.setFilters(filters);
//        return filter;
//    }
//
//    private Filter ssoFilter(ClientResources client, String path) {
//        //filter
//        OAuth2ClientAuthenticationProcessingFilter oAuth2ClientAuthenticationFilter = new OAuth2ClientAuthenticationProcessingFilter(path);
//        //tokenService
//        UserInfoTokenServices tokenServices = new UserInfoTokenServices(client.getResource().getUserInfoUri(),client.getClient().getClientId());
//        //restTemplate
//        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(client.getClient(),oAuth2ClientContext);
//        //use template
//        oAuth2ClientAuthenticationFilter.setRestTemplate(oAuth2RestTemplate);
//        tokenServices.setRestTemplate(oAuth2RestTemplate);
//        return oAuth2ClientAuthenticationFilter;
//    }
//
//    @Configuration
//    @EnableResourceServer
//    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            // @formatter:off
//            http.antMatcher("/me").authorizeRequests().anyRequest().authenticated();
//            // @formatter:on
//        }
//    }
//
//class ClientResources {
//
//        @NestedConfigurationProperty
//        private AuthorizationCodeResourceDetails client = new AuthorizationCodeResourceDetails();
//
//        @NestedConfigurationProperty
//        private ResourceServerProperties resource = new ResourceServerProperties();
//
//        public AuthorizationCodeResourceDetails getClient() {
//            return client;
//        }
//
//        public ResourceServerProperties getResource() {
//            return resource;
//        }
//}

}
