package com.cg.mob.main;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;

import com.cg.mob.exception.MINIException;
import com.cg.mob.model.University;
import com.cg.mob.service.UniversityService;
import com.cg.mob.service.UniversityServiceImpl;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UIClass {
	
	public static void main(String[] args)  {
		PropertyConfigurator.configure("resources/log4j.properties");
		
		
		Scanner scanner = null;
		int ch;
		boolean choiceFlag = false;
		UniversityService service = null;
		University university = null;
		do {
			scanner = new Scanner(System.in);
			System.out.println("UNIVERSITY ADMISSION ");
			System.out.println("1. VIEW");
			System.out.println("2. APPLY");
			System.out.println("3. APPLICATION STATUS");
			System.out.println("Enter Choice");

			ch = scanner.nextInt();
			choiceFlag = true;
			switch (ch) {
			case 1:
				service = new UniversityServiceImpl();

				try {
					List<University> list = service.getAllPrograms();
					if (!list.isEmpty()) {
						System.out.println("PROGRAM ID" + "-----" + "PROGRAM NAME" + "-----" + "PROGRAM LOCATION "
								+ "-----" + "PROGRAM START DATE" + "-----" + "PROGRAM END DATE" + "-----"
								+ "PROGRAM SESSION");
						for (University allUniversity : list) {
							System.out.println(allUniversity.getProgramId() + "    -----"
									+ allUniversity.getProgramName() + "-----" + allUniversity.getProgramLocation()
									+ "-----" + allUniversity.getStartDate() + "-----" + allUniversity.getEndDate()
									+ "-----" + allUniversity.getSessionPerWeek());
						}

					}

				} catch (MINIException e) {
					System.err.println("Exception While Viewing");
				}

				break;
			case 2:
				scanner.nextLine();
				System.out.println("Enter Full Name:");
				String fullName = scanner.nextLine();

				System.out.println("Enter Date Of Birth");
				String dateOfBirth = scanner.nextLine();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				LocalDate dob = LocalDate.parse(dateOfBirth, formatter);

				System.out.println("Enter Highest Qualification:");
				String highestQualification = scanner.nextLine();

				System.out.println("Enter Marks:");
				int marksObtained = scanner.nextInt();
				scanner.nextLine();

				System.out.println("Enter Goals");
				String goals = scanner.nextLine();

				System.out.println("Enter Mail Id:");
				String emailId = scanner.nextLine();

				System.out.println("Enter Id:");
				int id = scanner.nextInt();
				scanner.nextLine();

				System.out.println("Enter Status:");
				String status = scanner.nextLine();

				university = new University();
				university.setFullName(fullName);
				university.setDateOfBirth(dob);
				university.setHighestQualification(highestQualification);
				university.setMarksObtained(marksObtained);
				university.setGoals(goals);
				university.setEmailId(emailId);
				university.setId(id);
				university.setStatus(status);

				service = new UniversityServiceImpl();

				try {
					boolean validateFields = service.validateFields(university);
					if (validateFields) {
						int rows = service.applyProgram(university);
						System.out.println(rows + " rows inserted");
					}

				} catch (MINIException e) {
					System.err.println("Exception While Viewing");
				}

				break;

			case 3:
				System.out.println("Enter Application Id");
				int applicationId = scanner.nextInt();

				service = new UniversityServiceImpl();
				try {
					List<University> list = service.getEmployeesOnId(applicationId);
					for (University university2 : list) {
						System.out.println(university2.getFullName() + "----" + university2.getDateOfBirth() + "----"
								+ university2.getHighestQualification() + "----" + university2.getMarksObtained()
								+ "----" + university2.getGoals() + "----" + university2.getEmailId() + "----"
								+ university2.getId() + "----" + university2.getStatus() + "----"
								+ university2.getDateOfInterview());
					}
				} catch (MINIException e) {
					System.err.println("Exception While Viewing");

				}

				break;

			default:
				choiceFlag = false;
				System.out.println("Select Mentioned Options From 1 to 3");
				System.out.println("Enter Again");

				break;
			}
		} while (!choiceFlag);
		scanner.close();

	}

}
