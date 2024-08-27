package org.scoula.member.dto;

import org.scoula.security.account.domain.MemberVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//회원 가입시 사용자가 직접 입력하는 정보
public class MemberJoinDTO {
    String username;
    String password;
    String email;

//    회원이 업로드한 아바타 이미 파일 저장
    MultipartFile avatar;

//    MemberJoinDTO 객체를 MemberVO 객체로 변환하는 메소드
//    그때그때 바뀌기 때문에 static은 안됨
    public MemberVO toVO() {
        return MemberVO.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();
    }
}