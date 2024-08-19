package org.scoula.security.config;


import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity // 모든 페이지에서 자동으로 인증을 하도록 설정
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 문자셋 필터
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        addFilterBefore 메서드를 사용하여 CharacterEncodingFilter를 CsrFilter 이전에 추가함
//        이 설정은 모든 요청에 대해 UTF-8 인코딩 적용 후에 CSRF 보호가 이루어지도록 함
//        http.addFilterBefore(encodingFilter(), CsrfFilter.class);
 //       경로별 접근 권한 설정
        http.authorizeRequests()
                // '/security/all' 경로는 모든 사용자에게 접근 허용
                .antMatchers("/security/all").permitAll()
                // "/security/admin" 경로는 ADMIN권한이 있는 사용자만 접근 가능
                .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
                // "/security/member" 경로는 MEMBER 권한이 있는 사용자만 접근 가능
                .antMatchers("/security/member").access("hasRole('ROLE_MEMBER')");
        http.formLogin()
                .loginPage("/security/login") // form요청 url
                .loginProcessingUrl("/security/login") // submit url
                .defaultSuccessUrl("/");
    }
}
