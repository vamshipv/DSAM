package com.example.DSAMAssignment.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSecurityConfig {

//    @Override
//    protected void configure(HttpS http) throws Exception {
//        http
//                .headers()
//                .frameOptions().disable()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/register").permitAll()
//                .antMatchers("/home").permitAll()
//                .antMatchers("/css/**").permitAll()
//                .antMatchers("/img/**").permitAll()
//                .antMatchers("/js/**").permitAll()
//                .antMatchers("/public/**").permitAll()
//                .antMatchers("/h2-console/**").permitAll()
//                .anyRequest().authenticated().and()
//                .sessionManagement().and()
//                .formLogin().loginPage("/login")
//                .permitAll()
//                .failureUrl("/login")
//                .successHandler(ajaxAuthenticationSuccessHandler)
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login")
//                .permitAll()
//                .invalidateHttpSession(true)
//                .and().csrf().disable();
//    }
}
