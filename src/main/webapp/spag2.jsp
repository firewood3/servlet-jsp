<%--
  Created by IntelliJ IDEA.
  User: gfire
  Date: 2021-03-27
  Time: 오전 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- model 1 방식--%>
<%
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
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=model%>입니다.
</body>
</html>
