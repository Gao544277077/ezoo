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
	
		<h1>eZoo <small>Update Feeding Schedule</small></h1>
		<hr class="paw-primary">
		
		<form action="updateFeedingSchedule" method="post" class="form-horizontal">
		
		  <div class="form-group">
		    <label for="ID" class="col-sm-4 control-label">Feeding ID</label>
		    <div class="col-sm-5">
		      <input type="number" class="form-control" id="ID" name="ID" placeholder="Feeding ID" required="required" value="${param.ID }"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="time" class="col-sm-4 control-label">Time</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="time" name="time" placeholder="Time" required="required" value="${param.time}"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="recurrence" class="col-sm-4 control-label">Recurrence</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="recurrence" name="recurrence" placeholder="Recurrence" required="required" value="${param.recurrence}"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="food" class="col-sm-4 control-label">Food</label>
		    <div class="col-sm-5">
		      <input type="text"  class="form-control" id="food" name="food" placeholder="Food" required="required" value="${param.food }"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="notes" class="col-sm-4 control-label">notes</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="notes" name="notes" placeholder="Notes" required="required" value="${param.notes }"/>
		    </div>
		  </div>
		    <div class="form-group">
		     <div class="col-sm-offset-4 col-sm-1">
		       <button type="submit" class="btn btn-info" formaction = "updateFeedingSchedule">Update</button>
		        </div>
		  </div>
		</form>
	  </div>
	</header>


	<!-- Footer -->
	<jsp:include page="footer.jsp" />
	