<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="alert alert-success" role="alert">${message }</div>

<form:form action="${pageContext.request.contextPath }/courses/${course.id == 0 ? 'add' : 'edit' }" 
	modelAttribute="course" method="post">
	<form:hidden path="id"/>
	<div class="form-group">
		<label>Name</label>
		<form:input type="text" path="name" cssClass="form-control"/>
	</div>
	
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
				<th>Address</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${course.students }" var="student">
				<tr>
					<td>${student.id }</td>
					<td>${student.name }</td>
					<td>${student.age }</td>
					<td>${student.address }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<div class="form-group">
		<button type="submit" class="btn btn-default">${course.id == 0 ? 'Add' : 'Update' }</button>
		<a href="${pageContext.request.contextPath }/courses/add" class="btn btn-default">Add new</a>
	</div>
</form:form>