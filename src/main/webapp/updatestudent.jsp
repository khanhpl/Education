<%-- 
    Document   : updatestudent
    Created on : Oct 30, 2022, 10:35:10 PM
    Author     : nhn19
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhật thông tin sinh viên</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <div class="content-layout">
        <h1 class="d-flex justify-content-center">Cập nhật thông tin sinh viên</h1>
        <form action="" method="POST">
            <div class="input-group mb-3">
                <!-- <image class="rounded-circle" alt="Avatar" src="${requestScope.thongtinsua.avatar.url}"/> -->
                <image class="rounded-circle width-150 margin-auto" alt="Avatar" src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp"/>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Họ và tên</span>
                <input type="text" class="form-control" id="txtName" name="tensinhvien" value="${requestScope.thongtinsua.name}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Email</span>
                <input type="text" class="form-control" id="txtName" name="email" value="${requestScope.thongtinsua.email}">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Số điện thoại</span>
                <input type="text" class="form-control" id="txtName" name="dienthoai" value="${requestScope.thongtinsua.phone}">
            </div>
            <div class="input-group mb-3">
                <button type="submit" class="btn btn-primary margin-auto">Cập nhật</button>
            </div>
        </form>
        <a href="trangchu" class="btn btn-link d-flex justify-content-end">Trang Chủ</a>
        </div>
    </body>
</html>
