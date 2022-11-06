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
                    Xin chào giáo viên: <c:out value="${sessionScope.tendangnhap}"/>
                </c:if>
            </div>
            <hr/>

            <c:if test="${!empty sessionScope.giaovien.teacherID}">
                <tr>                         
                    <td>
                        <a href="xemttgv?magv=${sessionScope.giaovien.teacherID}">Chi tiết</a>                            
                        <a href="dangxuat">Đăng xuất</a>
                    </td>
                </tr>
            </c:if>

    </body>
</html>
