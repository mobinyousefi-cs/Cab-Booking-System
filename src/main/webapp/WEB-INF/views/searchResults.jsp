<!-- File: src/main/webapp/WEB-INF/views/searchResults.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/standard-rt" prefix="c" %>
<jsp:include page="fragments/header.jsp"/>

<section class="card">
    <h1>Available Cab Found</h1>

    <c:if test="${not empty ride}">
        <p>
            <strong>Pickup:</strong> <c:out value="${ride.pickupArea}"/><br/>
            <strong>Drop:</strong> <c:out value="${ride.dropArea}"/><br/>
            <strong>Cab Type:</strong> <c:out value="${ride.cabType}"/><br/>
            <strong>Driver:</strong> <c:out value="${ride.driver.fullName}"/> (<c:out value="${ride.driver.licenseNumber}"/>)<br/>
            <strong>ETA:</strong> <c:out value="${ride.estimatedEtaMinutes}"/> minutes
        </p>

        <form method="post" action="${pageContext.request.contextPath}/booking/confirm">
            <input type="hidden" name="rideId" value="${ride.id}"/>
            <button type="submit" class="btn btn-primary">Confirm Ride</button>
        </form>
    </c:if>
</section>

<jsp:include page="fragments/footer.jsp"/>
