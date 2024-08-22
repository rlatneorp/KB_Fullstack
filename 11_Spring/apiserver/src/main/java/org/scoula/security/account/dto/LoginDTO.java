package org.scoula.security.account.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginDTO {
    private String username;
    private String password;

    public static LoginDTO of(HttpServletRequest request) throws AuthenticationException {
        ObjectMapper om = new ObjectMapper(); // JSON 파싱을 위한 ObjectMapper 생성.
        try {
            // request에서 JSON데이터를 읽어와 LoginDTO 객체로 반환(역직렬화).
            return om.readValue(request.getInputStream(), LoginDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            // 자격 증명이 잘못되었을 때 나타나는 예외.
            throw new BadCredentialsException("username/password 가 없습니다.");
        }
    }
}
