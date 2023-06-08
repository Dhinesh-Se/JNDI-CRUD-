<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
    <h1>Add Employee</h1>

    <form action="${pageContext.request.contextPath}/employee/add" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br><br>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required>
        <br><br>
        <input type="submit" value="Save">
    </form>

    <p>${message}</p>
</body>
</html>
