<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div class="row">
		<div class="sidenav">
			<a href="#">About</a> <a href="">Services</a>
			<ul>
				<c:forEach var="menuValue" items="${navList}">
					<li><a href="${menuValue.value.uri}">${menuValue.key}</a></li>
				</c:forEach>
			</ul>
			<a href="#">Clients</a> <a href="#">Contacts</a>
		</div>

		<section>
			<nav>
				<a href="#one"><label>one</label></a>
				<a href="#two"><label>two</label></a>
				<form name="signout" action="../signout" method="POST">
					<input class="btnLink" type="submit" value="sign out" />
				</form>
			</nav>
			<form>
			</form>
		</section>
	</div>
</body>
</html>