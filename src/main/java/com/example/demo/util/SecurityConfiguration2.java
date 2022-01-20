package com.example.demo.util;

import com.example.demo.util.apiSecurity.AuthEntryPointJwt;
import com.example.demo.util.apiSecurity.AuthTokenFilter;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration2 extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityUtilities securityUtilities;

    private BCryptPasswordEncoder passwordEncoder(){
        return securityUtilities.getPasswordEncoder();
    }

    private static final String[] ALLOW_ACCESS_WITHOUT_AUTHENTICATION = {
            "/login", "/register", "/", "/restapi/v1/auth/**", "/restapi/v1/secure/**"
    };

    @Autowired
    private UserDetailsService customerService;

    //start copied code (from: )
    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(customerService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    //end copied code


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.authorizeRequests().antMatchers(ALLOW_ACCESS_WITHOUT_AUTHENTICATION)
                .permitAll().anyRequest().authenticated();
        http.formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/").failureUrl("/login?error")
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/?logout").deleteCookies("remember-me")
                .permitAll().and().rememberMe();


        //start copied code (from)
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);*/

        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/restapi/v1/auth/**","/").permitAll()
                .antMatchers("/restapi/v1/test/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //end copied code

    }


    /*
    method below allows api to access specified pages without authentication
    specifying /restapi/** in ALLOW_ACCESS_WITHOUT_AUTHENTICATION does allow api GET-requests,
    but not POST-request
    this method below works for POST-requests as well
    copied from:
    https://stackoverflow.com/questions/37671125/how-to-configure-spring-security-to-allow-swagger-url-to-be-accessed-without-aut
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/restapi/v1/auth**");
    }
}
