<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>New Dormitorio</title>
</head>
<body>
    <div class="container">
        <h1>New Dormitorio</h1>
        <form:form class="center" action="/dormitorio/create" method="post" modelAttribute="dormitorio">
            <p>
                <form:label path="name">Name: </form:label>
                <form:errors path="name"/>
                <form:input  path="name"/>
            </p>
            <input type="submit" value="Create"/>
        </form:form> 
    </div>
</body>
</html>
