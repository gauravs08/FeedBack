<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="feedbackSubmit">
	<label for="Email">Email</label> <input type="text" name="email" /> <br />
	</br>
	<label for="message">Message</label>
	<textarea name="message"></textarea>
	<input type="submit" value="Send feedback">
</form>
</body>
</html>