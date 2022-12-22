package mk.ukim.finki.tech_prototype.Configuration;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@Configuration
@CrossOrigin
public class WebSecurityConfiguration{
    private final CustomUsernamePasswordAuthenticationProvider customUsernamePasswordAuthenticationProvider;
    private final JwtFilterRequest jwtFilterRequest;
    public WebSecurityConfiguration(CustomUsernamePasswordAuthenticationProvider customUsernamePasswordAuthenticationProvider, JwtFilterRequest jwtFilterRequest) {
        this.customUsernamePasswordAuthenticationProvider = customUsernamePasswordAuthenticationProvider;
        this.jwtFilterRequest = jwtFilterRequest;
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(customUsernamePasswordAuthenticationProvider);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and();
        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        }
                )
                .and();
        http.addFilterBefore(this.jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
        http.cors().and().
        csrf().disable().authorizeHttpRequests()
                .requestMatchers("/", "/csv/**", "/assets/**", "/register").permitAll()
                .requestMatchers("/review/**").hasRole("USER")
                .requestMatchers("/alpinehut", "/alpinehut/{id}", "/alpinehut/name", "/alpinehut/cname", "/alpinehut/city").permitAll()
                .requestMatchers("/alpinehut/edit/**", "/alpinehut/add/**").hasRole("ADMIN")
                .requestMatchers("/campsite", "/campsite/{id}", "/campsite/name", "/campsite/cname", "/campsite/city").permitAll()
                .requestMatchers("/campsite/edit/**", "/campsite/add/**").hasRole("ADMIN")
                .requestMatchers("/guesthouse", "/guesthouse/{id}", "/guesthouse/name", "/guesthouse/cname", "/guesthouse/city").permitAll()
                .requestMatchers("/guesthouse/edit/**", "/guesthouse/add/**").hasRole("ADMIN")
                .requestMatchers("/hotel", "/hotel/{id}", "/hotel/name", "/hotel/cname", "/hotel/city", "/hotel/stars").permitAll()
                .requestMatchers("/hotel/edit/**", "/hotel/add/**").hasRole("ADMIN")
                .requestMatchers("/location/{id}").permitAll()
                .requestMatchers("/location/delete/**").hasRole("ADMIN")
                .requestMatchers("/location/grade/**").permitAll()
                .requestMatchers("/user/pending/**").hasRole("ADMIN")
                .requestMatchers("/user/addFavourite/**", "user/addVisited/**").hasRole("USER")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .failureUrl("/login?error=BadCredentials")
                .defaultSuccessUrl("/products", true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login")
                .and();
        return http.build();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH",
                "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type",
                "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
        UrlBasedCorsConfigurationSource source = new
                UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
