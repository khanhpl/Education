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
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Mã giáo viên</span>
                <input type="text" class="form-control" id="txtName" name="magv" value="${gvcu.teacherID}" readonly="">               
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
                <button type="submit" class="btn btn-primary margin-auto">Sửa</button>
            </div>
        </form>
    </body>
</html>
