package com.gchsj.sevlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 Model 2 방식. 현재는 하나의 서블릿이 frontController 기능과 dispatcher 기능의 두 개의 역할을 하고있다.
 */
@WebServlet("/spag3")
public class spag3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num = 0;
        String num_ = request.getParameter("n");
        if(num_!=null && !num_.equals("")) {
            num = Integer.parseInt(num_);
        }
        String model;
        if(num%2==0) {
            model = "짝수";
        } else {
            model = "홀수";
        }

//         EL 출력으로 사용해볼 예제 입력
        String[] names= {"servlet", "jsp"};
        request.setAttribute("names", names);

        List<String> list = new ArrayList<>();
        list.add("hong");
        list.add("seok");
        request.setAttribute("list", list);

        Map<String, String> map = new HashMap<>();
        map.put("city", "jeju");
        map.put("country", "korea");
        request.setAttribute("map", map);

        request.setAttribute("result", model);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("spag3.jsp");
        requestDispatcher.forward(request, response);
    }
}
