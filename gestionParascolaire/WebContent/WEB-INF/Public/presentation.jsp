<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<jsp:useBean id= "club" class="entities.Club" scope="request" />        

	<jsp:setProperty name="club" property="*" />
<head>
<meta charset="UTF-8">
<title>Club ${club.getName()} | Parascolaire Ensa Agadir</title>

<link rel="icon" href="./images/logo.png">
<link rel="stylesheet" href="./inc/css/common/header-footer.css">
<link rel="stylesheet" href="./inc/css/common/connexionForm.css">
<link rel="stylesheet" href="./inc/css/presentation/presentation.css">
<script src="https://kit.fontawesome.com/5bf11eee96.js" crossorigin="anonymous"></script>	

</head>
<body onload="currentSlide(1)">
	
	
	
	<%@ include file="inc/header.jsp" %>
	
	<%@ include file="../common/presentation/presentationContainer.jsp" %>
	
	<%@ include file="../common/footer.jsp" %>
	<%@ include file="../common/connexionForm.jsp" %>
</body>
<script src="./inc/js/presentation/presentation.js"></script>
<script type="text/javascript" src="./inc/js/common/header.js"></script>
<script type="text/javascript" src="./inc/js/common/connexionForm.js"></script>
</html>