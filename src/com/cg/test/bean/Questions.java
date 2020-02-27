package com.cg.test.bean;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;

public class Questions {
	 long questionId;
	 String []questionOptions = new String[4];;
	 String questionTitle;
	 int questionAnswer;
	double questionMarks ;
	int chosenAnswer;
	double marksScored;
	public Questions(long questionId, String questionTitle, int questionAnswer,
			double questionMarks, int chosenAnswer, double marksScored) {
		super();
		this.questionId = questionId;

		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = chosenAnswer;
		this.marksScored = marksScored;
	}
	public Questions() {
		// TODO Auto-generated constructor stub
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String[] getQuestionOptions() {
		return questionOptions;
	}
	public String[] setQuestionOptions(String[] questionOptions) {
		return this.questionOptions = questionOptions;

	}
	public int getQuestionAnswer() {
		return questionAnswer;
	}
	public int setQuestionAnswer(int questionAnswer) {
		return this.questionAnswer = questionAnswer;
	}
	public double getQuestionMarks() {
		return questionMarks;
	}
	public double setQuestionMarks(double questionMarks) {
		return this.questionMarks = questionMarks;
	}
	public int getChosenAnswer() {
		return chosenAnswer;
	}
	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}
	public double getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(double marksScored) {
		this.marksScored = marksScored;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public int setQuestionId(int questionId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String setQuestionTitle(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	public void setTestId(BigInteger testId) {
		// TODO Auto-generated method stub
		
	}
	
	
}
