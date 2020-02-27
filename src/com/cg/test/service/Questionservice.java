package com.cg.test.service;

import com.cg.test.dao.QuestionDAOImpl;
import com.cg.test.dao.QuestionDAO;

public class Questionservice {
	public QuestionDAO questionDAO;
	public Questionservice() {
		questionDAO = new QuestionDAOImpl();

	

}
}