package com.cg.test.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cg.test.bean.Questions;
import com.cg.test.bean.Test;
import com.cg.test.bean.User;
import com.cg.test.dao.*;
import com.cg.test.exception.*;
import com.cg.test.main.*;
import com.cg.test.service.*;

public class TestMSServiceImpl implements TestMSService {
	Test onlineTest= new Test();
	private TestDAO tDao;

	public TestMSServiceImpl() {

		tDao = new TestDAOImpl();
		
	}

	

	

	

	public Boolean assignTest(BigInteger userId, BigInteger testId) throws UserException {
		User user = tDao.searchUser(userId);
		Test onlineTest = tDao.searchTest(testId);
		if (user == null) {
			throw new UserException("The user doesnot exist");
		}
		if (onlineTest == null) {
			throw new UserException("Test already assigned or doesnot exist");
		}
		if (onlineTest.getIsTestAssigned()) {
			throw new UserException("Test is already assigned");
		} else {
			user.setUserTest(onlineTest);
			onlineTest.setIsTestAssigned(true);
		}
		tDao.updateTest(onlineTest);
		tDao.updateUser(user);
		return true;
	}

	public boolean validateQuestionTitle(String questionTitle) {
		boolean validateTitle;
		if (questionTitle == null || questionTitle == "")
			validateTitle = false;
		else
			validateTitle = true;
		return validateTitle;

	}

	public boolean validateQuestionOptions(String[] questionOptions) {
		boolean validateOption = false;
		int n = questionOptions.length;
		for (int i = 0; i < n; i++) {
			validateOption = questionOptions[i].isEmpty();
			if (validateOption) {
				break;
			}

		}
		return validateOption;
	}

	public boolean validateQuestionId(long l) {
		String quesId = String.valueOf(l);

		boolean validateId = quesId.matches("[0-9]{2}");
		return validateId;
	}

	// add question

	public Questions addQuestions(int testId, Questions question) throws TestMSException {

		// validating the question id

		boolean validateId = validateQuestionId(question.getQuestionId());
		if (!validateId) {
			throw new TestMSException("Id should be 2 digit");
		}
		// validating the question Title
		boolean validateTitle = validateQuestionTitle(question.getQuestionTitle());

		if (validateTitle) {
			throw new TestMSException("provide the title");
		}

		// validating the options
		boolean validateOption = validateQuestionOptions(question.getQuestionOptions());

		if (validateOption) {
			throw new TestMSException("fill the option field ");

		}

		return tDao.addQuestions(testId, question);

	}
	
  
	public Double getResult(Test onlineTest) throws UserException {
		
			
			calculateTotalMarks(onlineTest);
			onlineTest.setIsTestAssigned(false);
			tDao.updateTest(onlineTest);
			return onlineTest.getTestMarksScored();
		
	}
	public Double calculateTotalMarks(Test onlineTest) throws UserException {
		// TODO Auto-generated method stub
		Double score = new Double(0.0);
		for (Questions question : onlineTest.getTestQuestions()) {
			score = score + question.getMarksScored();
		}
		onlineTest.setTestMarksScored(score);
	tDao.updateTest(onlineTest);
		return score;
	}

	
	
	

	

	
	public void validateQuestionId(BigInteger id) throws UserException {
		if (id.longValue() <= 0) {
			throw new UserException("ID cannot be negative or null");
		}
		
	}

	@Override
	public void validateUserName(String name) throws UserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validatePassword(String password) throws UserException {
		// TODO Auto-generated method stub
		
	}

	
	
	public void validateTestDuration(LocalTime duration, LocalDateTime startDate, LocalDateTime endDate)
			throws UserException {
		// TODO Auto-generated method stub
		long hours = ChronoUnit.HOURS.between(startDate, endDate);
		if (duration.getHour() > hours) {
			throw new UserException("Duration cannot be more than start time and end time");
		
	}}

	@Override
	public User registerUser(User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Questions addQuestions(long testId, Questions question) throws TestMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Questions deleteQuestions(int testId, Questions question) throws TestMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Questions> listQuestion(long testId1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Test> listTest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Questions addQuestion(BigInteger testId, Questions question) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Questions updateQuestion(BigInteger testId, int questionId, Questions question) throws UserException {
	Test temp = tDao.searchTest(testId);
		if (temp != null) {
			Set<Questions> quests = temp.getTestQuestions();
			Questions tempQuestion = tDao.searchQuestion(questionId);
			if (tempQuestion != null && quests.contains(tempQuestion)) {
				quests.remove(tempQuestion);
				quests.add(question);
				question.setChosenAnswer(tempQuestion.getChosenAnswer());
				question.setMarksScored(tempQuestion.getMarksScored());
				question.setTestId(testId);
				question.setQuestionId(questionId);
			tDao.updateQuestion(question);
				temp.setTestTotalMarks(temp.getTestTotalMarks()-tempQuestion.getQuestionMarks() + question.getQuestionMarks());
				tDao.updateTest(temp);
				return question;
			} else
				throw new UserException("Question doesnot exist in Test");
		} else
			throw new UserException("Test already assigned or doesnot exist");
	
	}

	@Override
	public Questions deleteQuestion(BigInteger testId, BigInteger questionId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean answerQuestion(Test onlineTest, Questions question, Integer chosenAnswer) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Questions showQuestion(Test onlineTest, BigInteger questionId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Test addTest(long testId, Questions question) {
		
		Set<Questions> mySet = new HashSet<Questions>();
		onlineTest.setTestQuestions(mySet);
		onlineTest.setIsTestAssigned(false);
		Test returnedTest = null ;
		
		try {
			returnedTest = tDao.saveTest(onlineTest);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (returnedTest == null) {
			System.out.println("Database is full");
		}
		return returnedTest;
	}
		
	

	
	public Test deleteTest(long id, Test test) throws UserException {
		Test returnedTest = tDao.removeTest(test);
		if (returnedTest == null) {
			throw new UserException("Test already assigned or doesnot exist");
		}
		return returnedTest;
	}
	

	@Override
	public List<Questions> listQuestion(int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Test searchTest(long testId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Test updateTest(Test test) throws UserException {
		Test temp = tDao.searchTest(test);
		if (temp != null) {
			onlineTest.setIsTestAssigned(temp.getIsTestAssigned());
			onlineTest.setTestTotalMarks(temp.getTestTotalMarks());
			tDao.updateTest(onlineTest);
			return temp;
		} else
			throw new UserException("Test already assigned or doesnot exist");
	}

		
	

	@Override
	public Questions updateQuestion(BigInteger testId, BigInteger questionId, Questions question) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Test addTest(Test onlineTest) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}







	@Override
	public Test deleteTest(BigInteger testId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}







	
	







	

	

	

	

}
