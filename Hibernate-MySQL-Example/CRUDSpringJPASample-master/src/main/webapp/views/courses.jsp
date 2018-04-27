<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="course" items="${courses }">
			<tr>
				<td>${course.id }</td>
				<td>${course.name }</td>
				<td><a href="${pageContext.request.contextPath }/courses/edit/${course.id }" class="btn btn-primary">Edit</a></td>
				<td><a href="${pageContext.request.contextPath }/courses/delete/${course.id }" class="btn btn-danger">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href="${pageContext.request.contextPath }/courses/add" class="btn btn-default">Add new</a>