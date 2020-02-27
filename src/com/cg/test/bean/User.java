package com.cg.test.bean;

import java.util.Scanner;

import com.cg.test.dao.TestDAO;
import com.cg.test.dao.TestDAOImpl;

import com.cg.test.service.TestMSService;
import com.cg.test.service.TestMSServiceImpl;

public class User {

	
		private long userid;
		private String userName;
		private  Test userTest;
		private boolean isAdmin;
		 private String userPassword;
			
			
			 TestDAO tDao = new TestDAOImpl();	
			TestMSService testService =  new TestMSServiceImpl();
			
				static Scanner scan= new Scanner(System.in);
				
			
			public User (long userid, Test userTest, String userName, boolean isAdmin, String userPassword) {
				
				this.userName = userName;
				this.userid=userid;
				this.userPassword=userPassword;	
			
			
	}


			public long getUserid() {
				return userid;
			}


			public void setUserid(long userid) {
				this.userid = userid;
			}


			public String getUserName() {
				return userName;
			}


			public void setUserName(String userName) {
				this.userName = userName;
			}


			public Test getUserTest() {
				return userTest;
			}


			public void setUserTest(Test userTest) {
				this.userTest = userTest;
			}


			public boolean isAdmin() {
				return isAdmin;
			}


			public void setAdmin(boolean isAdmin) {
				this.isAdmin = isAdmin;
			}


			public String getUserPassword() {
				return userPassword;
			}


			public void setUserPassword(String userPassword) {
				this.userPassword = userPassword;
			}


			public TestDAO gettDao() {
				return tDao;
			}


			public void settDao(TestDAO tDao) {
				this.tDao = tDao;
			}


			public TestMSService getTestService() {
				return testService;
			}


			public void setTestService(TestMSService testService) {
				this.testService = testService;
			}


			public static Scanner getScan() {
				return scan;
			}


			public static void setScan(Scanner scan) {
				User.scan = scan;
			}


			public boolean getIsAdmin() {
				// TODO Auto-generated method stub
				return false;
			}

}
