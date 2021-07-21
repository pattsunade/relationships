<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Contact Inf</title>
</head>
<body>
    <div class="container">
        <h1>Contact Info</h1>
        <form:form class="center" action="/contact/create" method="post" modelAttribute="contact">
        <p>
            <form:label path="students">Student: </form:label>
            <form:errors path="students"/>
            <form:select path ="students">
            <c:forEach items="${students}" var="students">
                <form:option value="${students.id}"><c:out value="${students.firstName} ${students.lastName}"/></form:option>
            </c:forEach>
        </form:select>
        </p>
        <p>
            <form:label path="address">Address: </form:label>
            <form:errors path="address"/>
            <form:input  path="address"/>
        </p>
        <p>
            <form:label path="city">City: </form:label>
            <form:errors path="city"/>
            <form:input  path="city"/>
        </p>
        <p>
            <form:label path="state">State: </form:label>
            <form:errors path="state"/>
            <form:input  path="state"/>
        </p>
    
     
    <input class="buttom" type="submit" value="add"/>
</form:form>    
    </div>
</body>
</html>