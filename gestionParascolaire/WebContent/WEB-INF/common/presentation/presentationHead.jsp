<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:useBean id= "club" class="entities.Club" scope="request" />        

	<jsp:setProperty name="club" property="*" />
<head>
<meta charset="UTF-8">
<title>Presentation de ${club.getName()}</title>


<link rel="stylesheet" href="./inc/css/common/header-footer.css">
<link rel="stylesheet" href="./inc/css/presentation/presentation.css">
<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	

</head>
<body onload="currentSlide(1)">