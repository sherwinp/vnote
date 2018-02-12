<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="static/css/style.css" />
</head>
<body>
	<div class="row">
		<div class="sidenav">
			<a href="#">About</a> 
			<a href="#">Services</a>
			<a href="#">Clients</a>
			<a href="#">Contacts</a>
		</div>

		<section>
			<nav>
				<a href="#one"><label>one</label></a>
				<a href="#two"><label>two</label></a>
				<a href="#"><label>sign in</label></a>
			</nav>
			<form:form enctype="application/x-www-form-urlencoded" action="j_security_check" method="POST">
				<input type="text" id="j_username" name="j_username" placeholder="user id"/>
				<input type="password" id="j_password" name="j_password" placeholder="password"/>
				<input type="submit" />
			</form:form>
		</section>
	</div>
</body>
</html>