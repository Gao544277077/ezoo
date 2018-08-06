package com.examples.ezoo.servlets;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.ezoo.dao.*;
import com.examples.ezoo.model.*;
import com.examples.ezoo.dao.DAOUtilities;
/**
 * Servlet implementation class AddAnimalServlet
 */
@WebServlet("/updateFeedingSchedule")
public class UpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 


@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.getRequestDispatcher("updateFeedingSchedule.jsp").forward(request, response);
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Get Parameters
	//We MUST convert to a Long since parameters are always Strings
	long ID = Long.parseLong(request.getParameter("ID"));
	long animalID = 1;
	String time = request.getParameter("time");
    String recurrence = request.getParameter("recurrence");
	String food = request.getParameter("food");
	String notes = request.getParameter("notes");

	//Create an Animal object from the parameters
	Feedingschedule FeedingscheduleToUpdate = new Feedingschedule(
			ID, 
			animalID,
			time, 
			recurrence,
			food,
			notes);
	
	//Call DAO method
	FeedingscheduleDAO dao = DAOUtilities.getFeedingscheduleDao();
	try {
		dao.updateFeedingSchedule(FeedingscheduleToUpdate);
		request.getSession().setAttribute("message", "Feedingschedule successfully updated");
		request.getSession().setAttribute("messageClass", "alert-success");
		request.getRequestDispatcher("updateFeedingSchedule.jsp").forward(request, response);



	}catch(SQLIntegrityConstraintViolationException e){
		e.printStackTrace();
		
		//change the message
		request.getSession().setAttribute("message", "Feeding id of " + FeedingscheduleToUpdate.getAnimalID() + " is already in use");
		request.getSession().setAttribute("messageClass", "alert-danger");
		
		request.getRequestDispatcher("updateFeedingSchedule.jsp").forward(request, response);
		
	}catch (Exception e){
		e.printStackTrace();
		
		//change the message
		request.getSession().setAttribute("message", "There was a problem creating the Feedingschedule at this time");
		request.getSession().setAttribute("messageClass", "alert-danger");
		
		request.getRequestDispatcher("updateFeedingSchedule.jsp").forward(request, response);

	}
}
}
