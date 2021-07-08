<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="include/header.jsp"></c:import>
<div id="home-body" class="container mtb" >
	<div class="row">
		<div class="col-lg-6">
			<h3>ADD USER</h3>
			<form action="${pageContext.servletContext.contextPath}/operation" method="post" class="contact-form">
				Username: <input type="text" name="username" class="form-control" placeholder="Your Username"  required/><br/>
				Password: <input type="password" name="password" class="form-control" placeholder="Your Password"  required/><br/>
				Lastname: <input type="text" name="lastname" class="form-control" placeholder="Your Lastname"  required/><br/>
				Firstname: <input type="text" name="firstname"  class="form-control" placeholder="Your Firstname" required/><br/>
				Middlename: <input type="text" name="middlename" class="form-control" placeholder="Your Middlename"  required/><br/>
				<input type="hidden" value="addUserOperation" name="form" />
				<input type="submit" value="Add User" />
			</form>
		</div>
	</div>
</div>
<c:import url="include/footer.jsp"></c:import>