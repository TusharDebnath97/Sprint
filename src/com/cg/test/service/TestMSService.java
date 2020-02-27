package com.cg.test.service;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.cg.test.bean.Questions;
import com.cg.test.bean.Test;
import com.cg.test.bean.User;
import com.cg.test.exception.TestMSException;
import com.cg.test.exception.UserException;

public interface TestMSService {
	public Questions addQuestions(long testId,Questions question) throws TestMSException;

	public Questions deleteQuestions(int testId,Questions question) throws TestMSException ;
	public List<Questions> listQuestion(long testId1);
	public ArrayList<Test> listTest() ;
	
	public Test addTest(Test onlineTest) throws UserException;
	public static Test updateTest(int updateTestId, Test onlineTest) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}
	public Test deleteTest(BigInteger testId) throws UserException;
	public Questions addQuestion(BigInteger testId, Questions question) throws UserException;
	public Questions updateQuestion(BigInteger testId, BigInteger questionId, Questions question) throws UserException;
	public Questions deleteQuestion(BigInteger testId, BigInteger questionId) throws UserException;
	public User registerUser(User user) throws UserException;
	public Boolean answerQuestion(Test onlineTest, Questions question, Integer chosenAnswer) throws UserException;
	public Questions showQuestion(Test onlineTest, BigInteger questionId) throws UserException;
	public static Boolean assignTest(BigInteger userId, BigInteger testId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}
	public static Double getResult(Test onlineTest) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}
	public Double calculateTotalMarks(Test onlineTest) throws UserException;
	public static Test searchTest(BigInteger testId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}
	public static void validateUserId(BigInteger user_Id) throws UserException {
		// TODO Auto-generated method stub
		
	}
	public static void validateTestId(BigInteger id) throws UserException {
		// TODO Auto-generated method stub
		
	}
	public static void validateQuestionId(int updateQuestionId) throws UserException {
		// TODO Auto-generated method stub
		
	}
	public void validateUserName(String name) throws UserException;
	public void validatePassword(String password) throws UserException;
	public static void validateDate(LocalDateTime startDate, LocalDateTime endDate) throws UserException {
		// TODO Auto-generated method stub
		
	}
	public static void validateTestDuration(LocalTime duration, LocalDateTime startDate, LocalDateTime endDate) throws UserException {
		// TODO Auto-generated method stub
		
	}
	public static void validateEndTime(LocalDateTime endDate) throws UserException {
		// TODO Auto-generated method stub
		
	}

	public Test addTest(long testId, Questions question);

	public Test deleteTest(long id, Test test) throws UserException;

	List<Questions> listQuestion(int testId);

	public Test searchTest(long testId);

	public Test updateTest(Test test) throws UserException;

	public static void validateTestDuration(int duration, LocalDateTime startTime, LocalDateTime endTime) {
		// TODO Auto-generated method stub
		
	}

	public static User searchUser(BigInteger user_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void questionAnswerValidate(Integer updatedQuestionAnswer) {
		// TODO Auto-generated method stub
		
	}

	public static Questions updateQuestion(int updateTestQuestionId, int updateQuestionId, Questions question) {
		// TODO Auto-generated method stub
		return null;
	}

	void validateQuestionId(BigInteger id) throws UserException;

	Questions updateQuestion(BigInteger testId, int questionId, Questions question) throws UserException;
	
	
}
