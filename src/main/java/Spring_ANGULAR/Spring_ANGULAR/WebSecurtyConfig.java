package Spring_ANGULAR.Spring_ANGULAR;



import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurtyConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure ( HttpSecurity http ) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers( "/**","/login**", "/error**").permitAll()
                .anyRequest().authenticated()
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and();
//                .csrf ( ).disable ( );
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(
                        "/**","/webjars/**", "/v2/api-docs/**", "/configuration/ui/**", "/swagger-resources/**",
                        "/configuration/security/**", "/swagger-ui.html/**", "/swagger-ui.html#/**");
    }
}

