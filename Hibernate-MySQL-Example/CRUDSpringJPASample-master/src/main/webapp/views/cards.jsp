<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table">
	<thead>
		<tr>
			<th>Student Id</th>
			<th>Student name</th>
			<th>Card number</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="card" items="${cards }">
			<tr>
				<td>${card.studentId }</td>
				<td>${card.student.name }</td>
				<td>${card.cardNumber }</td>
				<td><a href="${pageContext.request.contextPath }/cards/edit/${card.studentId }" class="btn btn-primary">Edit</a></td>
				<td><a href="${pageContext.request.contextPath }/cards/delete/${card.studentId }" class="btn btn-danger">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>