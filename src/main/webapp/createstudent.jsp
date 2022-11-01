<%-- 
    Document   : createstudent
    Created on : Oct 30, 2022, 3:39:38 PM
    Author     : nhn19
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm sinh viên</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <form action="" method="POST">
            <div style="display: flex" class="input-group mb-3">
                <span class="input-group-text width-150">Mã sinh viên</span>
                <input type="text" class="form-control" id="txtName" name="masinhvien" value="${sinhviencu.studentID}">
            </div>
            <div style="display: flex" class="input-group mb-3">
                <span class="input-group-text width-150">Tên sinh viên</span>
                <input type="text" class="form-control" id="txtName" name="tensinhvien" value="${sinhviencu.name}">
            </div>
            <div style="display: flex" class="input-group mb-3">
                <span class="input-group-text width-150">Email</span>
                <input type="text" class="form-control" id="txtName" name="email" value="${sinhviencu.email}">
            </div>
            <div style="display: flex" class="input-group mb-3">
                <span class="input-group-text width-150">Điện thoại</span>
                <input type="text" class="form-control" id="txtName" name="dienthoai" value="${sinhviencu.phone}">
            </div>
            <div style="display: flex" class="input-group mb-3">
                <span class="input-group-text width-150">Ảnh</span>
                <input type="text" class="form-control" id="txtName" name="anh">
            </div>
            <div class="input-group mb-3">
                <button type="submit" class="btn btn-primary margin-auto">Tạo mới</button>
            </div>
        </form>
        <a href="trangchu" class="btn btn-link d-flex justify-content-end">Trang Chủ</a>

    </body>
</html>
