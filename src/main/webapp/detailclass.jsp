<%-- 
    Document   : detailclass
    Created on : Oct 30, 2022, 11:10:33 AM
    Author     : nhn19
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin lớp</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <div class="content-layout">
            <h1 class="d-flex justify-content-center">Thông tin lớp</h1>
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Mã lớp</span>
                <label class="form-control"><c:out value="${requestScope.thongtinlop.classID}"/></label>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Tên môn học</span>
                <label class="form-control"><c:out value="${requestScope.thongtinlop.subject.subjectName}"/></label>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Thời gian bắt đầu</span>
                <label class="form-control"><c:out value="${requestScope.thongtinlop.timeStart}"/></label>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Thời gian kết thúc</span>
                <label class="form-control"><c:out value="${requestScope.thongtinlop.timeEnd}"/></label>
            </div>
            <table border="1"  class="table table-striped">
                <thead>
                <th>Mã sinh viên</th>
                <th>Tên sinh viên</th>
                <th>Email</th>
                <th>Điện thoại</th>
                <th>Thao tác</th>
                </thead>
                <tbody>
                    <c:forEach var="row" items="${requestScope.thongtinlop.students}">
                        <c:if test="${!empty row.studentID}">
                            <tr>
                                <td><c:out value="${row.studentID}"/></td>
                                <td><c:out value="${row.name}"/></td>
                                <td><c:out value="${row.email}"/></td>
                                <td><c:out value="${row.phone}"/></td>                    
                                <td>
                                    <div class="margin-auto">
                                        <a href="suathongtin?masinhvien=${row.studentID}&malop=${requestScope.thongtinlop.classID}&magv=${requestScope.magv}&mamon=${requestScope.mamon}" class="btn btn-warning width-percentage-45">Sửa thông tin sinh viên</a>
                                        <a href="xoasinhvien?masinhvien=${row.studentID}&malop=${requestScope.thongtinlop.classID}&magv=${requestScope.magv}&mamon=${requestScope.mamon}" class="btn btn-danger width-percentage-45">Xóa</a>
                                    </div>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
            <a href="danhsachlopcuagv?magv=${requestScope.magv}">Quay lại</a>
            <div class="d-flex justify-content-end">
                <a class="btn btn-success mb-1" href="themsinhvien?malop=${requestScope.malop}&magv=${requestScope.magv}&mamon=${requestScope.mamon}"">Đăng ký sinh viên</a>
            </div> 
            <a href="trangchu" class="btn btn-link d-flex justify-content-end">Trang Chủ</a>
        </div>
    </body>
</html>
