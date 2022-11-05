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
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Mã giáo viên</span>
                <input type="text" class="form-control" id="txtName" name="magv" value="${gvcu.teacherID}">               
            </div>
            <p>${requestScope.kiemtragv.teacherID}</p>
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Tên giáo viên</span>
                <input type="text" class="form-control" id="txtName" name="tengv" value="${gvcu.name}">               
            </div>
            <p>${requestScope.kiemtragv.name}</p>
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Email</span>
                <input type="text" class="form-control" id="txtName" name="email" value="${gvcu.email}">                                
            </div>
            <p>${requestScope.kiemtragv.email}</p>
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Điện thoại</span>
                <input type="text" class="form-control" id="txtName" name="dienthoai" value="${gvcu.phone}">                             
            </div>
            <p>${requestScope.kiemtragv.phone}</p>
            <div class="input-group mb-3">
                <button type="submit" class="btn btn-primary margin-auto">Tạo</button>
            </div>
        </form>
        <a href="trangchu" class="btn btn-link d-flex justify-content-end">Trang Chủ</a>

    </body>
</html>
