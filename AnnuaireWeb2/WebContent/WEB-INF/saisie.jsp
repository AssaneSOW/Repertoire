<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,fr.eni.annuaire.bo.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Saisie</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="jumbotron text-center">
		<h1 class="my-4">Modification de contact</h1>
	</div>
	
	<div class="row justify-content-center">
		<div class="col-auto">
			<table border="1" class="table table-responsive">

				<thead>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Email</th>
					<th>Date de création</th>
				</thead>
				
				<tr>
					<td>${user.getNom() }</td>
					<td>${user.getPrenom() }</td>
					<td>${user.getEmail() }</td>
					<td>${user.getDate() }</td>
				</tr>
				
			</table>
		</div>
	</div>
	<br>
	<form method="post" action="ServletModif" >
		<div class="container formulaire">
			<div class="row justify-content-center">
				<div class="col-auto">
					<input type="hidden" name="id" value="${user.getId() }">
					Nom : <input type="text" name="nom" placeholder="${u.getNom() }">
					Prénom : <input type="text" name="prenom">
					Email : <input type="text" name="email">
				</div>
			</div>
		</div>
		<br>
		<div class="container formulaire" id="bouton">
			<div class="row justify-content-center">
				<div class="col-auto">
					<input type="submit" name="modifier" value="Modifier">
				</div>
			</div>
		</div>
	</form>


	<footer class="py-5 fixed-bottom">
		<div class="container">
			<p class="m-0 text-center">Copyright &copy; - Assane - 2020</p>
		</div>
	</footer>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>