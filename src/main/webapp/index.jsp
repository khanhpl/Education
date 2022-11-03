<%-- 
    Document   : index
    Created on : Nov 2, 2022, 1:33:58 PM
    Author     : nhn19
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="content-layout">
            <table border="1"  class="table table-striped">
                <thead>
                <th>Tên giáo viên</th>
                <th>Email</th>
                <th>Điện thoại</th>
                <th>Thông tin lớp học</th>
                </thead>
                <tbody>
                <c:forEach var="row" items="${requestScope.teacher}">
                    <c:if test="${!empty row.teacherID}">
                        <tr>
                            <td><c:out value="${row.name}"/></td>
                        <td><c:out value="${row.email}"/></td>
                        <td><c:out value="${row.phone}"/></td>

                        <td>
                            <div class="margin-auto">
                                <a href="danhsachlopcuagv?magv=${row.teacherID}" class="btn btn-warning width-percentage-45">Chi tiết</a>
                            </div>
                        </td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
           
            <a href="trangchu" class="btn btn-link d-flex justify-content-end">Trang Chủ</a>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
