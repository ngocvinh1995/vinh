<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="alert alert-success" role="alert">${message }</div>

<form:form action="${pageContext.request.contextPath }/cards/${card.studentId == 0 ? 'add' : 'edit' }" 
	modelAttribute="card" method="post">
	<form:hidden path="studentId"/>
	<div class="form-group">
		<label>Card number</label>
		<form:input type="text" path="cardNumber" cssClass="form-control"/>
	</div>
	
	<div class="form-group">
		<label>Student</label>
		<form:hidden path="student.id"/>
		<form:input type="text" readonly="true" path="student.name" cssClass="form-control"/>
	</div>
	
	<div class="form-group">
		<button type="submit" class="btn btn-default">${card.studentId == 0 ? 'Add' : 'Update' }</button>
	</div>
</form:form>