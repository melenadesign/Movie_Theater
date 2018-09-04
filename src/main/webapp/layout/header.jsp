<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources" />
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>Кинотеатр  </title>
<meta name="description" content="movie showtimes">
<meta name="keywords" content="movie showtimes, movie tickets">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/flag-icon.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fontawesome.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
<!-- <script src="js/jquery.min.js"></script> -->
<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
</head>
<body>
<div class="container">
      <header class="blog-header py-3">


			<nav class="navbar navbar-expand-lg fixed-top bg-white border-bottom" >

			<a class="navbar-brand" href="/cinema" title="Movie Theatre">Movie Theatre</a>
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
	        <!--<span class="navbar-toggler-icon"></span>
		      <span class="icon-bar text-dark">--</span>
		      <i class="fas fa-bars"></i> -->
		      <img src='images/icons/bars-solid.svg' class="icon-mv"/>

		    </button>
		    <div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="nav mx-auto" >
          	          <li class="nav-item"><a class="p-2 nav-link" href="/cinema/movies"><fmt:message key = "index.movies" /></a></li>
                      <li class="nav-item"><a class="p-2 nav-link" href="/cinema/showtimes"><fmt:message key = "index.showtimes" /></a></li>
			</ul>

            <%--<select class="selectpicker" >--%>
			  <%--<option data-content='<span class="flag-icon flag-icon-us"></span> English'>Eng</option>--%>
			  <%--<option  data-content='<span class="flag-icon flag-icon-uk"></span> Ukrainian'>Укр</option>--%>
			<%--</select>--%>
				<form method="GET" class="mr-2   d-inline-block">
					<select id="lang" class="mr-2   d-inline-block" name="language" onchange="submit();">
						<option value="en" ${language =='en' ? 'selected' : ''} > Eng</option>
						<option value="uk_UA" ${language =='uk_UA' ? 'selected' : ''}>Укр</option>
					</select></form>
            <a id="login__btn" class="btn btn-sm btn-outline-primary mr-2 h-33" href="${pageContext.request.contextPath}/?command=login"><fmt:message key = "login.signin" /></a>


                </div>
		    </nav>

      </header>

        </div>
