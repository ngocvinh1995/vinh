<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="teacher" items="${teachers }">
			<tr>
				<td>${teacher.id }</td>
				<td>${teacher.name }</td>
				<td>${teacher.age }</td>
				<td><a href="${pageContext.request.contextPath }/teachers/edit/${teacher.id }" class="btn btn-primary">Edit</a></td>
				<td><a href="${pageContext.request.contextPath }/teachers/delete/${teacher.id }" class="btn btn-danger">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="${pageContext.request.contextPath }/teachers/add" class="btn btn-default">Add new</a>
