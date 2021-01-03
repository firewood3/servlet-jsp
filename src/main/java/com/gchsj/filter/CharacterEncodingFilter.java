package com.gchsj.filter;

import com.gchsj.util.IpAddress;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        요청이 올때마다 실행됨. 톰켓이 처음 구동될때도 실행됨


        if (request instanceof HttpServletRequest) {
            System.out.println("Is New Session : " + ((HttpServletRequest)request).getSession().isNew());
            System.out.println("URL: " + ((HttpServletRequest)request).getRequestURL());
            System.out.println("URI: " + ((HttpServletRequest)request).getRequestURI());
            System.out.println("ContextPath: " + ((HttpServletRequest)request).getContextPath());
            System.out.println("RemoteHost: " + ((HttpServletRequest)request).getRemoteHost());
            System.out.println("ClientIp: " + IpAddress.getClientIp(((HttpServletRequest)request)));
        }

        request.setCharacterEncoding("UTF-8"); // 요청은 UTF-8로 인코딩 되어있다. // 들어오는 인코딩
        System.out.println("before filter");
        filterChain.doFilter(request, response);
        System.out.println("after filter");
    }

    @Override
    public void destroy() {

    }
}
