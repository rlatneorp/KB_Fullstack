package org.scoula.security.util;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
@Log4j
class JwtProcessorTest {
    @Autowired
    JwtProcessor jwtProcessor;

    @Test
    void generateToken() {
        // JWT 토큰 생성 테스트
        String username="user01";
        String token = jwtProcessor.generateToken(username);
        log.info(token);
        assertNotNull(token);
    }

    @Test
    void getUsername() {
        // JWT 토큰에서 사용자 이름 추출하는 테스트
        String token ="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMDEiLCJpYXQiOjE3MjQyMjQzNTEsImV4cCI6MTcyNDIyNDY1MX0.68HRm40u3f-1GTS3wU4Y9X39If1PsJGIYX1ktAegC9Q";

        String username= jwtProcessor.getUsername(token); // 토큰에서 사용자 이름 추출.
        log.info(username);
        assertNotNull(username); // 사용자 이름이 null이 아닌지 확인.
    }

    @Test
    void validateToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMDEiLCJpYXQiOjE3MjQyMjQzNTEsImV4cCI6MTcyNDIyNDY1MX0.68HRm40u3f-1GTS3wU4Y9X39If1PsJGIYX1ktAegC9Q";
        boolean isValid = jwtProcessor.validateToken(token);
        log.info(isValid);
        assertTrue(isValid);
    }
}