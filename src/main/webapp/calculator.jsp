<%--<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>--%>
<%@ page language="java" pageEncoding="utf-8"%>
<%
    int x = 3;
    int y = 4;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calc4</title>
    <style>
        input {
            width: 50px;
            height: 50px;
        }
        .output {
            height: 50px;
            background: #e9e9e9;
            font-size: 24px;
            font-weight: bold;
            text-align: right;
            padding: 0px 5px;
        }
    </style>
</head>
<body>
    <%
        out.println(x+y);
        out.write(String.valueOf(x+y));
    %>
    y의 값은 : <%=y%>
    <div>
        <form action='calc3' method='post'>
            <table>
                <tr>
                    <td class='output' colspan='4'>${3+4}</td>
                </tr>
                <tr>
                    <td><input type='submit' name='op' value='CE'></td>
                    <td><input type='submit' name='op' value='C'></td>
                    <td><input type='submit' name='op' value='BS'></td>
                    <td><input type='submit' name='op' value='/'></td>
                </tr>
                <tr>
                    <td><input type='submit' name='v' value='7'></td>
                    <td><input type='submit' name='v' value='8'></td>
                    <td><input type='submit' name='v' value='9'></td>
                    <td><input type='submit' name='op' value='*'></td>
                </tr>
                <tr>
                    <td><input type='submit' name='v' value='4'></td>
                    <td><input type='submit' name='v' value='5'></td>
                    <td><input type='submit' name='v' value='6'></td>
                    <td><input type='submit' name='op' value='-'></td>
                </tr>
                <tr>
                    <td><input type='submit' name='v' value='1'></td>
                    <td><input type='submit' name='v' value='2'></td>
                    <td><input type='submit' name='v' value='3'></td>
                    <td><input type='submit' name='op' value='+'></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type='submit' name='op' value='0'></td>
                    <td><input type='submit' name='dot' value='.'></td>
                    <td><input type='submit' name='op' value='='></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
