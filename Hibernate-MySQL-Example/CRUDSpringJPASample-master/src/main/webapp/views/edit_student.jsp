<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="alert alert-success" role="alert">${message }</div>
<form:form action="${pageContext.request.contextPath }/students/${student.id == 0 ? 'add' : 'edit' }" 
modelAttribute="student" method="post">
	<form:hidden path="id"/>
	<div class="form-group">
		<label>Name</label>
		<form:input type="text" name="name" path="name" cssClass="form-control"/>
	</div>
	
	<div class="form-group">
		<label>Age</label>
		<form:input type="number" maxlength="3" name="age" path="age" cssClass="form-control"/>
	</div>
	
	<div class="form-group">
		<label>Address</label>
		<form:input type="text" name="address" path="address" cssClass="form-control"/>
	</div>
	
	<div class="form-group">
		<label>CardNumber</label>
		<form:hidden path="studentCard.studentId"/>
		<form:input type="number" maxlength="10" path="studentCard.cardNumber" cssClass="form-control"/>
	</div>
	
	<div class="form-group">
		<label>Head teacher</label>
		<form:select path="headTeacher" cssClass="form-control">
			<c:forEach var="teacher" items="${teachers }">
			<form:option selected="${student.headTeacher.id == teacher.id ? 'selected' : '' }" value="${teacher.id }">${teacher.name }</form:option>
			</c:forEach>
		</form:select>
	</div>
	
	<div class="form-group">
		<label>Courses</label>
		<form:select path="courses" cssClass="form-control" multiple="true" items="${courses }" itemValue="id" itemLabel="name">
		</form:select>
	</div>
	
	<div class="form-group">
		<button type="submit" class="btn btn-default">${student.id == 0 ? 'Add' : 'Update' }</button>
	</div>
</form:form>