<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,fr.eni.annuaire.bo.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Répertoire</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="jumbotron text-center">
		<h1 class="my-4">Répertoire</h1>
	</div>
	
	<div class="row justify-content-center">
		<div class="col-auto">
			<table border="1" class="table table-responsive">
				
				<thead>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Email</th>
					<th>Date de création</th>
					<th>Suppression</th>
					<th>Modification</th>
				</thead>

				<c:forEach var="u" items="${liste}">
				<tr>
					<td>${u.getNom() }</td>
					<td>${u.getPrenom() }</td>
					<td>${u.getEmail() }</td>
					<td>${u.getDate() }</td>
					<td><a href="ServletEffacer?email=${u.getEmail() }">Supprimer</a></td>
					<td><a href="ServletModif?id=${u.getId() }">Modifier</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
	<br>
	<form method="post" action="ServletAjout" >
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-auto">
					Nom : <input type="text" name="nom">
					Prénom : <input type="text" name="prenom">
					Email : <input type="text" name="email">
					Mot de passe : <input type="password" name="mdp">
				</div>
			</div>
		</div>
		<br>
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-auto">
					<input type="submit" name="ajouter" value="Ajouter">
				</div>
			</div>
		</div>
	</form>


	<footer class="py-5">
		<div class="container">
			<p class="m-0 text-center">Copyright &copy; - Assane - 2020</p>
		</div>
	</footer>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>