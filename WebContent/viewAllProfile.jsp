<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Contextual Classes</h2>
		<p>Contextual classes can be used to color table rows or table
			cells. The classes that can be used are: .active, .success, .info,
			.warning, and .danger.</p>
		<table class="table">
			<thead>
				<tr>
					<th>Seq</th>
					<th>Email</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listOfProfileModels}" var="profileModel">

					<tr class="success">
						<td>${profileModel.seq}</td>
						<td>${profileModel.email}</td>
						<td>${profileModel.firstName}</td>
						<td>${profileModel.lastName}</td>
						<td>update</td>
						<td><a href="deleteProfileController?seq=${profileModel.seq}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<h3>${deleteSuccessMsg}</h3>
	</div>

</body>
</html>

