<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:useBean id= "club" class="entities.Club" scope="request" />        

	<jsp:setProperty name="club" property="*" />
<head>
<meta charset="UTF-8">
<title>Club ${club.getName()} | Parascolaire Ensa Agadir</title>


<link rel="stylesheet" href="./inc/css/common/header-footer.css">
<link rel="stylesheet" href="./inc/css/presentation/presentation.css">
<link rel="stylesheet" href="./inc/css/common/popUpDeconnexion.css">
<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	
<link rel="icon" href="./images/logo.png">
</head>
<body onload="currentSlide(1)">