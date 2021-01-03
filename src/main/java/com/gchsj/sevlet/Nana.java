package com.gchsj.sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class Nana extends HttpServlet {
//    기본적으로 MS 엣지: html로 해석, 크롬: text로 해석
//
//    브라우저에 컨텐츠 형식을 알려주는 서블릿 출력 형식 지정 필요

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<meta charset=\"UTF-8\">");
//        out.println("<title>Title</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<p>welcome!!!!</p>");
//        out.println("<p>welcome!!!!</p>");
//        out.println("<p>한글출력~</p>");
//        out.println("</body>");
//        out.println("</html>");

        String sCnt = request.getParameter("cnt");
        int iCnt = 100;
        if (sCnt != null && !sCnt.equals("")) {
            iCnt = Integer.parseInt(request.getParameter("cnt"));
        }

        for (int i=0; i<iCnt; i++) {
            out.println("안녕 Servlet <br/>");
        }

    }
}
