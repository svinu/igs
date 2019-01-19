package com.cg.mob.dao.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.mob.dao.UniversityDao;
import com.cg.mob.dao.UniversityDaoImpl;
import com.cg.mob.exception.MINIException;
import com.cg.mob.model.University;

public class UniversityDaoImplTest {
	UniversityDao universityDao = null;

	@Before
	public void setUp() throws Exception {
		universityDao = new UniversityDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		universityDao = null;
	}

	@Test
	public void testApplyPrograms() {
		University university = new University();
		university.setFullName("Vinod");
		String string = "12-01-1990";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dob = LocalDate.parse(string, formatter);
		university.setDateOfBirth(dob);
		university.setHighestQualification("BE");
		university.setMarksObtained(90);
		university.setGoals("Goals");
		university.setEmailId("v@g.com");
		university.setId(1002);
		university.setStatus("Confirmed");

		/*
		 * String string1 = "12-01-1990"; DateTimeFormatter formatter1 =
		 * DateTimeFormatter.ofPattern("dd-MM-yyyy"); LocalDate dob1 =
		 * LocalDate.parse(string1, formatter1); university.setDateOfInterview(sysdate);
		 */
		try {
			int rows = universityDao.applyPrograms(university);
			assertEquals(1, rows);
		} catch (MINIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
