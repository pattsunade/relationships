
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Person New</title>
</head>
<body>
    <h1>New Person</h1>
    <div>
        <form:form class="center" action="/persons/new" method="post" modelAttribute="person">
        <p>
        <form:label path="firstName">FirstName: </form:label>
        <form:errors path="firstName"/>
        <form:input  path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">LastName: </form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>    
     
    <input type="submit" value="Create"/>
</form:form>    
    </div>
</body>
</html>