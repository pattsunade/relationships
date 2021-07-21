<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>New License</title>
</head>
<body>
    <h1>New License</h1>
    <div>
        <form:form class="center" action="/licenses/new" method="post" modelAttribute="license">
        <p>
        <form:label path="person">Person: </form:label>
        <form:select path="person">
            <c:forEach items="${persons}" var="persona">
                <form:option value="${persona.id}"><c:out value="${persona.firstName} ${persona.lastName}"/></form:option>
            </c:forEach>
        </form:select>
    </p>
    <p>
        <form:label path="number">Numero: </form:label>
        <form:errors path="number"/>
        <form:input path="number"/>
    </p>    
    <p>
        <form:label path="state">State: </form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>    
    <p>
        <form:label path="expirationDate">Expiration Date:</form:label>
        <form:input  type="date" path="expirationDate"/>
    </p>
     
   <input type="submit" value="Create"/>
</form:form>    
    </div>
</body>
</html>