package com.examples.ezoo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import com.examples.ezoo.model.*;


import com.examples.ezoo.dao.DAOUtilities;
public  class FeedingscheduleDaoImpl implements FeedingscheduleDAO{
	
	@Override
	public List<Feedingschedule> getsALLfeedingschedule() {
		Connection connection = null;
		Statement stmt = null;
		List<Feedingschedule> schedule = new ArrayList<>();


		try {
			connection = DAOUtilities.getConnection();

			stmt = connection.createStatement();

			String sql = "SELECT * FROM FEEDINGSCHEDULE";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Feedingschedule a = new Feedingschedule();

				a.setID(rs.getLong("ScheduleID"));
				a.setAnimalID(rs.getLong("AnimalID"));
				a.setTime(rs.getString("Time"));

				a.setRecurrence(rs.getString("Recurrence"));
				a.setFood(rs.getString("Food"));
				a.setNotes(rs.getString("Notes"));
				
				
				schedule.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return schedule;
	}

	

	@Override
	public boolean addFeedingschedule(Feedingschedule s) {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = DAOUtilities.getConnection();
			String sql ="INSERT INTO FEEDINGSCHEDULE VALUES (?,?, ?, ?, ?, ?)" ;
			stmt = connection.prepareStatement(sql);
			
			stmt.setLong(1,s.getID());
			stmt.setLong(2,s.getAnimalID());
			stmt.setString(3,s.getTime());
			stmt.setString(4,s.getRecurrence());
			stmt.setString(5,s.getFood());
			stmt.setString(6,s.getNotes());
			
			
			if (stmt.executeUpdate(sql) != 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
	}


	@Override
	public boolean removeFeedingschedule(Feedingschedule s) {
		Connection connection = null;
	PreparedStatement stmt = null;
	try {
		connection = DAOUtilities.getConnection();
		String sql = "DELETE FEEDINGSCHEDULE WHERE ScheduleID=?";
		stmt = connection.prepareStatement(sql);
		
		stmt.setLong(1, s.getID());

		if (stmt.executeUpdate() != 0)
			return true;
		else
			return false;
		
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	} finally {
		closeResources();
	}
}
	

private void closeResources() {
	Connection connection = null;
	PreparedStatement stmt = null;
	try {
		if (stmt != null)
			stmt.close();
	} catch (SQLException e) {
		System.out.println("Could not close statement!");
		e.printStackTrace();
	}
	
	try {
		if (connection != null)
			connection.close();
	} catch (SQLException e) {
		System.out.println("Could not close connection!");
		e.printStackTrace();
	}
}



@Override
public void saveFeedingschedule(Feedingschedule Feedingschedule) throws Exception {
	Connection connection = null;
	PreparedStatement stmt = null;
	int success = 0;

	try {
		connection = DAOUtilities.getConnection();
		String sql = "INSERT INTO FEEDINGSCHEDULE VALUES (?,?,?,?,?,?)";
		stmt = connection.prepareStatement(sql);
		stmt.setLong(1, Feedingschedule.getID());
		stmt.setLong(2, Feedingschedule.getAnimalID());
		stmt.setString(3, Feedingschedule.getTime());

		stmt.setString(4, Feedingschedule.getRecurrence());
		stmt.setString(5, Feedingschedule.getFood());
		stmt.setString(6, Feedingschedule.getNotes());
		
		
		success = stmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (stmt != null)
				stmt.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	if (success == 0) {
		throw new Exception("Insert Feeding schedule failed: " + Feedingschedule);
	}

}


@Override
public Feedingschedule getscheduleByID(long ID) {
	Connection connection = null;
	PreparedStatement stmt = null;
	Feedingschedule schedule=null;
	try {
		connection = DAOUtilities.getConnection();
		String sql = "SELECT * FROM FEEDINGSCHEDULE WHERE ID = ?";
		stmt = connection.prepareStatement(sql);
		
		stmt.setLong(1, ID);
		
		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			schedule = new Feedingschedule();
			schedule.setID(rs.getLong("ID"));
			schedule.setAnimalID(rs.getLong("animalID"));
			schedule.setTime(rs.getString("Time"));
			schedule.setRecurrence(rs.getString("Recurrence"));
			schedule.setFood(rs.getString("Food"));
			schedule.setNotes(rs.getString("Notes"));
	
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		closeResources();
	}
	
	return schedule;
}



@Override
public void deleteFeedingschedule (Feedingschedule Feedingscheduletodelete) throws Exception{ 
Connection connection = null;
	PreparedStatement stmt = null;
	Statement stml=null;
	int success = 0;
	

	try {
		connection = DAOUtilities.getConnection();
		String sql = "DELETE FROM FEEDING_SCHEDULE"+ " WHERE feedingID = ?";
		stmt = connection.prepareStatement(sql);
		stmt.setLong(1,Feedingscheduletodelete.getID());

		success = stmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (stmt != null)
				stmt.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	if (success == 0) {
		throw new Exception("Delete feeding schedule failed: " + Feedingscheduletodelete);
	}

}



@Override
public void updateFeedingSchedule(Feedingschedule FeedingscheduleToUpdate) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE FEEDING_SCHEDULE SET "
					+ " Time = ?, "
					+ " Recurrence = ?, "
					+ " Food = ? ,"
					+ " Notes=?,"
					+ " WHERE ID = ?";
			
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, FeedingscheduleToUpdate.getTime());
			stmt.setString(2, FeedingscheduleToUpdate.getRecurrence());
			stmt.setString(3, FeedingscheduleToUpdate.getFood());
			stmt.setString(4, FeedingscheduleToUpdate.getNotes());

			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (success == 0) {
			throw new Exception("Update feeding schedule failed: " + FeedingscheduleToUpdate);
		}

}



}

