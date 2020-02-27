package com.cg.test.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import com.cg.test.exception.UserException;

public class Validator {

	public boolean validateTestId(long id) throws UserException {
		if (id <= 0) {
			System.out.println("ID cannot be negative or null");
		
		return false;} 
		else { 
			System.out.println("Successfully validated");
		
		return true;}}
		public boolean validateQuestionId(int id) throws UserException {
			if (id <= 0) {
				System.out.println("ID cannot be negative or null");
				return false;
			}else {
			System.out.println("Successfully validated");
			return true;
}}
		
		public boolean validateQuestionId(long id) throws UserException {
			if (id <= 0) {
				System.out.println("ID cannot be negative or null");
				return false;
			} else { System.out.println("Successfully validated");
			
			
			return true;
		}}
		public boolean validateTestName(String name) throws UserException {
			String pattern = "^[A-Z][A-Za-z 0-9_-]*$";
			if (!(name.matches(pattern) || (name == null))) {
				System.out.println("Only alphabets are allowed and first letter should be capitalised");
				return false;
			}else { System.out.println("\"Successfully validated");
		
			return true;}}
		
		}
		