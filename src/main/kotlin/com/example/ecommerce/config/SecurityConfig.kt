package com.example.ecommerce.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.web.server.ServerHttpSecurity.http
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
class SecurityConfig {



        @Autowired
        private lateinit var userDetailsService: UserDetailsService

        @Autowired
        private lateinit var passwordEncoder: PasswordEncoder


    @Bean
    open fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeRequests { authorizeRequests ->
                authorizeRequests
                    .antMatchers("/api/v1/customer/**").permitAll()
                    .anyRequest().authenticated()
            }
            .formLogin { formLogin ->
                formLogin
                    .loginPage("/login")
                    .permitAll()
            }
            .logout { logout ->
                logout
                    .logoutUrl("/logout")
                    .permitAll()
            }
        return http.build()
    }


        @Throws(Exception::class)
        fun configure(auth: AuthenticationManagerBuilder) {
            auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
        }

}