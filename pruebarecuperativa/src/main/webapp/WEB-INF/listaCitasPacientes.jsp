<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de usuario y citas</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

</head>
<body>

	<h1 style="text-align: center">Los datos se han ingresado
		exitosamente!</h1>

	<div class="container">
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Nombre</th>
					<th scope="col">RUT</th>
					<th scope="col">fechaNacimiento</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="paciente" items="${pacientesCapturados}">
					<!--  mostramos los atributos de la captura -->
					<tr>
						<th scope="row">${paciente.id}</th>
						<td>${paciente.nombre}</td>
						<td>${paciente.RUT}</td>
                        <td>${paciente.fechaNacimiento}</td>
						
				</c:forEach>
			</tbody>
		</table>
	</div>

    <!-- Citas Medicas -->
    <div class="container">
		<table class="table table-dark table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Paciente id</th>
					<th scope="col">Hora</th>
					<th scope="col">Area Medica</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="citaMedica" items="${citasMedicasCapturadas}">
					<!--  mostramos los atributos de  la captura -->
					<tr>
						<th scope="row">${citaMedica.id}</th>
						<td>${citaMedica.paciente_id}</td>
						<td>${citaMedica.hora}</td>
                        <td>${citaMedica.areaMedica}</td>
						
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>

</body>
</html>