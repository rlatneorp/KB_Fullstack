package org.scoula.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.scoula.security.account.dto.LoginDTO;
import org.scoula.security.handler.LoginFailureHandler;
import org.scoula.security.handler.LoginSuccessHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    // 스프링 생성자 주입을 통해 데이터 전달
    public JwtUsernamePasswordAuthenticationFilter(
            AuthenticationManager authenticationManager, // SecurityConfig가 생성된 이후에 등록
            LoginSuccessHandler loginSuccessHandler,
            LoginFailureHandler loginFailureHandler)
    {
        super(authenticationManager);
        setFilterProcessesUrl("/api/auth/login"); // 해당 url로 POST 로그인 요청시 처리
        setAuthenticationSuccessHandler(loginSuccessHandler); // 로그인 성공 핸들러 등록
        setAuthenticationFailureHandler(loginFailureHandler); // 로그인 실패 핸들러 등록
    }

    // 로그인 요청이 필터의 처리 URL과 일치할때 로그인 작업 처리하는 메소드
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // 요청 body에서 사용자 이름과 비밀번호 추출하여 LoginDTO 객체생성
        LoginDTO login = LoginDTO.of(request);

        // 사용자 이름과 비밀번호 사용하여 인증토큰 생성
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
        log.info(authenticationToken.toString());
        // AuthenticationManager에게 인증을 위임해서 처리
        return getAuthenticationManager().authenticate(authenticationToken);
    }
}