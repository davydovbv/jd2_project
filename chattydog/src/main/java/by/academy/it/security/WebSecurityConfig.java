package by.academy.it.security;

import by.academy.it.service.security.DbAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DbAuthenticationService dbAuthenticationService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(dbAuthenticationService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        //Login not required
        http.authorizeRequests().antMatchers("/","/index","/logoutSuccessful","/login","/registration","/topics").permitAll();

        //Login as USER required
        http.authorizeRequests().anyRequest().authenticated();

        //Exception for access whit wrong role;
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")

                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
    }
}
