	<!-- Header -->
	<jsp:include page="header.jsp" />
	
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!-- 	Just some stuff you need -->
	<header>
	  <div class="container">
		
	<c:choose>
	<c:when test="${not empty message }">
	  <p class="alert ${messageClass}">${message }</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	</c:when>
	</c:choose>
	
		<h1>Ezoo <small>Feeding Schedule Details - ${Feedingschedule.ID }</small></h1>
		<hr class="Feedingschedule-primary">
		
		<form action="UpdateFeedingSchedule" method="post" class="form-horizontal">
		  
		  <input type="hidden" class="form-control" id="ID" name="ID" required="required" value="${Feedingschedule.ID }" />
		  
		  <div class="form-group">
		    <label for="time" class="col-sm-4 control-label">Time</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="time" name="time" placeholder="Time" required="required" value="${Feedingschedule.time }" />
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="recurrence" class="col-sm-4 control-label">Recurrence</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="recurrence" name="recurrence" placeholder="Recurrence" required="required" value="${Feedingschedule.recurrence }" />
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="food" class="col-sm-4 control-label">"Food"</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="food" name="food" placeholder="food" required="required" value="${Feedingschedule.food }" />
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="notes" class="col-sm-4 control-label">"Notes"</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="notes" name="notes" placeholder="Notes" required="required" value="${Feedingschedule.notes }" />
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-1">
		      <button type="submit" class="btn btn-info">Update</button>
		    </div>
		  </div>
		</form>
         	
	  </div>
	</header>
	
	<!-- Footer -->
	<jsp:include page="footer.jsp" />