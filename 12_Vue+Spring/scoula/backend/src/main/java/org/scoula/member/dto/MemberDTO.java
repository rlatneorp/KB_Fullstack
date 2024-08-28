package org.scoula.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//회원 가입 완료시 받아오는 회원 정보
public class MemberDTO {
    private String username;
    private String email;
    private Date regDate;
    private Date updateDate;

    MultipartFile avatar;

    private List<String> authList; // 권한 목록, join 처리 필요

    // VO를 DTO로 바꿔주는 정적 메소드
    public static MemberDTO of(MemberVO m) {
        return MemberDTO.builder()
                .username(m.getUsername())
                .email(m.getEmail())
                .regDate(m.getRegDate())
                .updateDate(m.getUpdateDate())
//                MemberVO의 authList를 스트림으로 변환해서 각 권한을 추출하고 리스트로 변환
                .authList(m.getAuthList().stream().map(a->a.getAuth()).toList())
                .build();
    }

    // 생략 가능
    public MemberVO toVO() {
        return MemberVO.builder()
                .username(username)
                .email(email)
                .regDate(regDate)
                .updateDate(updateDate)
                .build();
    }
}