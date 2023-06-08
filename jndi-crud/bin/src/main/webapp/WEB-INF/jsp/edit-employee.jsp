<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
    <h1>Edit Employee</h1>

    <form action="${pageContext.request.contextPath}/employee/edit/${employee.id}" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${employee.name}" required>
        <br><br>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" value="${employee.age}" required>
        <br><br>
        <input type="submit" value="Save">
    </form>

    <p>${message}</p>
</body>
</html>
