<%-- 
    Document   : teacherinfo
    Created on : Oct 31, 2022, 12:05:30 PM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin giáo viên</title>
    </head>
    <body>
        <h3>
            <div> 
                <c:if test="${!empty sessionScope.tendangnhap}">
                    Xin chào : <c:out value="${sessionScope.tendangnhap}"/> </br>
                    <a href="dangxuat">Dang Xuat</a>
                </c:if>   
            </div>
            <div>
                <c:if test="${empty sessionScope.tendangnhap}">  
                    <a href="dangnhap">Dang Nhap</a>
                </c:if>   
            </div>
            <hr/>
    </body>
</html>
