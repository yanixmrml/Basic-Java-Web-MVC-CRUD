<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="include/header.jsp"></c:import>
<div id="home-body" class="container mtb" >
	<div class="row">
		<div class="col-lg-6">
			<h3>UPDATE USER</h3>
			<form action="${pageContext.servletContext.contextPath}/operation" method="post" class="contact-form">
				UserID: <input type="text" name="userID" class="form-control" value="${user.getUserID()}" readonly="readonly" >
				Username: <input type="text" name="username" class="form-control" value="${user.getUsername()}" required="required" /><br/>
				Password: <input type="password" name="password" class="form-control" value="${user.getPassword()}"  required="required"/><br/>
				Lastname: <input type="text" name="lastname" class="form-control" value="${user.getLastname()}"  required="required"/><br/>
				Firstname: <input type="text" name="firstname"  class="form-control" value="${user.getFirstname()}" required="required"/><br/>
				Middlename: <input type="text" name="middlename" class="form-control" value="${user.getMiddlename()}"  required="required"/><br/>
				<input type="hidden" value="updateUserOperation" name="form" />
				<input type="submit" value="Update User" />
			</form>
		</div>
	</div>
</div>
<c:import url="include/footer.jsp"></c:import>