<%-- 
    Document   : updateclass
    Created on : Oct 31, 2022, 12:11:50 AM
    Author     : nhn19
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhật thông tin lớp học</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <div class="content-layout">
            <h1 class="d-flex justify-content-center">Cập nhật thông tin lớp học</h1>
            <form action="" method="POST">
                <div class="input-group mb-3">
                    <span class="input-group-text width-150">Mã môn</span>
                    <input type="text" class="form-control" id="txtName" name="mamonmoi" value="${requestScope.thongtinlop.subject.subjectID}">
                </div>
                <p>${requestScope.kiemtralop.subjectID}</p>
                <div class="input-group mb-3">
                    <span class="input-group-text width-150">Tên môn</span>
                    <input type="text" class="form-control" id="txtName" name="tenmon" value="${requestScope.thongtinlop.subject.subjectName}">
                </div>
                <p>${requestScope.kiemtralop.subjectName}</p>
                <div class="input-group mb-3">
                    <span class="input-group-text width-150">Thời gian bắt đầu</span>
                    <input type="text" class="form-control" id="txtName" name="batdau" value="${requestScope.thongtinlop.timeStart}">
                </div>
                <p>${requestScope.kiemtralop.timeStart}</p>

                <div class="input-group mb-3">
                    <span class="input-group-text width-150">Thời gian kết thúc</span>
                    <input type="text" class="form-control" id="txtName" name="ketthuc" value="${requestScope.thongtinlop.timeEnd}">
                </div>
                <p>${requestScope.kiemtralop.timeEnd}</p>

                <div class="input-group mb-3">
                    <button type="submit" class="btn btn-primary margin-auto">Cập nhật</button>
                </div>
            </form>
    
                <a href="danhsachlopcuagv?magv=${requestScope.magv}">Quay lại</a>
            <a href="trangchu" class="btn btn-link d-flex justify-content-end">Trang Chủ</a>
        </div>
    </body>
</html>
