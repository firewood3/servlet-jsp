package com.gchsj.sevlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/life-cycle")
public class LifeCycle extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("[life-cycle] init config");
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("[life-cycle] init");
        super.init();
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("[life-cycle] service");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("lift-cycle");
    }

    @Override
    public void destroy() {
        System.out.println("[life-cycle] destroy");
        super.destroy();
    }
}
