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
        <title>JSP Page</title>
    </head>
    <body>
        <form action="dangnhap" method="POST" >
            <div>
                Tai Khoan: <input type="text" id="txtName" name="username"/>
            </div>
            <div>
                Mat Khau: <input type="password" id="txtName" name="password"/>
            </div>
            <div>
                <button type="submit"> Dang Nhap </button>
            </div>
        </form>
        <a href="trangchu">Bỏ qua</a>
    </body>
</html>
