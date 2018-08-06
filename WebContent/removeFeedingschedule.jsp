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
	
		<h1>eZoo <small>Remove Feeding Schedule</small></h1>
		<hr class="paw-primary">
		
		<form action="removeFeedingschedule" method="post" class="form-horizontal">
		
				  <div class="form-group">
		    <label for="ID" class="col-sm-4 control-label">Feeding ID</label>
		    <div class="col-sm-4">
		      <input type="number" class="form-control" id="ID" name="ID" placeholder="Feeding ID" required="required"/>
		    </div>
		  </div>
		   <div class="form-group">
		    <label for="animalID" class="col-sm-4 control-label">Animal ID</label>
		    <div class="col-sm-4">
		      <input type="number" class="form-control" id="animalID" name="animalID" placeholder="Animal ID" required="required"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="time" class="col-sm-4 control-label">Time</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="time" name="time" placeholder="Time" required="required"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="recurrence" class="col-sm-4 control-label">Recurrence</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="recurrence" name="recurrence" placeholder="Recurrence" required="required"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="food" class="col-sm-4 control-label">Food</label>
		    <div class="col-sm-4">
		      <input type="text"  class="form-control" id="food" name="food" placeholder="Food" required="required"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="notes" class="col-sm-4 control-label">notes</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="notes" name="notes" placeholder="Notes" required="required"/>
		    </div>
		  </div>
		    <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-1">
<button type="submit" class="btn btn-info" formaction = "RemoveFeedingSchedule">Remove Feeding Schedule</button>		        </div>
		  </div>
		</form>
	  </div>
	</header>


	<!-- Footer -->
	<jsp:include page="footer.jsp" />