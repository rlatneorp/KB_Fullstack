package org.scoula.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController // json으로 반환할 때
@RequiredArgsConstructor // 필드 중에 final 있을 때
@RequestMapping("/api/member")
public class MemberController {
    final MemberService service;

//    @PathVariable : 경로 상에 username을 변수 처리(이름 일치해야함)
    @GetMapping("/checkusername/{username}") // 경로에 중괄호 있으면 @PathVariable
//    body리턴 값이라 Boolean 제너릭
    public ResponseEntity<Boolean> checkUsername(@PathVariable String username) {
//        주어진 사용자 이름의 중복 여부 체크하고 결과를 ResponseEntity로 반환
        return ResponseEntity.ok().body(service.checkDuplicate(username));
    }

    @PostMapping("")
    public ResponseEntity<MemberDTO> join(MemberJoinDTO member) {
//        회원 가입 처리하고 가입된 회원 정보를 ResponseEntity로 반환
        return ResponseEntity.ok(service.join(member));
    }
}
