package com.gchsj.sevlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc3")
public class Calc3 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application =  request.getServletContext();
        HttpSession session = request.getSession();

        System.out.println("server sid : " + session.getId());
        System.out.println("client sid : " + request.getRequestedSessionId());

        String v_ = request.getParameter("v");
        String op = request.getParameter("op");

        Cookie[] cookies = request.getCookies();


        int v = 0;
        if (v_ != null && !v_.equals("")) {
            v = Integer.parseInt(v_);
        }

        int result = 0;
        if (op.equals("=")) {
//            int x = (Integer) application.getAttribute("v");
//            int x = (Integer) session.getAttribute("v");

            int x = 0;
            for(Cookie cookie : cookies) {
                if (cookie.getName().equals("v")) {
                    x = Integer.parseInt(cookie.getValue());
                    break;
                }
            }

            int y = v;
//            String operator = (String) application.getAttribute("op");
//            String operator = (String) session.getAttribute("op");
            String operator="";
            for(Cookie cookie : cookies) {
                if (cookie.getName().equals("op")) {
                    operator = cookie.getValue();
                    break;
                }
            }

            if (operator.equals("+")) {
                result = x+y;
            } else {
                result = x-y;
            }

            PrintWriter printWriter = response.getWriter();
            printWriter.println(result);
        } else {
//        Key와 Value, Map과 같은 객체
//            application.setAttribute("v", v);
//            application.setAttribute("op", op);
//            session.setAttribute("v", v);
//            session.setAttribute("op", op);
            Cookie vCookie = new Cookie("v", String.valueOf(v));
            Cookie opCookie = new Cookie("op", op);
            vCookie.setPath("/calc2");
            vCookie.setMaxAge(24*60*60);
            opCookie.setPath("/calc2");
            response.addCookie(vCookie);
            response.addCookie(opCookie);

            response.sendRedirect("calc3.html");
        }
    }
}
