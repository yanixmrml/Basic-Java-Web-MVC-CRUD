<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>
  <c:choose>
  	<c:when test="${pageTitle != null}">
  		${pageTitle}
  	</c:when>
  	<c:otherwise>
  		Yanixmrml
  	</c:otherwise>
  </c:choose>
  </title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Raleway:400,700,900|Lato:400,900" rel="stylesheet">

  <!-- Bootstrap CSS File -->
  <link href="assets/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Libraries CSS Files -->
  <link href="assets/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="assets/lib/prettyphoto/css/prettyphoto.css" rel="stylesheet">
  <link href="assets/lib/hover/hoverex-all.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
    Template Name: Solid
    Template URL: https://templatemag.com/solid-bootstrap-business-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>

<body>

  <!-- Fixed navbar -->
  <div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        <a class="navbar-brand" href="index.html">SOLID.</a>
      </div>
      <div class="navbar-collapse collapse navbar-right">
        <ul class="nav navbar-nav">
          <li class="active"><a href="${pageContext.request.contextPath}/site?page=home">HOME</a></li>
          <li><a href="${pageContext.request.contextPath}/site?page=contact">CONTACT</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">USERS <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="${pageContext.request.contextPath}/operation?page=listuser">LIST USERS</a></li>
              <li><a href="${pageContext.request.contextPath}/operation?page=adduser">ADD USER</a></li>
            </ul>
          </li>
        </ul>
      </div>
      <!--/.nav-collapse -->
    </div>
  </div>