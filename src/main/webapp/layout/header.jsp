<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="WebappMessages"/>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>Кинотеатр  </title>
<meta name="description" content="movie showtimes">
<meta name="keywords" content="movie showtimes, movie tickets">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" href="css/flag-icon.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.3.1.slim.min.js"></script>
<!-- <script src="js/jquery.min.js"></script> -->
<script src="js/popper.min.js"></script>
<body>
<div class="container">
      <header class="blog-header py-3">



			<nav class="navbar navbar-expand-lg fixed-top bg-white border-bottom navbar-toggleable">
			<a href="#" title="Movie Theatre"><span class="navbar-brand">Movie Theatre</span></a>
			<ul>
          	          <li><a class="p-2 " href="/movies"><fmt:message key = "index.movies" /></a></li>
                      <li><a class="p-2 " href="/showtimes"><fmt:message key = "index.showtimes" /></a></li>
			</ul>

            <select class="selectpicker" >
			  <option data-content='<span class="flag-icon flag-icon-us"></span> English'>Eng</option>
			  <option  data-content='<span class="flag-icon flag-icon-uk"></span> Ukrainian'>Укр</option>
			</select>
            <a class="btn btn-sm btn-outline-secondary" href="?command=login"><fmt:message key = "login.login" /></a>

		    <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="icon-bar text-dark">--</span>
		      <span class="icon-bar"></span>
		      <span class="icon-bar"></span>
		    </button>
		    </nav>




        </div>
      </header>


