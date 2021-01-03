package com.gchsj.sevlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class Add extends HttpServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

        int x=0;
        int y=0;
        String x_ = request.getParameter("x");
        String y_ = request.getParameter("y");

        if (x_ != null && !x_.equals("")) {
            x = Integer.parseInt(x_);
        }

        if (y_ != null && !y_.equals("")) {
            y = Integer.parseInt(y_);
        }

        PrintWriter printWriter = response.getWriter();
        printWriter.println(x+y);

    }
}
