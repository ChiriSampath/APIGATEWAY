<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Homestay</title>
</head>
<body>
    <h1>Add New Homestay</h1>
    <form:form action="/homestays/add" modelAttribute="homestay">
        <table>
            <tr>
                <td><label for="name">Name:</label></td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td><label for="location">Location:</label></td>
                <td><form:input path="location" /></td>
            </tr>
            <tr>
                <td><label for="description">Description:</label></td>
                <td><form:textarea path="description" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Save" />
               
