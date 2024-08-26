package org.scoula.security.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.security.account.domain.MemberVO;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfoDTO {
    private String username;
    private String email;
    private List<String> roles;

    public static UserInfoDTO of(MemberVO member){
        return new UserInfoDTO(
                member.getUsername(),
                member.getEmail(),
                member.getAuthList().stream()
                        .map(a->a.getAuth()) // 각 AuthVO 객체에서  auth 값만 추출ㄴ
                        .toList() // 추출한 권한 목록을 리스트로 변환
        );
    }
}