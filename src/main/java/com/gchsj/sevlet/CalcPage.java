package com.gchsj.sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc-page")
public class CalcPage extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");


        String exp = "0";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for(Cookie cookie : cookies) {
                if (cookie.getName().equals("exp")) {
                    exp = cookie.getValue();
                    break;
                }
            }
        }


        int result = 0;

        PrintWriter out = response.getWriter();

        out.write("<!DOCTYPE html>");
        out.write("<html>");
        out.write("<head>");
            out.write("<meta charset='UTF-8'>");
            out.write("<title>Calc3</title>");
            out.write("<style>");
                 out.write("input {");
                    out.write("width: 50px;");
                    out.write("height: 50px;");
                out.write("}");
                out.write(".output {");
                    out.write("height: 50px;");
                    out.write("background: #e9e9e9;");
                    out.write("font-size: 24px;");
                    out.write("font-weight: bold;");
                    out.write("text-align: right;");
                    out.write("padding: 0px 5px;");
                out.write("}");
            out.write("</style>");
        out.write("</head>");
        out.write("<body>");
            out.write("<div>");
                out.write("<form action='calc-process' method='post'>");
                    out.write("<table>");
                        out.write("<tr>");
                            out.printf("<td class='output' colspan='4'>%s</td>", exp);
                        out.write("</tr>");
                        out.write("<tr>");
                            out.write("<td><input type='submit' name='op' value='CE'></td>");
                            out.write("<td><input type='submit' name='op' value='C'></td>");
                            out.write("<td><input type='submit' name='op' value='BS'></td>");
                            out.write("<td><input type='submit' name='op' value='/'></td>");
                        out.write("</tr>");
                        out.write("<tr>");
                            out.write("<td><input type='submit' name='v' value='7'></td>");
                            out.write("<td><input type='submit' name='v' value='8'></td>");
                            out.write("<td><input type='submit' name='v' value='9'></td>");
                            out.write("<td><input type='submit' name='op' value='*'></td>");
                        out.write("</tr>");
                        out.write("<tr>");
                            out.write("<td><input type='submit' name='v' value='4'></td>");
                            out.write("<td><input type='submit' name='v' value='5'></td>");
                            out.write("<td><input type='submit' name='v' value='6'></td>");
                            out.write("<td><input type='submit' name='op' value='-'></td>");
                        out.write("</tr>");
                        out.write("<tr>");
                            out.write("<td><input type='submit' name='v' value='1'></td>");
                            out.write("<td><input type='submit' name='v' value='2'></td>");
                            out.write("<td><input type='submit' name='v' value='3'></td>");
                            out.write("<td><input type='submit' name='op' value='+'></td>");
                        out.write("</tr>");
                        out.write("<tr>");
                            out.write("<td></td>");
                            out.write("<td><input type='submit' name='op' value='0'></td>");
                            out.write("<td><input type='submit' name='dot' value='.'></td>");
                            out.write("<td><input type='submit' name='op' value='='></td>");
                        out.write("</tr>");
                    out.write("</table>");
                out.write("</form>");
            out.write("</div>");
        out.write("</body>");
        out.write("</html>");



    }
}
