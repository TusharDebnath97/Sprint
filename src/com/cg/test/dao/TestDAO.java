package com.cg.test.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.cg.test.bean.Questions;
import com.cg.test.exception.TestMSException;
import com.cg.test.exception.UserException;
import com.cg.test.bean.Test;
import com.cg.test.bean.User;

public interface TestDAO {
	Test addTest(Test test);

	Test getTest(int id);

	List<Questions> listQuestions(int testId);

	public Test saveTest(Test onlineTest) throws UserException;
	public Test searchTest(Test test) throws UserException;
	public Test removeTest(Test test) throws UserException;
	public Questions saveQuestion(Questions question) throws UserException;
	public Questions searchQuestion(int questionId) throws UserException;
	public Questions removeQuestion(BigInteger questId) throws UserException;
	public Questions updateQuestion(Questions question) throws UserException;
	public User searchUser(BigInteger userId) throws UserException;
	public User saveUser(User user) throws UserException;	
	public User removeUser(BigInteger userId) throws UserException;
	public User updateUser(User user) throws UserException;
	Test updateTest(Test test) throws UserException;

	public Questions addQuestions(int testId,Questions question) throws TestMSException;

	public Questions deleteQuestions(int testId,Questions question) throws TestMSException ;

	Questions searchQuestion(BigInteger questId) throws UserException;

	Test searchTest(BigInteger testId) throws UserException;

	Test removeTest(BigInteger testId) throws UserException;
}
