package com.cg.test.bean;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import com.cg.test.bean.Questions;

public class Test implements Serializable {
	static int testId;
	private String testTitle;
	private LocalTime testDuration;
	private Set<Questions> testQuestions;
	private double testTotalMarks;
	private double testMarksScored;
	Questions currentQuestion;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	String delim = System.getProperty("line.separator");
	private Test test;
	private Boolean isTestAssigned;
	
	public Test(int i, String string, int j, String string2) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testQuestions = testQuestions;
		this.testTotalMarks = testTotalMarks;
		this.testMarksScored = testMarksScored;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isTestAssigned = isTestAssigned;
	}

	// TODO Auto-generated constructor stub

	

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return delim + "Test[id=" + testId + ", title=" + testTitle + ", duration=" + testDuration + ",question="
				+ testQuestions + "]";
	}

	public static int getTestId() {
		return testId;
	}

	public static int setTestId(int testId2) {
		return testId2 = testId2;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public static String setTestTitle(String testTitle) {
		return testTitle = testTitle;
	}

	public LocalTime getTestDuration() {
		return testDuration;
	}

	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}

	public Set<Questions> getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(Set<Questions> testQuestions) {
		this.testQuestions = testQuestions;
	}

	public double getTestTotalMarks() {
		return testTotalMarks;
	}

	public static  double setTestTotalMarks(double testTotalMarks) {
		return testTotalMarks = testTotalMarks;
	}

	public double getTestMarksScored() {
		return testMarksScored;
	}

	public void setTestMarksScored(double testMarksScored) {
		this.testMarksScored = testMarksScored;
	}

	public Questions getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(Questions currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public static void setIsTestAssigned(boolean b) {
		// TODO Auto-generated method stub

	}

	

	public static String setQuestionTitle(String testname) {
		// TODO Auto-generated method stub
		return null;
	}

	public static int setTestDuration(int testDuration2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static long getTestId(long testId2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static BigInteger setTestId(long testId2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean getIsTestAssigned() {
		return isTestAssigned;
	}

	public void setIsTestAssigned(Boolean isTestAssigned) {
		this.isTestAssigned = isTestAssigned;
	}

	public String getTestTitle(String testname) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTestDuration(int duration) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTestTotalMarks(double total) {
		// TODO Auto-generated method stub
		return null;
	}
	
	}


