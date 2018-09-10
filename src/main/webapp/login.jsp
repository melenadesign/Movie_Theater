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
      <div class="container py-1 mb-2 border-bottom">
      </div>
    <div class="container ">
        <div class="row p-3 p-md-5 m-md-3">
          <div class="col-sm-12 col-lg-6 m-auto">
        <form method="" action="login.jsp?command=login" class="form-signin mt">
            <h2 class="form-signin-heading"><fmt:message key="login.prompt.login"/></h2>
            <c:if test="${errorMessage}">
                <h3 class="form-signin"><fmt:message key="login.error.message"/></h3>
            </c:if>
            <div class="form-group">
              <!--  <label for="email"><fmt:message key="login.email"/></label>
                <input type="email" class="form-control" id="email" name="email" placeholder="<fmt:message key="login.email"/>"> -->
                <label for="name"><fmt:message key="login.name"/></label>
                                                <input required type="text" class="form-control" id="name" name="name" placeholder="<fmt:message key="login.name"/>">

            </div>
            <div class="form-group">
                <label for="pass"><fmt:message key="login.password"/></label>
                <input type="password" class="form-control" id="pass" name="password" placeholder="<fmt:message key="login.password"/>">
            </div>

            <button class="btn btn-lg btn-outline-primary btn-block" type="submit"><fmt:message key="login.signin"/></button>
            <div class="form-group">
                <label><fmt:message key="login.not.registered"/></label>
                <br/>
                <a class="" href="?command=register"><fmt:message key="login.register"/></a>
                        <font color="red"><c:if test="${not empty param.errMsg}">
                            <c:out value="${param.errMsg}" />
                            </c:if></font>
            </div>
        </form>
    </div>
</div>
<jsp:include page="layout/footer.jsp" />

</html>