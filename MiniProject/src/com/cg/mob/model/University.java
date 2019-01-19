package com.cg.mob.model;

import java.time.LocalDate;
import java.util.Date;

public class University {
	private Integer programId;
	private String programName;
	private String programLocation;
	private Date startDate;
	private Date endDate;
	private Integer sessionPerWeek;
	
	public Integer getProgramId() {
		return programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramLocation() {
		return programLocation;
	}

	public void setProgramLocation(String programLocation) {
		this.programLocation = programLocation;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getSessionPerWeek() {
		return sessionPerWeek;
	}

	public void setSessionPerWeek(Integer sessionPerWeek) {
		this.sessionPerWeek = sessionPerWeek;
	}

	public University() {
		super();
		// TODO Auto-generated constructor stub
	}

	public University(Integer programId, String programName,
			String programLocation, Date startDate, Date endDate,
			Integer sessionPerWeek) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.programLocation = programLocation;
		this.startDate = startDate;
		this.endDate = endDate;
		this.sessionPerWeek = sessionPerWeek;
	}
	
	private String fullName;
	private LocalDate dateOfBirth;
	private String highestQualification;
	private Integer marksObtained;
	private String goals;
	private String emailId;
	private Integer id;
	private String status;
	private Date dateOfInterview;

	public University(String fullName, LocalDate dateOfBirth, String highestQualification, Integer marksObtained,
			String goals, String emailId, Integer id, String status, Date dateOfInterview) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.marksObtained = marksObtained;
		this.goals = goals;
		this.emailId = emailId;
		this.id = id;
		this.status = status;
		this.dateOfInterview = dateOfInterview;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public Integer getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(Integer marksObtained) {
		this.marksObtained = marksObtained;
	}

	public String getGoals() {
		return goals;
	}

	public void setGoals(String goals) {
		this.goals = goals;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateOfInterview() {
		return dateOfInterview;
	}

	public void setDateOfInterview(Date dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}

	
		
	
}
