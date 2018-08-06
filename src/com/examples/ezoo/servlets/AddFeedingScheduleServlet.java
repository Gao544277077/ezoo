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
@WebServlet("/addFeedingSchedule")
public class AddFeedingScheduleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 


@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.getRequestDispatcher("addFeedingschedule.jsp").forward(request, response);
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Get Parameters
	//We MUST convert to a Long since parameters are always Strings
	long ID = Long.parseLong(request.getParameter("ID"));
	long animalID = Long.parseLong(request.getParameter("animalID"));
	String time = request.getParameter("time");
    String recurrence = request.getParameter("recurrence");
	String food = request.getParameter("food");
	String notes = request.getParameter("notes");

	//Create an Animal object from the parameters
	Feedingschedule FeedingscheduleToSave = new Feedingschedule(
			ID, 
			animalID,
			time, 
			recurrence,
			food,
			notes);
	
	//Call DAO method
	FeedingscheduleDAO dao = DAOUtilities.getFeedingscheduleDao();
	try {
		dao.saveFeedingschedule(FeedingscheduleToSave);
		request.getSession().setAttribute("message", "Feedingschedule successfully created");
		request.getSession().setAttribute("messageClass", "alert-success");
		response.sendRedirect("animalCare");


	}catch(SQLIntegrityConstraintViolationException e){
		e.printStackTrace();
		
		//change the message
		request.getSession().setAttribute("message", "Feeding id of " + FeedingscheduleToSave.getAnimalID() + " is already in use");
		request.getSession().setAttribute("messageClass", "alert-danger");
		
		request.getRequestDispatcher("addFeedingschedule.jsp").forward(request, response);
		
	}catch (Exception e){
		e.printStackTrace();
		
		//change the message
		request.getSession().setAttribute("message", "There was a problem creating the Feedingschedule at this time");
		request.getSession().setAttribute("messageClass", "alert-danger");
		
		request.getRequestDispatcher("addFeedingschedule.jsp").forward(request, response);

	}
}
}