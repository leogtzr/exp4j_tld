<%-- 
    Document   : index
    Created on : 15/10/2014, 11:05:06 PM
    Author     : Leo Gutierrez R. <leogutierrezramirez@gmail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="expr4j" uri="/WEB-INF/tlds/exp4jtld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>exp4j with jsp tags</h1>

        <c:set var="expr_str" value="sin(x)" />
        <c:set var="x" value="4" />

        <%--
            Using exp4j jsp tag with expression language:
        --%>
        <h3>
            <expr4j:expr expr="${expr_str}" x="${x}">
                x = ${x}, ${expr_str} = 
            </expr4j:expr>
        </h3>
        <%--
            Using exp4j jsp tag without tag body:
        --%>
        <h3>
            <expr4j:expr expr="sin(x)" x="4" />
        </h3>

        <%--
            Using exp4j jsp tag with other tags:
        --%>
        <h3>
            <expr4j:expr x="2" y="3">
                <jsp:attribute name="expr">
                    2  + ${x}^2 - cos(sin(x^y))
                </jsp:attribute>
            </expr4j:expr>
        </h3>

    </body>
</html>
