package org.scoula.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.scoula.security.account.mapper.UserDetailsMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Log4j
@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserDetailsMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // mapper.xml의 sql문이 실행되며 username에 해당하는 정보 가져오기
        MemberVO vo = mapper.get(username);
        log.info(vo);
        // 사용자 정보가 존재하지 않으면 예외 발생
        if(vo == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUser(vo);
    }
}