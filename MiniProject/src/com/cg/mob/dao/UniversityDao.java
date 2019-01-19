package com.cg.mob.dao;

import java.util.List;

import com.cg.mob.exception.MINIException;
import com.cg.mob.model.University;

public interface UniversityDao {

	List<University> getAllPrograms() throws MINIException;

	int applyPrograms(University university) throws MINIException;

	List<University> getEmployeesOnId(int applicationId) throws MINIException;

}
