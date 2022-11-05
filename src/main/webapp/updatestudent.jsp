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
                    <span class="input-group-text width-150">Họ và tên</span>
                    <input type="text" class="form-control" id="txtName" name="tensinhvien" value="${requestScope.thongtinsua.name}">
                </div>
                <p>${requestScope.kiemtrasinhvien.name}</p>

                <div class="input-group mb-3">
                    <span class="input-group-text width-150">Email</span>
                    <input type="text" class="form-control" id="txtName" name="email" value="${requestScope.thongtinsua.email}">
                </div>              
                <p>${requestScope.kiemtrasinhvien.email}</p>

                <div class="input-group mb-3">
                    <span class="input-group-text width-150">Số điện thoại</span>
                    <input type="text" class="form-control" id="txtName" name="dienthoai" value="${requestScope.thongtinsua.phone}">
                </div>             
                <p>${requestScope.kiemtrasinhvien.phone}</p>

                <div class="input-group mb-3">
                    <button type="submit" class="btn btn-primary margin-auto">Cập nhật</button>
                </div>
            </form>
            <a href="chitietlop?magv=${requestScope.magv}&mamon=${requestScope.mamon}&malop=${requestScope.malop}" class="btn btn-link d-flex justify-content-end">Quay lại</a>
            <a href="trangchu" class="btn btn-link d-flex justify-content-end">Trang Chủ</a>
        </div>
    </body>
</html>
