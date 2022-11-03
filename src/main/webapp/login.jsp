<%-- 
    Document   : login
    Created on : Oct 31, 2022, 11:53:23 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="content-layout width-percentage-45 margin-auto">
        <h1 class="d-flex justify-content-center">Đăng nhập</h1>
        <form action="dangnhap" method="POST" >
            <div class="input-group mb-3">
                <span class="input-group-text width-100">Tài khoản</span>
                <input type="text" class="form-control" id="txtName" name="username"/>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text width-100">Mật khẩu</span>
                <input type="password" class="form-control" id="txtName" name="password"/>
            </div>
            <div class="d-flex">
                <button type="submit" class="btn btn-primary margin-auto"> Đăng nhập </button>
            </div>
        </form>

    </div>

        <a href="trangchu">Bỏ qua</a>
        
        <jsp:include page="footer.jsp"/>

    </body>
</html>
