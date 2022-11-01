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
                    <jsp:include page="teacherinfo.jsp"></jsp:include>
                    <h1 class="d-flex justify-content-center">Danh sách lớp học</h1>

                    <table border="1" class="table table-striped">
                        <thead>
                            <tr>
                                <th>Mã lớp</th>
                                <th>Môn học</th>
                                <th>Thời gian bắt đầu</th>
                                <th>Thời gian kết thúc</th>
                                <th>Thao tác</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="row" items="${requestScope.school.teacher.listClasses}">
                                <c:if test="${!empty row.classID}">
                                    <tr>
                                        <td>
                                            <c:out value="${row.classID}" />
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
                                                <a href="chitietlop?malop=${row.classID}"
                                                    class="btn btn-success width-percentage-30">Chi tiết</a>
                                                <a href="sualop?malop=${row.classID}"
                                                    class="btn btn-warning width-percentage-30">Sửa</a>
                                                <a href="xoalop?malop=${row.classID}"
                                                    class="btn btn-danger width-percentage-30">Xóa</a>
                                            </div>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="d-flex justify-content-end">
                        <a href="taolop" class="btn btn-primary">Tạo mới</a>
                    </div>
            </body>

            </html>