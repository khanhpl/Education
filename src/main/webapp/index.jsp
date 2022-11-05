<%-- 
    Document   : index
    Created on : Nov 2, 2022, 1:33:58 PM
    Author     : nhn19
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
    </head>
    <body>
        <div> 
            <c:if test="${!empty sessionScope.tendangnhap}">
                Xin chào : <c:out value="${sessionScope.tendangnhap}"/> </br>
                <a href="dangxuat">Dang Xuat</a>
            </c:if>   
        </div>
        <div>
            <c:if test="${empty sessionScope.tendangnhap}">  
                <a href="dangnhap">Dang Nhap</a>
            </c:if>   
        </div>
        <hr/>
        <h3> Quản Lý Thời KHóa Biểu Theo Ngày </h3>

        <div class="d-flex justify-content-end">
            <a href="themgv" class="btn btn-primary">Thêm giáo viên</a>
        </div>
        <div class="content-layout">
            <table border="1" class="table table-striped">
                <thead>
                    <tr>
                        <th>Tên giáo viên</th>
                        <th>Email</th>
                        <th>Điện thoại</th>
                        <th>Thông tin lớp học</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="row" items="${requestScope.teacher}">
                        <c:if test="${!empty row.teacherID}">
                            <tr>
                                <td><c:out value="${row.name}"/></td>
                                <td><c:out value="${row.email}"/></td>
                                <td><c:out value="${row.phone}"/></td>

                                <td>
                                    <div class="margin-auto">
                                        <a href="danhsachlopcuagv?magv=${row.teacherID}" class="btn btn-success width-percentage-30">Chi tiết</a>
                                        <a href="suagv?magv=${row.teacherID}" class="btn btn-success width-percentage-30">Sửa giáo viên</a>
                                        <a href="xoagv?magv=${row.teacherID}" class="btn btn-success width-percentage-30">Xóa giáo viên</a>
                                    </div>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
