<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Students</title>
</head>
<body>
    
<div class="container">
    <h1>All Students</h1>
        <table class="table table-dark table-striped">
    <thead>
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Addres</th>
            <th>City</th>
            <th>State</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="student" items="${students}">
        <tr>

            <td><c:out value="${student.firstName}"/> <c:out value="${student.lastName}"/></td>
            <td><c:out value="${student.age}"/></td>
            <td><c:out value="${student.contact.address}"/></td>
            <td><c:out value="${student.contact.city}"/></td>
            <td><c:out value="${student.contact.state}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
    </div>
</body>
</html>