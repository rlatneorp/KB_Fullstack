package org.scoula.controller;

import lombok.extern.log4j.Log4j;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j
@RequestMapping("/api/security")
@RestController
public class SecurityController {
    @GetMapping("/all")
    public ResponseEntity<String> doAll() {
        log.info("doAll");
        return ResponseEntity.ok("All can access");
    }

    // name 추출 방법들 Authentication 사용.
    @GetMapping("/member")
    public ResponseEntity<String> doMember(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        log.info("user name : " + userDetails.getUsername());
        return ResponseEntity.ok(userDetails.getUsername());
    }

    // 커스텀한 User 정보 추출. @AuthenticationPrincipal 사용.
    @GetMapping("/admin")
    public ResponseEntity<MemberVO> doAdmin(@AuthenticationPrincipal CustomUser customUser) {
        MemberVO member = customUser.getMember();
        log.info("username = " + member);
        return ResponseEntity.ok(member);
    }

    @GetMapping("/login")
    public void login() {
        log.info("login page");
    }

    @GetMapping("/logout")
    public void logout() {
        log.info("logout page");
    }
}
