package com.examples.ezoo.dao;

import java.util.List;
import java.util.ArrayList;

import com.examples.ezoo.model.Feedingschedule;


public interface FeedingscheduleDAO {
	
	public List<Feedingschedule> getsALLfeedingschedule();

	public boolean addFeedingschedule(Feedingschedule s);
	public boolean removeFeedingschedule(Feedingschedule s);
	public boolean updateFeedingschedule(Feedingschedule s);
	public Feedingschedule getscheduleByID(long ID);
	void saveFeedingschedule(Feedingschedule FeedingscheduleToSave) throws Exception;
    void deleteFeedingschedule(Feedingschedule FeedingscheduleToDelete) throws Exception; 
    void updateFeedingSchedule(Feedingschedule FeedingscheduleToUpdate) throws Exception;
}
