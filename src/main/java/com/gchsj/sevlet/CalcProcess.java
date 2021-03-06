package com.gchsj.sevlet;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc-process")
public class CalcProcess extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String value = request.getParameter("v");
        String op = request.getParameter("op");
        String dot = request.getParameter("dot");

        String exp = "";

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for(Cookie cookie : cookies) {
                if (cookie.getName().equals("exp")) {
                    exp = cookie.getValue();
                    break;
                }
            }
        }

        if(op!=null && op.equals("=")) {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            try {
                exp = String.valueOf(engine.eval(exp));
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        } else if(op!=null && op.equals("C")) {
            exp = "";
        }
        else {
            exp += (value == null)? "":value;
            exp += (op == null)? "":op;
            exp += (dot == null)? "":dot;
        }

        Cookie cookie = new Cookie("exp", exp);
        if(op!=null && op.equals("C")) {
            cookie.setMaxAge(0);
        }
        response.addCookie(cookie);
        response.sendRedirect("calc-page");
    }
}
