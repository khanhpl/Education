<%-- 
    Document   : updateteacher
    Created on : Oct 31, 2022, 1:10:00 PM
    Author     : HP
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
    
        <form action="" method="POST">
            <div>
                Mã Giáo Viên <input type="text" id="txtName" name="magv" value="${requestScope.thongtingiaovien.teacherID}">
            </div>
            <div>
                Tên Giáo Viên <input type="text" id="txtName" name="tengv" value="${requestScope.thongtingiaovien.name}">
            </div>
            <div>
                Email <input type="text" id="txtName" name="mail" value="${requestScope.thongtingiaovien.email}">
            </div>
            <div>
                Số Điện Thoại <input type="text" id="txtName" name="sdt" value="${requestScope.thongtingiaovien.phone}">
            </div>
            <div>
                <button type="submit">Cập nhật</button>
            </div>
        </form>
        <a href="trangchu">Trang Chủ</a>
    </body>
</html>
