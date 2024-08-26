package org.scoula.security.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.security.util.JsonResponse;
import org.scoula.security.util.JwtProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.SignatureException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
//요청당 한번만 필터가 동작하도록 OncePerRequestFilter 상속
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer "; // Bearer 토큰의 접두사

    private final JwtProcessor jwtProcessor;
    private final UserDetailsService userDetailsService;

//    토큰을 이용해서 인증 정보를 받아오는 메소드
    private Authentication getAuthentication(String token) {
//        토큰에서 사용자 이름 추출
        String username = jwtProcessor.getUsername(token);
//        추출한 사용자 이름으로 UserDetails 가져오기
        UserDetails principal = userDetailsService.loadUserByUsername(username);
//        로드된 사용자 정보를 기반으로 인증 토큰 생성
//        credentials는 자격증명으로 null이면 이미 인증이 완료됐거나 자격증명이 필요하지 않은 상태
        return new UsernamePasswordAuthenticationToken(principal, token, principal.getAuthorities());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Authorization 헤더에서 Bearer 토큰 추출
        try {
            String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
//            실제로 Bearer 토큰이 맞는지 확인
            if (bearerToken != null && bearerToken.startsWith(BEARER_PREFIX)) {
//                토큰에서 "Bearer "를 제외한 실제 토큰 부분 잘라내기
                String token = bearerToken.substring(BEARER_PREFIX.length());
//                토큰으로부터 인증 객체 가져오기
                Authentication authentication = getAuthentication(token);
//                Security Context 에 접근해서 인증 객체를 저장
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);  // 필터 체인의 다음 필터를 호출
        } catch (ExpiredJwtException e) {
            JsonResponse.sendError(response, HttpStatus.UNAUTHORIZED, "토큰 유효시간 끝");
        } catch (UnsupportedJwtException | MalformedJwtException | SignatureException e) {
            JsonResponse.sendError(response, HttpStatus.UNAUTHORIZED, e.getMessage());
        } catch (ServletException e) {
            JsonResponse.sendError(response, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
