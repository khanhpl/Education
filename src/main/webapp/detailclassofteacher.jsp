<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách lớp học</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    </head>

    <body>
        <div class="content-layout">

            <div class="input-group mb-3">
                <span class="input-group-text width-150">Tên giáo viên: </span>
                <label class="form-control"><c:out value="${thongtingv.name}"/></label>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Địa chỉ email: </span>
                <label class="form-control"><c:out value="${thongtingv.email}"/></label>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text width-150">Số điện thoại:</span>
                <label class="form-control"><c:out value="${thongtingv.phone}"/></label>
            </div>


            <h1 class="d-flex justify-content-center">Danh sách lớp học</h1>
            <div class="d-flex justify-content-end">
                <a href="taolop?&magv=${requestScope.magv}" class="btn btn-primary">Tạo lớp mới</a>
            </div>

            <table border="1" class="table table-striped">
                <thead>
                    <tr>
                        <th>Mã lớp</th>
                        <th>Mã môn học</th>
                        <th>Môn học</th>
                        <th>Thời gian bắt đầu</th>
                        <th>Thời gian kết thúc</th>
                        <th>Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="row" items="${requestScope.danhsachlop}">
                        <c:if test="${!empty row.classID}">
                            <tr>
                                <td>
                                    <c:out value="${row.classID}" />
                                </td>
                                <td>
                                    <c:out value="${row.subject.subjectID}" />
                                </td>
                                <td>
                                    <c:out value="${row.subject.subjectName}" />
                                </td>
                                <td>
                                    <c:out value="${row.timeStart}" />
                                </td>
                                <td>
                                    <c:out value="${row.timeEnd}" />
                                </td>

                                <td>
                                    <div class="margin-auto">
                                        <a href="chitietlop?malop=${row.classID}&magv=${requestScope.magv}&mamon=${row.subject.subjectID}"
                                           class="btn btn-success width-percentage-30">Chi tiết</a>
                                        <a href="sualop?malop=${row.classID}&magv=${requestScope.magv}&mamon=${row.subject.subjectID}"
                                           class="btn btn-warning width-percentage-30">Sửa</a>
                                        <a href="xoalop?malop=${row.classID}&magv=${requestScope.magv}&mamon=${row.subject.subjectID}"
                                           class="btn btn-danger width-percentage-30">Xóa</a>
                                    </div>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="d-flex justify-content-end">
            <a href="trangchu" class="btn btn-primary">Quay lại</a>
        </div>
        <div class="d-flex justify-content-end">
            <a href="trangchu" class="btn btn-primary">Trang chủ</a>
        </div>
    </body>

</html>