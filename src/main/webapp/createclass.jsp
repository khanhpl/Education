<%-- 
    Document   : createclass
    Created on : Oct 30, 2022, 2:20:49 PM
    Author     : nhn19
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tạo lớp mới</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <div class="content-layout">
            <h1 class="d-flex justify-content-center">Tạo lớp mới</h1>
            <form action="" method="POST">
                <div   class="input-group mb-3">
                    <span class="input-group-text width-150">Mã lớp</span>
                    <input type="text" class="form-control" id="txtName" name="malop" value="${requestScope.lopnhapcu.classID}">
                </div>
                <p>${requestScope.kiemtralop.classID}</p>
                <div class="input-group mb-3">
                    <span class="input-group-text width-150">Thời gian bắt đầu</span>
                    <input type="text" class="form-control" id="txtName" name="batdau" value="${requestScope.lopnhapcu.timeStart}">                   
                </div>
                <p>${requestScope.kiemtralop.timeStart}</p>
                <div  class="input-group mb-3">
                    <span class="input-group-text width-150">Thời gian kết thúc</span>
                    <input type="text" class="form-control" id="txtName" name="ketthuc" value="${requestScope.lopnhapcu.timeEnd}">
                </div>
                <p>${requestScope.kiemtralop.timeEnd}</p>
                <div class="input-group mb-3">
                    <span class="input-group-text width-150">Mã môn học</span>
                    <input type="text" class="form-control" id="txtName" name="mamon" value="${requestScope.lopnhapcu.subject.subjectID}">
                </div>
                <p>${requestScope.kiemtralop.subjectID}</p>
                <div class="input-group mb-3">
                    <span class="input-group-text width-150">Tên môn học</span>
                    <input type="text" class="form-control" id="txtName" name="tenmon" value="${requestScope.lopnhapcu.subject.subjectName}">
                </div>
                <p>${requestScope.kiemtralop.subjectName}</p>
                <div class="input-group mb-3">
                    <button type="submit" class="btn btn-primary margin-auto">Tạo mới</button>
                </div>
            </form>
                <a href="danhsachlopcuagv?magv=${requestScope.magv}">Quay lại</a>
            <a href="trangchu" class="btn btn-link">Trang Chủ</a>
            
        </div>
    </body>
</html>
