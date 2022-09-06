
package com.nichi.miniProject.config;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception 
	{

       http.authorizeRequests().antMatchers("/").authenticated()
		.and()
		.authorizeRequests().antMatchers("/console/**").permitAll();
		http.csrf().disable(); // POST not working fix
		http.headers().frameOptions().disable(); // H2 console fix
	
		http.authorizeRequests()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.defaultSuccessUrl("/")
		.failureUrl("/login?error=true")
		.and()
		.logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
		 .and().httpBasic();
	
		  
	}


    /* 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("u1").password("123").roles("USER")
                .and()
                .withUser("u2").password("456").roles("USER", "EMPLOYEE")
                .and()
				.withUser("u3").password("789").roles( "EMPLOYEE")
                .and()
                .withUser("admin").password("admin123").roles("ADMIN", "USER")
                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());

    }

	*/
	

}
