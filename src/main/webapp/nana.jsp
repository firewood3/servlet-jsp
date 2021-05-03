<%--
  Created by IntelliJ IDEA.
  User: gchsj
  Date: 2021-03-22
  Time: 오후 5:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String cnt_ = request.getParameter("cnt");
    int cnt = 5;
    if(cnt_!=null && !cnt_.equals("")) {
        cnt = Integer.parseInt(cnt_);
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
    for(int i=0; i<cnt; i++) {
    %>
        안녕 servlet<br/>
    <%
    }
    %>
</body>
</html>
