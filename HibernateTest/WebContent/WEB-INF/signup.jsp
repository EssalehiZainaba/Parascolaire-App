<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<link rel="stylesheet" href="inc/inscription.css">
</head>
<body>
<p>Vous pouvez vous inscrire via ce formulaire :</p>
	<form method="POST" action="SignUp">
		<fieldset>
			<legend>Inscription</legend>
			<table>
				<tr>
					<td>
						<label for="email">Adresse Email : </label><span> *</span>
					</td>
					<td>
						<input type="text" name="email" id="email" value="${param.email }">
						<span>${form.errors['email'] }</span>
					</td>				
				</tr>
				<tr>
					<td>
						<label for="pwd">Mot de passe : </label><span> *</span>
					</td>
					<td>
						<input type="text" name="pwd" id="pwd">
						<span>${form.errors['pwd'] }</span>
					</td>				
				</tr>
			</table>
		</fieldset>
		<br>
		<input type="submit" name="submit" value="Valider">
	</form>
	
	<p class="${empty form.errors ? 'success' : 'failure' }">${form.result }</p>
	<c:if test="${!empty sessionScope.user}">
    	<p class="success">Dernière inscription : ${sessionScope.user.email}</p>
    </c:if>
    
    <p>${list.result }</p>
    <table>
        <tr>
    		<td>ID</td>
    		<td>Email</td>
    		<td>Mot de passe</td>
    	</tr>
    <c:forEach items="${list.users }" var="user">
		<tr>
			<td>${user.id }</td>
			<td>${user.email }</td>
			<td>${user.password }</td>
    	</tr>
    </c:forEach>
    </table>
</body>
</html>