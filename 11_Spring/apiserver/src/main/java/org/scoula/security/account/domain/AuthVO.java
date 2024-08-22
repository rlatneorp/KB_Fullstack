package org.scoula.security.account.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data
public class AuthVO implements GrantedAuthority {
    // grantedauthority는 인터페이스, 권한을 가져오는 인터페이스.
    private String username;
    private String auth;

    @Override
    public String getAuthority() {
        // 권한정보만 추출하는 메서드.
        return auth;
    }
}
