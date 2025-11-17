<!-- File: src/main/webapp/WEB-INF/views/bookingSuccess.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/standard-rt" prefix="c" %>
<jsp:include page="fragments/header.jsp"/>

<section class="card">
    <h1>Ride Confirmed 🎉</h1>

    <c:if test="${not empty ride}">
        <p>Your ride has been confirmed.</p>
        <p>
            <strong>Driver:</strong> <c:out value="${ride.driver.fullName}"/><br/>
            <strong>Pickup:</strong> <c:out value="${ride.pickupArea}"/><br/>
            <strong>Drop:</strong> <c:out value="${ride.dropArea}"/><br/>
            <strong>ETA:</strong> <c:out value="${ride.estimatedEtaMinutes}"/> minutes
        </p>
    </c:if>

    <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Book another cab</a>
</section>

<jsp:include page="fragments/footer.jsp"/>
