package com.tsimura.getshared.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * SecurityConfig which contains all the security related stuff!
     */

//    @Autowired
//    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
//
//    @Autowired
//    private MySavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler;
//
//    @Override
//    @Autowired
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("superadmin").password("superadmin").roles("SUPERADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .exceptionHandling()
//                .authenticationEntryPoint(restAuthenticationEntryPoint)
//                .and()
//                .authorizeRequests().antMatchers("/api/entries").authenticated()
//                .and()
//                .formLogin()
//                .successHandler(mySuccessHandler())
//                .failureHandler(myFailureHandler())
//                .and()
//                .logout();
//
//    }
//
//    @Bean(name = "mySuccessHandler")
//    public MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler(){
//        return new MySavedRequestAwareAuthenticationSuccessHandler();
//    }
//
//    @Bean(name = "myFailureHandler")
//    public SimpleUrlAuthenticationFailureHandler myFailureHandler(){
//        return new SimpleUrlAuthenticationFailureHandler();
//    }
}