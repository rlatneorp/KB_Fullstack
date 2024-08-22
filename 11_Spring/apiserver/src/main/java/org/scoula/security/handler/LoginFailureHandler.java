package org.scoula.security.handler;

import org.scoula.security.util.JsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        JsonResponse.sendError(response, HttpStatus.UNAUTHORIZED, "incorrect ID / PW");
    }

}
