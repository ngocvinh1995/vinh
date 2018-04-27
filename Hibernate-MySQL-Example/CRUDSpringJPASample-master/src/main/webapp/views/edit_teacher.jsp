<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="alert alert-success" role="alert">${message }</div>

<form:form action="${pageContext.request.contextPath }/teachers/${teacher.id == 0 ? 'add' : 'edit' }" 
	modelAttribute="teacher" method="post">
	<form:hidden path="id"/>
	<div class="form-group">
		<label>Name</label>
		<form:input type="text" name="name" path="name" cssClass="form-control"/>
	</div>
	
	<div class="form-group">
		<label>Age</label>
		<form:input type="number" name="age" path="age" cssClass="form-control"/>
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
			<c:forEach items="${teacher.students }" var="student">
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
		<button type="submit" class="btn btn-default">${teacher.id == 0 ? 'Add' : 'Update' }</button>
	</div>
</form:form>