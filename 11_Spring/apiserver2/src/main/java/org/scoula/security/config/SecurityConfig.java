package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.annotation.MapperScan;
import org.scoula.security.filter.AuthenticationErrorFilter;
import org.scoula.security.filter.JwtAuthenticationFilter;
import org.scoula.security.filter.JwtUsernamePasswordAuthenticationFilter;
import org.scoula.security.handler.CustomAccessDeniedHandler;
import org.scoula.security.handler.CustomAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity // 모든 페이지에서 자동으로 인증을 하도록 설정.
@Log4j
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserDetailsService userDetailsService;
    private final AuthenticationErrorFilter authenticationErrorFilter;
    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private JwtUsernamePasswordAuthenticationFilter jwtUsernamePasswordAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //CORS 설정을 위한 객체 생성
        CorsConfiguration config = new CorsConfiguration();

        //자격 증명을 포함한 요청을 허용하도록 설정.
        config.setAllowCredentials(true);

        // 모든 도메인에서 오는 요청 허용.
        config.addAllowedOriginPattern("*");

        // 모든 헤더 허용.
        config.addAllowedHeader("*");

        // 모든 HTTP메서드 허용
        config.addAllowedMethod("*");

        // 설정된 CORS 구성을 모든 경로("/**")에 적용
        source.registerCorsConfiguration("/**", config);

        // 설정된 소스 기반으로 새로운 corsfilter 반환.
        return new CorsFilter(source);
    }

    // 특정 경로에 대한 보안 필터 적용 해제.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**", "/*", "/api/member/**");
        // 뒤에 있는 경로들은 보안 검사를 무시한다.
    }

    public CharacterEncodingFilter encodingFilter () {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.addFilterBefore(encodingFilter(), CsrfFilter.class)
                // 인증 에러 필터
                .addFilterBefore(authenticationErrorFilter, UsernamePasswordAuthenticationFilter.class)
                // addfilterbefore 메서드를 사용하여 characterencodingfilter를 csrffilter 이전에 추가.
                // 이 설정은 모든 요청에 대해 utf-8 인코딩 적용 후에 csrf 보호가 이루어지도록 함.
                // 로그인 인증 필터.
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);

        http.httpBasic().disable() //기본 http인증 비활성화
                .csrf().disable() // csrf 비활성화
                .formLogin().disable() // formLogin 비활성화, 관련필터 해제
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 세션 생성 모드 설정. (stateless = 세션 사용 안하겠다.)
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/api/security/all").permitAll()
                .antMatchers("/api/security/member").access("hasRole('ROLE_MEMBER')")
                .antMatchers("/api/security/admin").access("hasRole('ROLE_ADMIN')")
                .anyRequest().authenticated();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        log.info("configure.......................");
        //메모리 정보 대신 userDetailsService를 사용해 인증 처리하도록 설정.
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}

