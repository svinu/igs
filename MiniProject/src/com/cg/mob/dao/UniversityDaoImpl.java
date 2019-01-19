package com.cg.mob.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cg.mob.exception.MINIException;
import com.cg.mob.model.University;
import com.cg.mob.utility.JdbcUtility;

public class UniversityDaoImpl implements UniversityDao {
	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	static Logger logger = Logger.getLogger(UniversityDaoImpl.class);

	@Override
	public List<University> getAllPrograms() throws MINIException {
		logger.info("in View method");

		List<University> list = new ArrayList<University>();
		connection = JdbcUtility.getConnection();

		try {
			statement = connection.prepareStatement(QueryMapper.selectAllMobiles);
			logger.info("Statement Object created");
			resultSet = statement.executeQuery();
			logger.info("Execute Query Called");
			while (resultSet.next()) {

				int programId = resultSet.getInt("id");
				String programName = resultSet.getString("program_name");
				String programLocation = resultSet.getString("location");
				Date startDate = resultSet.getDate("start_date");
				Date endDate = resultSet.getDate("end_date");
				int sessionsPerWeek = resultSet.getInt("sessions_per_week");

				University allUniversity = new University();
				allUniversity.setProgramId(programId);
				allUniversity.setProgramName(programName);
				allUniversity.setProgramLocation(programLocation);
				allUniversity.setStartDate(startDate);
				allUniversity.setEndDate(endDate);
				allUniversity.setSessionPerWeek(sessionsPerWeek);
				list.add(allUniversity);

			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			System.out.println("Statement not created");

		} finally {
			logger.error("In Finally Block");

			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MINIException("Problem in closing statement");
			}
			try {
				connection.close();
			} catch (Exception e) {
				logger.error(e.getMessage());
				throw new MINIException("Connection is not closed");
			}
		}

		return list;
	}

	@Override
	public int applyPrograms(University university) throws MINIException {
		logger.info("in Apply for Programs method");
		connection = JdbcUtility.getConnection();
		int output = 0;
		int applicationId = 0;
		int programId, sessionsPerWeek;
		boolean idFlag = false;
		boolean sessionFlag = false;
		try {
			statement = connection.prepareStatement(QueryMapper.selectAllMobiles);
			logger.info("Statement Object created");
			resultSet = statement.executeQuery();
			logger.info("Execute Query Called");
			while (resultSet.next()) {
				programId = resultSet.getInt("id");
				sessionsPerWeek = resultSet.getInt("sessions_per_week");

				if (programId == university.getId()) {
					idFlag = true;
					if (sessionsPerWeek > 0) {
						sessionFlag = true;

						statement = connection.prepareStatement(QueryMapper.insertApplication);
						logger.info("Statement Object created");
						statement.setString(1, university.getFullName());
						LocalDate date = university.getDateOfBirth();
						Date date1 = Date.valueOf(date);
						statement.setDate(2, date1);
						statement.setString(3, university.getHighestQualification());
						statement.setInt(4, university.getMarksObtained());
						statement.setString(5, university.getGoals());
						statement.setString(6, university.getEmailId());
						statement.setInt(7, university.getId());
						statement.setString(8, university.getStatus());
						output = statement.executeUpdate();
						logger.info("Execute Query Called");

						statement = connection.prepareStatement(QueryMapper.getApplicationId);
						logger.info("Statement Object created");
						resultSet = statement.executeQuery();
						logger.info("Execute Query Called");
						resultSet.next();
						applicationId = resultSet.getInt(1);
						System.out.println("Your Application Id " + applicationId);

					}
				}
			}
			if (!idFlag) {
				System.out.println("Enter Id Not Present");
				sessionFlag = true;
			}
			if (!sessionFlag) {
				System.out.println("No sessions is available for entered Id");
			}

		}  catch (SQLException e) {
			logger.error(e.getMessage());
			System.out.println("Statement not created");

		} finally {
			logger.error("In Finally Block");

			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MINIException("Problem in closing statement");
			}
			try {
				connection.close();
			} catch (Exception e) {
				logger.error(e.getMessage());
				throw new MINIException("Connection is not closed");
			}
		}

		return output;
	}

	@Override
	public List<University> getEmployeesOnId(int applicationId) throws MINIException {
		logger.info("in get Employees On id method");
		List<University> list = new ArrayList<University>();
		ResultSet resultSet = null;
		connection = JdbcUtility.getConnection();
		try {
			statement = connection.prepareStatement(QueryMapper.selectOnApplicationId);
			logger.info("Statement Object created");
			statement.setInt(1, applicationId);
			resultSet = statement.executeQuery();
			logger.info("Execute Query Called");
			while (resultSet.next()) {
				String fullName = resultSet.getString("FULL_NAME");
				Date dob = resultSet.getDate("DATE_OF_BIRTH");
				String highestQualification = resultSet.getString("HIGHEST_QUALIFICATION");
				int marksObtained = resultSet.getInt("MARKS_OBTAINED");
				String goals = resultSet.getString("goals");
				String emailId = resultSet.getString("email_Id");
				int programId = resultSet.getInt("id");
				String status = resultSet.getString("status");
				Date dateOfInterview = resultSet.getDate("DATE_OF_INTERVIEW");

				University allUniversity = new University();
				allUniversity.setFullName(fullName);
				LocalDate date = dob.toLocalDate();
				allUniversity.setDateOfBirth(date);
				allUniversity.setHighestQualification(highestQualification);
				allUniversity.setMarksObtained(marksObtained);
				allUniversity.setGoals(goals);
				allUniversity.setEmailId(emailId);
				allUniversity.setId(programId);
				allUniversity.setStatus(status);
				allUniversity.setDateOfInterview(dateOfInterview);
				list.add(allUniversity);

			}
		}  catch (SQLException e) {
			logger.error(e.getMessage());
			System.out.println("Statement not created");

		} finally {
			logger.error("In Finally Block");

			try {
				statement.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());
				throw new MINIException("Problem in closing statement");
			}
			try {
				connection.close();
			} catch (Exception e) {
				logger.error(e.getMessage());
				throw new MINIException("Connection is not closed");
			}
		}

		return list;
	}

}
