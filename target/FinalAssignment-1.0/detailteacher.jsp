<%-- 
    Document   : detailteacher
    Created on : Oct 31, 2022, 11:47:42 PM
    Author     : nhn19
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div>
            Tên giáo viên: <c:out value="${requestScope.thongtingiaovien.name}"/>
        </div>
        <div>
            Địa chỉ mail: <c:out value="${requestScope.thongtingiaovien.email}"/>
        </div>
        <div>
            Điện thoại: <c:out value="${requestScope.thongtingiaovien.phone}"/>
        </div>

        <br>
        <div>
            <a href="suagv?magv=${requestScope.thongtingiaovien.teacherID}">Sửa giáo viên</a>
        </div> 
          <div>
            <a href="trangchu">Trang chủ</a>
        </div> 
    </body>
</html>
