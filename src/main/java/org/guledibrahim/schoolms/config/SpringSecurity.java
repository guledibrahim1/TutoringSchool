package org.guledibrahim.schoolms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
//@EnableWebSecurity
//public class SpringSecurity {
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
//
//        http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/register/**").permitAll()
//                .requestMatchers("/index").permitAll()
//                .requestMatchers("/login-tutor").permitAll()
//                .requestMatchers("/register-tutor").permitAll()
////                .requestMatchers("/students").hasRole("ADMIN")
//                .and()
//                .formLogin(
//                        form -> form
//                                .loginPage("/login")
//                                .loginProcessingUrl("/login")
//                                .defaultSuccessUrl("/students")
//                                .permitAll()
//                ).logout(
//                        logout -> logout
//                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                                .permitAll());
//        return http.build();
//    }
//}

@Configuration
@EnableWebSecurity
public class SpringSecurity {
    String[] resources = new String[]{
            "/static/**", "/style/**", "/images/**", "/scripts/**", "/pages/**"
    };
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authz) -> authz
                                .requestMatchers(resources).permitAll()
                                .requestMatchers("/register/**").permitAll()
                                .requestMatchers("/register-user/**").permitAll()
                                .requestMatchers("/register-tutor/**").permitAll()
                                .requestMatchers("/add-subject/**").permitAll()
                                .requestMatchers("/index").permitAll()
                                .requestMatchers("/subjects").hasRole("ADMIN")
                                .requestMatchers("/students").hasRole("ADMIN")

//                                .requestMatchers("/students").hasRole("ADMIN")
                        // .and()
                )
                .formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/students")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll());
        return http.build();
    }

}