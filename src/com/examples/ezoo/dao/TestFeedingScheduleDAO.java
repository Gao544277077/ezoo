package com.examples.ezoo.dao;
import com.examples.ezoo.model.*;
import com.examples.ezoo.dao.*;
import java.util.List;
public class TestFeedingScheduleDAO {
	 public static void main(String[] args){
		    FeedingscheduleDAO dao = new FeedingscheduleDaoImpl();
		    List<Feedingschedule> list = dao.getsALLfeedingschedule();

		    for (int i = 0; i < list.size(); i++){
		      Feedingschedule f = list.get(i);
		      System.out.println(f);
		    }
		  }

}
