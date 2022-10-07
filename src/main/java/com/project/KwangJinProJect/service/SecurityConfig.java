package com.project.KwangJinProJect.service;

import com.project.KwangJinProJect.component.LoginFailHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()


                .authorizeRequests()
//                        .antMatchers("/admin/**").hasRole("ADMIN")
//                        .antMatchers("/**").permitAll()
                .anyRequest().permitAll()

                .and()
                        .formLogin()
                        .loginPage("/loginPage")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/")
                .failureHandler(loginFailHandler());
//                        .failureUrl("/");

//                .and()
//                        .exceptionHandling().accessDeniedPage("/");
//                .and()
//                .logout()
//                .logoutRequestMatcher()

//                .usernameParameter("name")
//                .passwordParameter("password")
//                .loginProcessingUrl("api/join")


    }
    @Bean
    public LoginFailHandler loginFailHandler() {
        return new LoginFailHandler();
    }
}
