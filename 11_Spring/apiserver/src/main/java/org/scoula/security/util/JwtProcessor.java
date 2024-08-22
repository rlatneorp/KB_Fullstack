package org.scoula.security.util;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtProcessor {
    // 토큰 유효기간을 5분으로 설정.
    static private final long TOKEN_VALID_MILISECOND = 1000L*60*10;

    // 비밀 키 설정. 충분히 길게 해야함, 매번 변경되므로 운영시에만 사용.
    private String secretKey = "dkdkdkdkdkdydydydyfkfnkeidnkfccxzzdkdkdkdkdkdk";
    private Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    //JWT 토큰 생성 메서드
    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)

                //JWT 발급 시간
                .setIssuedAt(new Date())

                // 현재 시간에서 5분을 더해줌 = 사용시간 = JWT 만료시간.
                .setExpiration(new Date(new Date().getTime() + TOKEN_VALID_MILISECOND))

                //jwt 서명을 위한 키 설정.
                .signWith(key)

                //jwt문자열 생성 및 반환
                .compact();
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key) //서명 검증을 위한 키 설정
                .build()
                .parseClaimsJws(token) // 토큰 파싱, jws는 서명이 있는 jwt로 파싱
                .getBody()
                .getSubject(); // 사용자 이름(subject)반환
    }

    public boolean validateToken(String token) {
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
        return true;
    }
}
