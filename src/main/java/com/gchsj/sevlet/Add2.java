package com.gchsj.sevlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add2")
public class Add2 extends HttpServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

        String[] num_ = request.getParameterValues("num");
        int result=0;

        for(int i=0; i< num_.length; i++) {
            if (num_[i] != null && !num_[i].equals("")) {
                int num = Integer.parseInt(num_[i]);
                result += num;
            }
        }

        PrintWriter printWriter = response.getWriter();
        printWriter.println(result);

    }
}
