package com.examples.ezoo.model;

public class Feedingschedule {
	private long ID = 0L;
	private long animalID;
	private String time = "";
	private String recurrence = "";
	private String food = "";
	private String notes = "";

public Feedingschedule(){
	
}

public Feedingschedule(long ID,long animalID, String time, String recurrence, String food, String notes) {
	super();
	this.animalID = animalID;
	this.ID = ID;
	this.time = time;
	this.recurrence = recurrence;
	this.food = food;
	this.notes = notes;
}

public long getID() {
	return ID;
}

public void setID(long ID) {
	this.ID = ID;
}
public long getAnimalID() {
	return animalID;
}

public void setAnimalID(long animalID) {
	this.animalID = animalID;
}
public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}

public String getRecurrence() {
	return recurrence;
}

public void setRecurrence(String recurrence) {
	this.recurrence = recurrence;
}

public String getFood() {
	return food;
}
public void setFood(String food) {
	this.food = food;
}
public String getNotes() {
	return notes;
}
public void setNotes(String notes) {
	this.notes = notes;
}

@Override
public String toString() {
	return "Animal [ID=" + ID + ",AnimalID=" + animalID +", Time=" + time + ", food=" + food + ", taxKingdom=" + recurrence + ", taxPhylum="
			+ notes +"]";
}
public void add(Feedingschedule schedule) {
	// TODO Auto-generated method stub
}
}