<%-- 
    Document   : result
    Created on : 6/12/2014, 12:49:11 PM
    Author     : Leo Gutierrez R. <leogutierrezramirez@gmail.com>
--%>

<%@page import="net.objecthunter.exp4j.function.Function"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="expr4j" uri="/WEB-INF/tlds/exp4jtld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>exp4j with custom functions</h1>
        
        <c:set var="expr_str" value="fibonacci(x) + cos(y)^2" scope="page"/>
                
        <h3>
            <%--The implementation of the custom function is in the SetCustomFunctionExp4JServlet.java --%>
            <expr4j:expr expr="${expr_str}" customFunction="${fibo}" x="8" y="2">
                Result ... 
            </expr4j:expr>
        </h3>
            
            <%
                Function testFunc = new Function("test", 1) {
                    @Override
                    public double apply(double ... args) {
                        return args[0];
                    }
                };
                pageContext.setAttribute("testFunc", testFunc);
            %>
            
            <expr4j:expr expr="test(1 + 2)" customFunction="${testFunc}" >
                Result ... 
            </expr4j:expr>

    </body>
</html>
