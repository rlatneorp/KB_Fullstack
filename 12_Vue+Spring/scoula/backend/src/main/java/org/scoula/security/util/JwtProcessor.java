package org.scoula.security.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtProcessor {
//    토큰 유효기간을 5분으로 설정
    static private final long TOKEN_VALID_MILISECOND = 1000L * 60 * 120; // 5 분

//    비밀 키 설정 : 개발시에는 서버 재가동하는 경우가 많으므로 임의의 문자열
    private final String secretKey = "dkssudgktpdyqlalfzldlqslekdkssudgktpdyqlalfzldlqslek"; // 안녕하세요비밀키입니다안녕하세요비밀키입니다
    private final Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    // private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); -- 운영시 사용

    // JWT 생성
    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject) // 주로 사용자 식별용
                .setIssuedAt(new Date()) // jwt 발급시간
                .setExpiration(new Date(new Date().getTime() + TOKEN_VALID_MILISECOND)) // jwt 만료시간
                .signWith(key) // jwt 서명을 위한 키 설정
                .compact();// jwt 문자열 생성 및 반환
    }
    // JWT Subject(username) 추출 - 해석 불가인 경우 예외 발생
    // 예외 ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException,
    // IllegalArgumentException
    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key) // 서명 검증을 위한 키 설정
                .build()
                .parseClaimsJws(token) // 토큰 파싱, jws는 서명이 있는 jwt로 파싱
                .getBody()
                .getSubject(); // 사용자이름 반환
    }
    // JWT 검증(유효 기간 검증) - 해석 불가인 경우 예외 발생
    public boolean validateToken(String token) {
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(key) // 서명 검증을 위한 키 설정
                .build()
                .parseClaimsJws(token); // 토큰 파싱 및 서명 검증
        return true; // 유효한 토큰일 경우 true 반환
    }
}