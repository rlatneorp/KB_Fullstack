package org.scoula.member.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.mapper.MemberMapper;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    final PasswordEncoder passwordEncoder; // 비밀번호 암호화 인코더
    final MemberMapper mapper; // DB 접근을 위한 매퍼

    @Override
    public boolean checkDuplicate(String username) {
        MemberVO member = mapper.findByUsername(username); // 주어진 사용자 이름으로 회원정보 조회
        return member != null ? true : false; // 이미 있는 사용자라면 true 반환(중복 여부 반환)
    }

    @Override
    public MemberDTO get(String username) {
//        주어진 사용자 이름으로 회원 정보 조회, 없으면 예외 발생
        MemberVO member = Optional.ofNullable(mapper.get(username))
                .orElseThrow(NoSuchElementException::new);
        return MemberDTO.of(member); // 회원 정보를 DTO로 변환하여 반환
    }

    // 아바타 이미지 업로드
    private void saveAvatar(MultipartFile avatar, String username) {
        if(avatar != null && !avatar.isEmpty()) { // 아바타가 존재하는 경우에만 조건문 실행
            File dest = new File("c:/upload/avatar", username + ".png"); // 저장할 경로 설정
            try {
                avatar.transferTo(dest);
            } catch (IOException e) {
                throw new RuntimeException(e); // 오류 발생 시 런타임 예외로 발생시킴
            }
        }
    }

    @Transactional
    @Override
    public MemberDTO join(MemberJoinDTO dto) {
        MemberVO member = dto.toVO();

        member.setPassword(passwordEncoder.encode(member.getPassword())); // 비밀번호 암호화
        mapper.insert(member);

        AuthVO auth = new AuthVO();
        auth.setUsername(member.getUsername());
        auth.setAuth("ROLE_MEMBER");
        mapper.insertAuth(auth);

        saveAvatar(dto.getAvatar(), member.getUsername());

        return get(member.getUsername());
    }
}