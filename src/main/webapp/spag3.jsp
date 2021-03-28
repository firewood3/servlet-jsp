<%--
  Created by IntelliJ IDEA.
  User: gfire
  Date: 2021-03-27
  Time: 오전 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Model 2 방식--%>
<%
    pageContext.setAttribute("result", "page result");
%>
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
    EL 저장소 우선순위<br>
    ${result}<br>
    pageScope 저장소: ${pageScope.result}<br>
    requestScope 저장소: ${requestScope.result}<br>
    sessionScope 저장소: ${sessionScope.result}<br>
    applicationScope 저장소: ${applicationScope.result}<br>
    param 저장소: ${param.abc}<br>
    param 저장소: ${param.n}<br>
    ${header.accept}<br>
    ${pageContext.request.method}<br>
</body>
</html>
