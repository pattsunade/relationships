<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
</head>
<body>
    <div>
        <p>
            <h1><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
			<h2>License Number: <c:out value="${person.license.number}"/></h2>
			<h2>State: <c:out value="${person.license.state}"/></h2>
			<h2>Expiration Date: <c:out value="${person.license.expirationDate}"/></h2>
        </p>
    </div>
</body>
</html>