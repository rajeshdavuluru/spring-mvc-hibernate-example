<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Management</title>
<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<%@ page isELIgnored="false"%>
<script src="<c:url value="/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h3 class="text-center">Student Management</h3>
			<hr />

			<input type="button" value="Add Student" onclick="window.location.href='form'; return false;"
				class="btn btn-primary" /> <br />
			<br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Student List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Action(s)</th>
						</tr>

						<c:forEach var="studentObj" items="${students}">

							<c:url var="updateLink" value="/student/update">
								<c:param name="studentId" value="${studentObj.id}" />
							</c:url>

							<c:url var="deleteLink" value="/student/delete">
								<c:param name="studentId" value="${studentObj.id}" />
							</c:url>

							<tr>
								<td>${studentObj.firstName}</td>
								<td>${studentObj.lastName}</td>
								<td>${studentObj.email}</td>

								<td>
									<a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
								</td>

							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>