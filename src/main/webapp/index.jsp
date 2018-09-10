<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources"/>

<!DOCTYPE html>
<html>

<jsp:include page="layout/header.jsp" />


<!--       <div class="jumbotron p-3 p-md-5 text-dark rounded bg-blue ">
        <div class="col-md-6 px-0">
          <h1 class="display-4 font-italic text-primary">movie poster</h1>
          <p class="lead my-3">movie Description!</p>
          <p class="lead mb-0"><a href="#" class="font-weight-bold">See showtimes...</a></p>
        </div>
      </div> -->





<div class="container">
    <div class="row">
        <div class="col-12">
            <h1><fmt:message key="index.showtimes"/></h1>
        </div>
    </div>
        <div class="row">
            <div class="col-12">
                <form class="form-datechoose mt">
                    <input type="date" name="dateOfShowtime" value="${dateOfShowtime}">
                    <input type="hidden" name="command" value="getShowtimes">
                    <input class="btn btn-secondary mt-3 mb-3" type="submit" value="<fmt:message key="index.find"/>">
                </form>
            </div>
        </div>

      <div class="row my-5">
        <div class="col-md-6">
          <div class="card flex-md-row mb-4 shadow-sm h-md-250">
            <div class="card-body d-flex flex-column align-items-start">
              <strong class="d-inline-block mb-2 text-primary"><fmt:message key="index.movie.name"/></strong>
              <h3 class="mb-0">
                <a class="text-dark" href="#"><fmt:message key="index.movie.name"/></a>
              </h3>
              <div class="mb-1 text-muted"><fmt:message key="index.date"/>${dateOfShowtime}</div>
               <c:forEach var="showtime" items="${showtime.findShowtimes(dateOfShowtime)}">

              <p class="card-text mb-auto label">${showtime.begin}</p>
              <p class="card-text mb-auto">${showtime.price}</p>
                            <div class="modal_showtime" data-showtimeid="${showtime.id}">
                                ${showtime.movie.name}
                            </div>
<!--               <a href="#">Book ticket!</a> -->
              </c:forEach>

            </div>
<!--             <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb" alt="Thumbnail [200x250]" style="width: 200px; height: 250px;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22200%22%20height%3D%22250%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20200%20250%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_165803c6c93%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A13pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_165803c6c93%22%3E%3Crect%20width%3D%22200%22%20height%3D%22250%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2256.203125%22%20y%3D%22131%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true"> -->
<!-- <img src="${movie.poster}/images/posters/peppermint-poster1-small.jpg" class="card-img-right flex-auto d-none d-lg-block" alt="${showtime.movie.name}"> -->
<img src="${pageContext.request.contextPath}/images/posters/peppermint-poster1-small.jpg" class="card-img-right flex-auto d-none d-lg-block" alt="${showtime.movie.name}">
<!-- <img src="${pageContext.request.contextPath}/images/posters/${movie.name}-poster1-small.jpg" class="card-img-right flex-auto d-none d-lg-block" alt="${showtime.movie.name}"> -->
          </div>
        </div>


<!-- MODAL -->

       <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="modalLabel"${movie.name}</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="info_block">
                            <div>
                                <span class="info_block_name"><fmt:message key="index.movie"/>: </span>
                                <span id="movie_name"></span>
                            </div>
                            <div>
                                <span class="info_block_name"><fmt:message key="index.movie.genre"/>: </span>
                                <span id="genre"></span>
                            </div>
                            <div>
                                <span class="info_block_name"><fmt:message key="index.movie.director"/>: </span>
                                <span id="director"></span>
                            </div>
                            <div>
                                <span class="info_block_name"><fmt:message key="index.movie.description"/>: </span>
                                <span id="description"></span>
                            </div>
                            <div>
                                <span class="info_block_name"><fmt:message key="index.date"/>: </span>
                                <span id="date"></span>
                            </div>
                            <div>
                                <span class="info_block_name"><fmt:message key="index.time"/>: </span>
                                <span id="time"></span>
                            </div>
                            <div>
                                <span class="info_block_name"><fmt:message key="index.movie.duration"/>: </span>
                                <span id="duration"></span>
                                <span><fmt:message key="index.minute"/></span>
                            </div>
                            <div>
                                <span class="info_block_name"><fmt:message key="index.price"/>: </span>
                                <span id="price"></span>
                                <span><fmt:message key="index.currency"/></span>
                            </div>
                        </div>
                        <div class="seat_form">
                            <div class="screen">
                                <img src="../img/screen.svg" alt="screen">
                                <div>
                                    <fmt:message key="index.screen"/>
                                </div>
                            </div>
                            <table>
                                <c:forEach begin="0" end="10" varStatus="row">
                                    <tr>
                                        <c:forEach begin="1" end="10" varStatus="seat">
                                            <td>
                                                <div class="checkbox seat seat_static blocked" data-seat_id='${row.index*10+seat.index}'>
                                                </div>
                                            </td>
                                        </c:forEach>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal"><fmt:message key="index.close"/></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
<!-- MODAL -->
    </div>

<jsp:include page="layout/footer.jsp" />

</html>
