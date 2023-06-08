<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
</head>
<body>
    <h1>Edit User</h1>
    <form method="post" action="/edit/${user.id}">
        <label>Username:</label>
        <input type="text" name="username" value="${user.username}" required><br><br>
        <label>Email:</label>
        <input type="email" name="email" value="${user.email}" required><br><br>
        <input type="submit" value="Update User">
    </form>
    <a href="/">Back to List</a>
</body>
</html>