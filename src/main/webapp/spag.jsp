<%--
  Created by IntelliJ IDEA.
  User: gfire
  Date: 2021-03-27
  Time: 오전 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int num = 0;
%>
<html>
<head>
    <title>Title</title>
</head>
<%
    String num_ = request.getParameter("n");
    if(num_!=null && !num_.equals("")) {
        num = Integer.parseInt(num_);
    }
%>
<body>
    <%
        if(num%2==0) {
    %>
    짝수입니다.
    <%
        } else {
    %>
    홀수입니다.
    <%
        }
    %>
</body>
</html>
