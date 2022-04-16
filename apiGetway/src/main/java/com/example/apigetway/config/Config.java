package com.example.apigetway.config;


import com.example.apigetway.constant.RestEndpoints;
import com.example.apigetway.security.JWTAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(
                        "/"+ RestEndpoints.USER_PREFIX+RestEndpoints.REGISTER,
                        "/"+ RestEndpoints.USER_PREFIX+RestEndpoints.LOGIN
                ).permitAll()
                .antMatchers(
                        //vendor prefix
                        "/"+ RestEndpoints.VENDOR_PREFIX,
                        "/"+RestEndpoints.VENDOR_PREFIX+RestEndpoints.VENDOR_BY_ID,

                        // products Endpoints
                        "/"+RestEndpoints.PRODUCTS_PREFIX,
                        "/"+RestEndpoints.PRODUCTS_PREFIX+RestEndpoints.PRODUCT_BY_ID)
                .authenticated().and()
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
