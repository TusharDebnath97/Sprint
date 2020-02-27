package com.cg.test.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.cg.test.bean.Questions;
import com.cg.test.exception.TestMSException;
import com.cg.test.exception.UserException;
import com.cg.test.bean.Test;
import com.cg.test.bean.User;

public class TestDAOImpl implements TestDAO {
	 private HashMap<Integer, Test> testMap = new HashMap<>();
	 private HashMap<Integer, Questions> testmapq=new HashMap<>();
	 
	 
	 public TestDAOImpl(){
		    
		    
		    }
	 
	
	
	public HashMap<Integer, Test> getMap() {
		// TODO Auto-generated method stub
		return  testMap;
	}


	

	@Override
	public List<Questions> listQuestions(int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Questions addQuestions(int testId, Questions question) throws TestMSException {
		Collection<Questions> qu = testmapq.values();
		List<Questions> list = new ArrayList<>();
		for(Questions Q:qu) {
			list.add(Q);
		}
		return (Questions) list;
		
	}
		
	@Override
	public Questions deleteQuestions(int testId, Questions question) throws TestMSException {
		Collection<Questions> qu = testmapq.values();
		List<Questions> list = new ArrayList<>();
		for(Questions Q:qu) {
			list.remove(Q);
		}
		return (Questions) list;
	}

	
	


	@Override
	public Questions saveQuestion(Questions question) throws UserException {
		
		return null;
	}

	@Override
	public Questions searchQuestion(BigInteger questId) throws UserException {
		
		return null;
	}

	@Override
	public Questions removeQuestion(BigInteger questId) throws UserException {
		
		return null;
	}

	@Override
	public Questions updateQuestion(Questions question) throws UserException {
		
		return null;
	}

	
	
	public Test addTest(Test test) {
		Collection<Test> col = testMap.values();
		List<Test> list = new ArrayList<>();
		for(Test t:col) {
			list.add(t);
		}
		return (Test) list;
		
	}

	@Override
	public Test getTest(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.cg.test.bean.Test saveTest(com.cg.test.bean.Test onlineTest) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.cg.test.bean.Test searchTest(BigInteger testId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.cg.test.bean.Test removeTest(BigInteger testId) throws UserException {
		Collection<Test> col = testMap.values();
		List<Test> list = new ArrayList<>();
		for(Test t:col) {
			list.remove(t);
		}
		return (Test) list;
		
	}

	@Override
	public com.cg.test.bean.User searchUser(BigInteger userId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.cg.test.bean.User saveUser(com.cg.test.bean.User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.cg.test.bean.User removeUser(BigInteger userId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.cg.test.bean.User updateUser(com.cg.test.bean.User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.cg.test.bean.Test updateTest(com.cg.test.bean.Test test) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Questions searchQuestion(int questionId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Test searchTest(Test test) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Test removeTest(Test test) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
