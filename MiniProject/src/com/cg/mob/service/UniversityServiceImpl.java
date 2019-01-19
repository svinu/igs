package com.cg.mob.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.mob.dao.UniversityDao;
import com.cg.mob.dao.UniversityDaoImpl;
import com.cg.mob.exception.MINIException;
import com.cg.mob.model.University;

public class UniversityServiceImpl implements UniversityService {
	UniversityDao universityDao = new UniversityDaoImpl();
	List<String> list = new ArrayList<String>();

	@Override
	public List<University> getAllPrograms() throws MINIException {
		// TODO Auto-generated method stub
		return universityDao.getAllPrograms();
	}

	@Override
	public int applyProgram(University university) throws MINIException {
		// TODO Auto-generated method stub
		return universityDao.applyPrograms(university);
	}

	@Override
	public boolean validateFields(University university) {
		boolean validateFlag = false;
		if (!checkFullName(university.getFullName())) {
			list.add("Name must start with Capital Letter and Max Length should be 20");

		}
		if (!checkQualification(university.getHighestQualification())) {
			list.add("Enter Valid Qualification");

		}
		if (!checkMarks(university.getMarksObtained())) {
			list.add("Enter Valid Marks");

		}
		if (!checkGoals(university.getGoals())) {
			list.add("Enter Valid Goals");

		}
		if (!checkProgramId(university.getId())) {
			list.add("Enter Valid Id");

		}
		if (!checkMailId(university.getEmailId())) {
			list.add("Enter Valid Mail Id");

		}
		if (!list.isEmpty()) {
			System.out.println("In List " + list);

		} else {
			validateFlag = true;
		}

		return validateFlag;
	}

	public boolean checkFullName(String fullName) {
		String nameRegEx = "[A-Z]{1}[A-Za-z\\s]{4,19}$";
		return Pattern.matches(nameRegEx, fullName);
	}

	public boolean checkQualification(String highestQualification) {
		String nameRegEx = "[A-Za-z.\\s]{2,30}$";
		return Pattern.matches(nameRegEx, highestQualification);
	}

	public boolean checkMarks(Integer marks) {
		String nameRegEx = "[0-9]{2,3}$";
		return Pattern.matches(nameRegEx, String.valueOf(marks));
	}

	public boolean checkGoals(String goals) {
		String nameRegEx = "[A-Za-z]*$";
		return Pattern.matches(nameRegEx, goals);
	}

	public boolean checkMailId(String mailId) {
		String nameRegEx = "[A-Za-z0-9_.-]*@[A-Za-z]*\\.[A-Za-z]*$";
		return Pattern.matches(nameRegEx, mailId);
	}

	public boolean checkProgramId(int id) {
		String nameRegEx = "[0-9]{4}$";
		return Pattern.matches(nameRegEx, String.valueOf(id));
	}

	@Override
	public List<University> getEmployeesOnId(int applicationId)
			throws MINIException {
		// TODO Auto-generated method stub
		return universityDao.getEmployeesOnId(applicationId);
	}

}