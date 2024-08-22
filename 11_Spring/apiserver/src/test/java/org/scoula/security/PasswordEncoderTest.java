package org.scoula.security;

import lombok.extern.log4j.Log4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.security.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        RootConfig.class,
        SecurityConfig.class
})
@Log4j
class PasswordEncoderTest {
        @Autowired
        private PasswordEncoder pwEncoder;

        @Test
        public void testEncode() {
            String str="1234";
// 암호화를 하면 길이가 60자 무작위 글자조합으로 된다. = 비밀번호 길이 제한을 60자 이상으로 해야 함.
            String enStr = pwEncoder.encode(str);
            // 비밀번호 인코딩, 로그출력
            log.info("비번 : " + enStr);

            //동일 비빌번호를 다시 인코딩.
            String enStr2 = pwEncoder.encode(str);
            log.info("비번 : " + enStr2);

            // 원본과 인코딩을 비교할 때는 matches 사용.
            log.info(pwEncoder.matches(str,enStr));
            log.info(pwEncoder.matches(str,enStr2));
            // 각각의 인코딩을 비교하면 같은 원본이라도 서로 다르다.
            log.info(pwEncoder.matches(enStr,enStr2));
        }
    }
