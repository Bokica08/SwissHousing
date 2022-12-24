package mk.ukim.finki.tech_prototype.Configuration;

import mk.ukim.finki.tech_prototype.Service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@CrossOrigin
public class WebSecurityConfiguration{
    private final CustomUsernamePasswordAuthenticationProvider customUsernamePasswordAuthenticationProvider;
    private final UserService userDetailsService;
    private final AuthTokenFilter authenticationJwtTokenFilter;
    private final AuthEntryPointJwt unauthorizedHandler;
    private final PasswordEncoder passwordEncoder;

    public WebSecurityConfiguration(CustomUsernamePasswordAuthenticationProvider customUsernamePasswordAuthenticationProvider, UserService userDetailService, AuthTokenFilter authenticationJwtTokenFilter, AuthEntryPointJwt authEntryPointJwt, PasswordEncoder passwordEncoder) {
        this.customUsernamePasswordAuthenticationProvider = customUsernamePasswordAuthenticationProvider;
        this.userDetailsService = userDetailService;
        this.authenticationJwtTokenFilter = authenticationJwtTokenFilter;
        this.unauthorizedHandler = authEntryPointJwt;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().
        csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
                .antMatchers("/", "/csv/**", "/assets/**", "/register").permitAll()
                .antMatchers("/review/**").hasRole("USER")
                .antMatchers("/alpinehut", "/alpinehut/{id}", "/alpinehut/name", "/alpinehut/cname", "/alpinehut/city").permitAll()
                .antMatchers("/alpinehut/edit/**", "/alpinehut/add").hasRole("ADMIN")
                .antMatchers("/campsite", "/campsite/{id}", "/campsite/name", "/campsite/cname", "/campsite/city").permitAll()
                .antMatchers("/campsite/edit/**", "/campsite/add").hasRole("ADMIN")
                .antMatchers("/guesthouse", "/guesthouse/{id}", "/guesthouse/name", "/guesthouse/cname", "/guesthouse/city").permitAll()
                .antMatchers("/guesthouse/edit/**", "/guesthouse/add").hasRole("ADMIN")
                .antMatchers("/hotel", "/hotel/{id}", "/hotel/name", "/hotel/cname", "/hotel/city", "/hotel/stars").permitAll()
                .antMatchers("/hotel/edit/**", "/hotel/add").hasRole("ADMIN")
                .antMatchers("/location/{id}").permitAll()
                .antMatchers("/location/delete/**").hasRole("ADMIN")
                .antMatchers("/location/grade/**").permitAll()
                .antMatchers("/user/pending/**").hasRole("ADMIN")
                .antMatchers("/user/addFavourite/**", "user/addVisited/**").hasRole("USER")
                .anyRequest().permitAll();
        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authenticationJwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH",
                "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type",
                "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
        configuration.setAllowCredentials(Boolean.TRUE);
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new
                UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
