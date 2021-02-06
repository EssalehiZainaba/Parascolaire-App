<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="presentation?clubId=1">Club Sociale</a><br>
	<a href="presentation?clubId=2">Club sportif</a><br>
	<a href="presentation?clubId=3">Enactus</a><br>
	<a href="presentation?clubId=4">las lyndas</a><br>
	<a href="presentation?clubId=5">appsClubtik</a><br>
	
	<form method="post" action="creerPresentationClub">
		<input type="date" name="date" value="${sessionScope.date.toString() }"><br>
		<input type="submit" value="hello" value="Envoyer">
	</form>
	
</body>
</html>