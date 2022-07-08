<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro Paciente</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div  class="p-3 mb-2 bg-primary text-white" >
		<!--  en caso de que exita un error enviamos parametro msgError con el texto -->
		<c:if test="${msgError!= null }">
			<c:out value="${msgError }"></c:out>
		</c:if>
		
		<div class="p-3 mb-2 bg-primary text-white">
		<h1>Ingrese los datos del paciente</h1>
		</div>
		
		<!-- Estructura para cuando trabajemos con formularios -->
		<form:form action="/registro/paciente" method="post"
			modelAttribute="paciente" autocomplete="off">
			<form:label path="nombre" class="form-label">Nombre:</form:label>
			<form:input path="nombre" class="form-control" />
			<br>
			<form:label path="rut" class="form-label">RUT:</form:label>
			<form:input path="rut" class="form-control" />
			<br>
			<form:label path="fechaNacimiento" class="form-label">Fecha de nacimiento:</form:label>
			<form:input type="date" path="fechaNacimiento" class="form-control" />
			<br>
			<input type="submit" value="Registrar" class="btn btn-primary">
		</form:form>
	</div>
</body>
</html>