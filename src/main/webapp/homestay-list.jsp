<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Homestay List</title>
</head>
<body>
    <h1>Homestay List</h1>
    <a href="/homestays/add">Add New Homestay</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Location</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="homestay" items="${homestays}">
            <tr>
                <td>${homestay.id}</td>
                <td>${homestay.name}</td>
                <td>${homestay.location}</td>
                <td>${homestay.description}</td>
                <td>
                    <a href="/homestays/edit/${homestay.id}">Edit</a> |
                    <a href="/homestays/delete/${homestay.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
