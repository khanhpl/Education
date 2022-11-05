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
        <title>Thông tin giáo viên</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="content-layout">
            <h1 class="d-flex justify-content-center">Thông tin giáo viên</h1>
        <div class="input-group mb-3">
            <span class="input-group-text width-150">Tên giáo viên</span>
            <label class="form-control"><c:out value="${requestScope.thongtingiaovien.name}"/></label>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text width-150">Địa chỉ mail</span>
            <label class="form-control"><c:out value="${requestScope.thongtingiaovien.email}"/></label>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text width-150">Điện thoại</span>
            <label class="form-control"><c:out value="${requestScope.thongtingiaovien.phone}"/></label>
        </div>
        <br>
        <div class="d-flex justify-content-end">
            <a href="suagv?magv=${requestScope.thongtingiaovien.teacherID}" class="btn btn-primary">Cập nhật thông tin</a>
        </div> 
        <a href="trangchu" class="btn btn-link d-flex justify-content-end">Trang Chủ</a>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
