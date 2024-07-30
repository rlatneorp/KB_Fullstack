package org.scoula.ex03.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//모든 url 패턴에 대해 필터를 적용하겠다
//@WebFilter 어노테이션 적용해야 필터로 인식
@WebFilter(urlPatterns= {"/*"})
public class CharacterEncodeFilter implements Filter { // Filter인터페이스 구현 필수

//    필터 초기화 메소드, 필터가 생성될때 호출된다
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

//    필터 소멸 메소드. 필터가 소멸될때 호출된다 자원 해제 작업 수행
    @Override
    public void destroy() {
    }

//    실제 로직을 구현하는 메소드, request와 response를 받아올때 필터가 수행할 작업
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8"); // request의 문자 인코딩 UTF-8로 변경

        // 다음 필터나 서블릿으로 요철과 응답 전달
        chain.doFilter(request, response);
    }
}
