package com.examples.ezoo.servlets;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.ezoo.dao.*;
import com.examples.ezoo.model.*;
import com.examples.ezoo.dao.DAOUtilities;
@WebServlet("/removeFeedingschedule")
public class RemoveFeedingScheduleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("removeFeedingschedule.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Parameter from JSP Form 
		long ID = Long.parseLong(request.getParameter("ID"));
		// Set values for unused parameters
		Long animalID = (long) 1;
        String time="";
	    String recurrence ="";
		String food= "";
		String notes ="";

		//Create an FeedingSchedule object from the parameters
		Feedingschedule scheduleToDelete = new Feedingschedule(
				ID,
				animalID,
				time,
				recurrence,
				food,
				notes);
		
	//Call DAO method
	FeedingscheduleDAO dao = DAOUtilities.getFeedingscheduleDao();
	try {
		dao.deleteFeedingschedule(scheduleToDelete);
		request.getSession().setAttribute("message", "Feeding Schedule successfully deleted");
		request.getSession().setAttribute("messageClass", "alert-success");
		
		request.getRequestDispatcher("removeFeedingSchedule.jsp").forward(request, response);


	}catch(SQLIntegrityConstraintViolationException e){
		e.printStackTrace();
		
		//change the message
		request.getSession().setAttribute("message", "Id of " + scheduleToDelete.getAnimalID() + " is already in use");
		request.getSession().setAttribute("messageClass", "alert-danger");
		
		request.getRequestDispatcher("removeFeedingSchedule.jsp").forward(request, response);
		
	}catch (Exception e){
		e.printStackTrace();
		
		//change the message
		request.getSession().setAttribute("message", "There was a problem deleting the feeding schedule at this time");
		request.getSession().setAttribute("messageClass", "alert-danger");
		
		request.getRequestDispatcher("removeFeedingschedule.jsp").forward(request, response);

	}
}

}


