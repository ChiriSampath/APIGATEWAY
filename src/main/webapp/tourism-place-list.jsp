<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tourism Place List</title>
</head>
<body>
    <h1>Tourism Places</h1>
    <a href="/tourism-places/add">Add New Tourism Place</a>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Location</th>
            <th>Description</th>
            <th>Entry Fee</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="tourismPlace" items="${tourismPlaces}">
            <tr>
                <td>${tourismPlace.id}</td>
                <td>${tourismPlace.name}</td>
                <td>${tourismPlace.location}</td>
                <td>${tourismPlace.description}</td>
                <td>${tourismPlace.entryFee}</td>
                <td>
                    <a href="/tourism-places/edit/${tourismPlace.id}">Edit</a> |
                    <a href="/tourism-places/delete/${tourismPlace.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
