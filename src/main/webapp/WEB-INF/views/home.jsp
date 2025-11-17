<!-- File: src/main/webapp/WEB-INF/views/home.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/standard-rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="fragments/header.jsp"/>

<section class="card">
    <h1>Book your cab</h1>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-error">
            <c:out value="${errorMessage}"/>
        </div>
    </c:if>

    <form:form method="post" modelAttribute="rideSearchRequest"
               action="${pageContext.request.contextPath}/booking/search">

        <div class="form-group">
            <label for="pickupArea">Pick-up area</label>
            <form:input path="pickupArea" id="pickupArea" cssClass="input"/>
            <form:errors path="pickupArea" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="dropArea">Drop area</label>
            <form:input path="dropArea" id="dropArea" cssClass="input"/>
            <form:errors path="dropArea" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="cabType">Cab type</label>
            <form:select path="cabType" id="cabType" cssClass="input">
                <form:options items="${cabTypes}"/>
            </form:select>
            <form:errors path="cabType" cssClass="error"/>
        </div>

        <button type="submit" class="btn btn-primary">Search Cab</button>
    </form:form>
</section>

<jsp:include page="fragments/footer.jsp"/>
