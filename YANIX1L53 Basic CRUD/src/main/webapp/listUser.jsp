<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="include/header.jsp"> 
</c:import>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<h1>LIST USERS</h1>
			<div>
				<table class="table">
					<thead>
						<tr>
							<td>UserID</td>
							<td>Username</td>
							<td>Fullname</td>
							<td> - </td>
							<td> - </td>
						</tr>	
					</thead>
					<tbody>
						<c:if test="${userList != null}">
							<c:forEach items="${userList}" var="user">
								<tr>
									<td>${user.getUserID()}</td>
									<td>${user.getUsername()}</td>
									<td>${user.getLastname()},&nbsp;${user.getFirstname()}&nbsp;${user.getMiddlename()}</td>
									<c:url var="updateURL" value="operation" >
										<c:param name="page" value="updateUser"></c:param>
										<c:param name="userID" value="${user.userID}"></c:param>
									</c:url>
									<c:url var="deleteURL" value="operation">
										<c:param name="page" value="deleteUser"></c:param>
										<c:param name="userID" value="${user.getUserID()}"></c:param>
									</c:url>
									<td><a href="${updateURL}">Update</a></td>
									<td><a href="${deleteURL}" onclick="if(!confirm('Do you want to delete this record?')){return false;}" >Delete</a></td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<c:import url="include/footer.jsp"></c:import>    