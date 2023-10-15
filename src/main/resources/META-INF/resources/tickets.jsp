<!DOCTYPE html>
<html>
<head>
    <title>Affichage des Tickets</title>
</head>
<body>
<h1>Affichage des Tickets</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Titre</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ticket" items="${tickets}">
        <tr>
<%--            <td>${ticket.id}</td>--%>
            <td>${ticket.title}</td>
            <td>${ticket.description}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

