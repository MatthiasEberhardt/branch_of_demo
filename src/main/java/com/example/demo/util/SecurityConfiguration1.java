package com.example.demo.util;

import com.example.demo.util.apiSecurity.AuthEntryPointJwt;
import com.example.demo.util.apiSecurity.AuthTokenFilter;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(1)
public class SecurityConfiguration1 extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityUtilities securityUtilities;

    private BCryptPasswordEncoder passwordEncoder(){
        return securityUtilities.getPasswordEncoder();
    }

    private static final String[] ALLOW_ACCESS_WITHOUT_AUTHENTICATION = {
            "/web/login", "/web/register", "/web"//, "/restapi/v1/auth/**", "/restapi/v1/secure/**"
    };



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers("/web/**").and().authorizeRequests().antMatchers(ALLOW_ACCESS_WITHOUT_AUTHENTICATION)
                .permitAll().anyRequest().authenticated();
        http.formLogin().loginPage("/web/login").permitAll()
                .defaultSuccessUrl("/web/").failureUrl("/web/login?error")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/web/logout"))
                .logoutSuccessUrl("/web/?logout").deleteCookies("remember-me")
                .permitAll().and().rememberMe();


    }


    /*.and()
                .authorizeRequests().antMatchers("/restapi/v1/auth/**").permitAll()
                .antMatchers("/restapi/v1/secure/**").permitAll()
                .anyRequest().authenticated();*/

    /*
    method below allows api to access specified pages without authentication
    specifying /restapi/** in ALLOW_ACCESS_WITHOUT_AUTHENTICATION does allow api GET-requests,
    but not POST-request
    this method below works for POST-requests as well
    copied from:
    https://stackoverflow.com/questions/37671125/how-to-configure-spring-security-to-allow-swagger-url-to-be-accessed-without-aut
     */

}