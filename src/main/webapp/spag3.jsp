<%--
  Created by IntelliJ IDEA.
  User: gfire
  Date: 2021-03-27
  Time: 오전 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Model 2 방식--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%=request.getAttribute("result")%>입니다.<br>
    ${result}<br>
<%--    EL을 사용하여 출력 --%>
    ${names[0]}<br>
    ${list[0]}<br>
    ${map.city}<br>

</body>
</html>
