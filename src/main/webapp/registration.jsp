<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

                        <form action="?command=register" method="post" class="form-signin mt">
                            <h2 class="form-signin-heading"><fmt:message key="registration.registration"/></h2>
                            <c:if test="${errorMessage}">
                                <h3 class="form-signin"><fmt:message key="registration.error.message"/></h3>
                            </c:if>
                            <c:if test="${failRegex}">
                                <h3 class="form-signin"><fmt:message key="registration.error.input"/></h3>
                            </c:if>
                            <div class="form-group">
                                <label for="userName"><fmt:message key="registration.name"/></label>
                                <input required type="text" class="form-control" id="userName" name="name" placeholder="<fmt:message key="registration.name"/>">
                            </div>
                            <div class="form-group">
                                <label for="email"><fmt:message key="registration.email"/></label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="<fmt:message key="registration.email"/>" required>
                            </div>
                            <div class="form-group">
                                <label for="phone"><fmt:message key="registration.phone"/></label>
                                <input type="email" class="form-control" id="phone" name="phone" placeholder="<fmt:message key="registration.phone"/>">
                            </div>
                            <div class="form-group">
                                <label for="pass"><fmt:message key="registration.password"/></label>
                                <input type="pass" class="form-control" id="pass" name="password" placeholder="<fmt:message key="registration.password"/>" required>
                            </div>
                            <button class="btn btn-lg  btn-outline-primary btn-block" type="submit"><fmt:message key="registration.do.register"/></button>
                        </form>

          </div>
        </div>
    </div

<jsp:include page="layout/footer.jsp" />

</html>