<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isErrorPage="true" %>
<!-- isErrorPage="ture" -->
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
    <script
            src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/gs"
           method="POST" modelAttribute="gs" enctype="multipart/form-data">

    <c:if test="${gs.sid != 0}">
        <form:hidden path="sid"/><br>
        <fmt:message key="td.gongsi"></fmt:message>:<form:input path="yuangong"/>
        <br>
        <input type="hidden" name="_method" value="PUT">
    </c:if>


    <c:if test="${gs.sid == 0}">
        <fmt:message key="td.gongsi"></fmt:message>:<form:input path="yuangong"/>

        <br>
    </c:if>


    <%-- <c:if test="${gs.sid != 0}">
        <form:hidden path="sid" />
        <br>

        <fmt:message key="td.yong"></fmt:message>:<form:select path="gs_id"
            items="${yg}" itemLabel="yuangong" itemValue="sid"></form:select>
        <br>
    <form:errors path="gs.yuangong"></form:errors>
        <br>
        <input type="hidden" name="_method" value="PUT">
        <br>
    </c:if>


    <c:if test="${user.id == 0}">
        <fmt:message key="td.yong"></fmt:message>:<form:select path="gs.sid"
            items="${yg}" itemLabel="yuangong" itemValue="sid"></form:select>
        <br>

        <br>
    </c:if> --%>


    <input type="submit">
</form:form>

</body>
</html>