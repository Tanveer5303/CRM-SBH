<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>

<!-- refrence our style sheets -->

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />


</head>
<body>


<div id="wrapper">
	<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
	</div>
</div>

<div id ="container">

	<div id = "content">
	
	<!-- Put new button Add Customer -->
	
	<input type="button" value = "Add Customer"
		   onclick = "window.location.href='showFormForAdd';return false;"
		   class = "add-button"
		   />
	
	
	
	<!-- add out html table here -->
	<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Action</th>
	</tr>
	
	<!-- loop over and print our customer -->
	<c:forEach var = "tempCustomers" items = "${customers}">
	
	<!-- Construct an update link  -->
	<c:url var="updateLink" value="/customer/showFormForUpdate">
	<c:param name="customerId" value="${tempCustomers.id}"/>
	</c:url>
	
	<c:url var="deleteLink" value="/customer/showFormForDelete">
	<c:param name="customerId" value="${tempCustomers.id}"/>
	</c:url>
	
	<tr>
		<td> ${tempCustomers.firstName} </td>
		<td> ${tempCustomers.lastName} </td>
		<td> ${tempCustomers.email} </td>
		<td>
			<!-- display the update data -->
			<p><a href="${updateLink}">Update</a>|<a href = "${deleteLink}">Delete</a></p>
		</td>
	</tr>
	
	</c:forEach>
	
	</table>
	
	</div>

</div>


</body>
</html>