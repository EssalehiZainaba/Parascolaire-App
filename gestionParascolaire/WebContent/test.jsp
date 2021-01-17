<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="presentation" >
		<fieldset>
			<legend>Club Creation</legend>
			<table>
				<tr>  <td>  Name  </td>    <td>  <input type="text" name="name"></td>   </tr>
				<tr>  <td>  Description  </td>    <td>  <input type="text" name="description"></td>   </tr>
				<tr>  <td>  Paragraphe  </td>    <td>  <input type="text" name="paragraphe"></td>   </tr>
			</table>
			<input type="submit" value="Create">
		</fieldset>
		
	</form>
	<c:out value="Hello Brother"></c:out>
</body>
</html>