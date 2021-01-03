package com.gchsj.sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet {
//    기본적으로 MS 엣지: html로 해석, 크롬: text로 해석
//
//    브라우저에 컨텐츠 형식을 알려주는 서블릿 출력 형식 지정 필요

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8"); // 보내는 문자열을 2byte씩 묶어서 인코딩하겠다. // 나가는 인코딩
        response.setContentType("text/html; charset=UTF-8"); // 파일은 2byte씩 UTF-8로 인코딩 되어있다.
//        request.setCharacterEncoding("UTF-8"); // 요청은 UTF-8로 인코딩 되어있다. // 들어오는 인코딩

        PrintWriter out = response.getWriter();

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        System.out.println(title);
        System.out.println(content);
        System.out.println("한글 출력");
        out.println(title);
        out.println(content);
    }
}
