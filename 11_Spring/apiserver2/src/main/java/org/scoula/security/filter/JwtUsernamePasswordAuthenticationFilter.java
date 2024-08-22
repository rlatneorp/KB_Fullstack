package org.scoula.security.filter;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.scoula.security.account.dto.LoginDTO;
import org.scoula.security.handler.LoginFailureHandler;
import org.scoula.security.handler.LoginSuccessHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

@Slf4j
@Component
public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    public JwtUsernamePasswordAuthenticationFilter(
            AuthenticationManager authenticationManager,
            LoginSuccessHandler loginSuccessHandler,
            LoginFailureHandler loginFailureHandler)
    {
        super(authenticationManager);

        setFilterProcessesUrl("/api/auth/login");
        setAuthenticationSuccessHandler(loginSuccessHandler);
        setAuthenticationFailureHandler(loginFailureHandler);
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        LoginDTO login = LoginDTO.of(request);
        //import lombok.sneakythrows
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
        return getAuthenticationManager().authenticate(authenticationToken);
    }
}
