<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<<<<<<< HEAD
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>Кинотеатр  </title>
<meta name="description" content="movie showtimes">
<meta name="keywords" content="movie showtimes, movie tickets">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.3.1.slim.min.js"></script>
<!-- <script src="js/jquery.min.js"></script> -->
<script src="js/popper.min.js"></script>
<body>


<div class="container">
      <header class="blog-header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
          <div class="col-8 pt-1">
      <nav class="navbar navbar-expand-lg fixed-top bg-white border-bottom">
      <a href="#" title="Movie Theatre"><span class="navbar-brand">Movie Theatre</span></a>

            

        <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="icon-bar text-dark">--</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>

      </nav>



          </div>
    <div class="col-2 d-flex nav navbar-nav ml-auto">
<!--             <a class="text-muted" href="#">
              <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mx-3"><circle cx="10.5" cy="10.5" r="7.5"></circle><line x1="21" y1="21" x2="15.8" y2="15.8"></line></svg>
            </a> -->
      <select class="selectpicker" >
        <option data-content='<span class="flag-icon flag-icon-us"></span> English'>Eng</option>
        <option  data-content='<span class="flag-icon flag-icon-uk"></span> Ukrainian'>Укр</option>
      </select>

      </div>

    <div class="col-2 d-flex nav navbar-nav ml-auto">
<!--             <a class="text-muted" href="#">
              <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mx-3"><circle cx="10.5" cy="10.5" r="7.5"></circle><line x1="21" y1="21" x2="15.8" y2="15.8"></line></svg>
            </a> -->

            <a class="btn btn-sm btn-outline-secondary" href="#">Sign in</a>
      </div>

        </div>
      </header>

      <div class="container py-1 mb-2 border-bottom">
        <nav class="nav d-flex ">
          <a class="p-2 " href="/cinema/movies">Movies</a>
          <a class="p-2 " href="/cinema/showtimes">Showtimes</a>
=======
<c:import url="/header.jsp" charEncoding="utf-8"/>

      <div class="container py-1 mb-2 border-bottom">
        <nav class="nav d-flex ">
          <a class="p-2 " href="/movies">Фильмы</a>
          <a class="p-2 " href="/showtimes">Сеансы</a>
>>>>>>> e917ae97c38a952990409d57a27eb88f8c567a44
        </nav>
      </div>

<!--       <div class="jumbotron p-3 p-md-5 text-dark rounded bg-blue ">
        <div class="col-md-6 px-0">
          <h1 class="display-4 font-italic text-primary">Film poster</h1>
          <p class="lead my-3">Film Description!</p>
          <p class="lead mb-0"><a href="#" class="font-weight-bold">See showtimes...</a></p>
        </div>
      </div> -->

      <div class="row mb-2">
        <div class="col-md-6">
          <div class="card flex-md-row mb-4 shadow-sm h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
              <strong class="d-inline-block mb-2 text-primary">Movie1</strong>
              <h3 class="mb-0">
                <a class="text-dark" href="#">Movie Title</a>
              </h3>
              <div class="mb-1 text-muted">Sep 12</div>
              <p class="card-text mb-auto">Some description with cast.</p>
              <a href="#">Book ticket!</a>
            </div>
            <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" style="width: 200px; height: 250px;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22200%22%20height%3D%22250%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20200%20250%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_165803c6c93%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A13pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_165803c6c93%22%3E%3Crect%20width%3D%22200%22%20height%3D%22250%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2256.203125%22%20y%3D%22131%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">
          </div>
        </div>
        <div class="col-md-6">
          <div class="card flex-md-row mb-4 shadow-sm h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
              <strong class="d-inline-block mb-2 text-primary">Movie1</strong>
              <h3 class="mb-0">
                <a class="text-dark" href="#">Movie Title</a>
              </h3>
              <div class="mb-1 text-muted">Sep 12</div>
              <p class="card-text mb-auto">Some description with cast.</p>
              <a href="#">Book ticket!</a>
            </div>
            <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" style="width: 200px; height: 250px;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22200%22%20height%3D%22250%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20200%20250%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_165803c6c93%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A13pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_165803c6c93%22%3E%3Crect%20width%3D%22200%22%20height%3D%22250%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2256.203125%22%20y%3D%22131%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">
          </div>
        </div>
      </div>
    </div>


<<<<<<< HEAD






<footer class="footer">
  <div class="row">
    <div class="col-xs-12 col-md-4">&copy MovieTheatre</div>
    <div class="col-xs-12 col-md-4">Menu</div>
    <div class="col-xs-12 col-md-4">Contacts</div>
  </div>
</footer>
</div>

</body>
<script>$(function(){
    $('.selectpicker').selectpicker();
});</script>
=======
<c:import url="/footer.jsp" />
>>>>>>> e917ae97c38a952990409d57a27eb88f8c567a44
</html>
