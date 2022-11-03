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
        <title>Cập nhật thông tin giáo viên</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="content-layout">
            <h1 class="d-flex justify-content-center">Cập nhật thông tin giáo viên</h1>
        <form action="" method="POST">
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Mã Giáo Viên</span>
                <input type="text" class="form-control" id="txtName" name="magv" value="${requestScope.thongtingiaovien.teacherID}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Tên Giáo Viên</span>
                 <input type="text" class="form-control" id="txtName" name="tengv" value="${requestScope.thongtingiaovien.name}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Email</span>
                 <input type="text" class="form-control" id="txtName" name="mail" value="${requestScope.thongtingiaovien.email}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Số Điện Thoại</span>
                 <input type="text" class="form-control" id="txtName" name="sdt" value="${requestScope.thongtingiaovien.phone}">
            </div>
            <div class="input-group mb-3">
                <button type="submit" class="btn btn-primary margin-auto">Cập nhật</button>
            </div>
        </form>
        <a href="trangchu" class="btn btn-link d-flex justify-content-end">Trang Chủ</a>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
