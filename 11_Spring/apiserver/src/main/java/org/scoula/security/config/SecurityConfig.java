package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity // 모든 페이지에서 자동으로 인증을 하도록 설정
@Log4j
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // PasswordEncoder의 구현체
    }

    // AuthenticationManager 빈 등록
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // cross origin 접근 허용
    // 다양한 도메인에서 서버에 요청을 보낼 수 있다
    @Bean
    public CorsFilter corsFilter() {
//        CORS 설정을 적용할 URL 소스 생성
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CORS 설정을 위한 객체 생성
        CorsConfiguration config = new CorsConfiguration();
//        자격 증명(쿠키,인증 헤더 등)을 포함한 요청을 허용하도록 설정
        config.setAllowCredentials(true);
//        모든 도메인에서 오는 요청 허용 (("*")은 모두라는 의미)
        config.addAllowedOriginPattern("*");
//        모든 헤더 허용
        config.addAllowedHeader("*");
//        모든 HTTP 메서드 허용 (GET, POST, PUT, DELETE)
        config.addAllowedMethod("*");
//        설정된 CORS 구성을 모든 경로("/**")에 적용 (하위 경로 포함)
        source.registerCorsConfiguration("/**", config);
//        설정된 소스 기반으로 새로운 CorsFilter 반환
        return new CorsFilter(source);
    }

    // 접근 제한 무시 경로 설정 – resource
//    특정 경로에 대한 보안 필터를 적용하지 않도록 설정
    @Override
    public void configure(WebSecurity web) throws Exception {
//        해당 경로들은 보안 경로 무시
        web.ignoring().antMatchers("/assets/**", "/*", "/api/member/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 한글 인코딩 필터 설정
        http.addFilterBefore(encodingFilter(), CsrfFilter.class);

        http.httpBasic().disable() // 기본 HTTP 인증 비활성화
            .csrf().disable() // CSRF 비활성화
            .formLogin().disable() // formLogin 비활성화 관련 필터 해제
             // 세션 생성 모드 설정 (stateless : 세션 사용 안함)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("configure ...................................");

//        메모리 정보 대신 UserDetailsService를 사용해서 인증 처리하도록 설정
        auth
            .userDetailsService(userDetailsService) // 사용자 정보 로드
            .passwordEncoder(passwordEncoder()); // 비밀번호 암호화
    }

    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();

        // UTF-8 인코딩을 설정합니다.
        encodingFilter.setEncoding("UTF-8");
        // 강제로 UTF-8 인코딩을 적용하도록 설정
        encodingFilter.setForceEncoding(true);
        // 생성된 필터를 반환
        return encodingFilter;
    }
}