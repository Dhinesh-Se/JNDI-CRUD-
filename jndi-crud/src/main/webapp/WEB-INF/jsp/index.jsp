<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
</head>
<body>
    <h1>Employee Management</h1>

    <a href="${pageContext.request.contextPath}/employee/add">Add Employee</a>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.age}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/employee/${employee.id}">View</a>
                        <a href="${pageContext.request.contextPath}/employee/edit/${employee.id}">Edit</a>
                        <a href="${pageContext.request.contextPath}/employee/delete/${employee.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <p>${message}</p>
</body>
</html>
