package com.cg.test.main;

import java.math.BigInteger;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.cg.test.bean.Questions;
import com.cg.test.dao.TestDAO;
import com.cg.test.dao.TestDAOImpl;
import com.cg.test.exception.TestMSException;
import com.cg.test.exception.UserException;
import com.cg.test.service.TestMSService;
import com.cg.test.service.TestMSServiceImpl;
import com.cg.test.service.Validator;
import com.cg.test.bean.User;
import com.cg.test.bean.Test;

public class TestMSController {
	public static final String DURATIONMESSAGE = "HH:MM:SS";
	public static final String DATEMESSAGE = "DD-MM-YYYY HH:MM:SS";
	static Validator v= new Validator();

	public static void main(String[] args) throws UserException {
		//TestDAO tDao = new TestDAOImpl();	
		
			TestMSService testService = new TestMSServiceImpl();

			Scanner scanner = new Scanner(System.in);
			

			int choice=0;
			Test test= new Test(choice, null, choice, null);
			Questions question = new Questions(choice, null, choice, choice, choice, choice);
			while(choice!=5)
			{
				System.out.println("1. Add Test");
				System.out.println("2. Update Test");
				System.out.println("3. Delete Test");
				System.out.println("4. Assign Test");
				System.out.println("5. Add Question");
				System.out.println("6. Delete Question");
				System.out.println("7. Update Question");
				System.out.println("8. Check result");
				System.out.println("Enter your choice");
				choice = scanner.nextInt();
				switch(choice)
				{
				case 1:
					
						System.out.println("Enter the test Id");
						
					    int testId=scanner.nextInt();
						long Id = Test.setTestId(testId);
					try {
						if(v.validateTestId(Id)){
						System.out.println("ID cannot be negative or null");}	
						else {
							System.out.println("Successfully validated");
						}
						}
					catch (UserException e3) {
						
						e3.printStackTrace();
					}
						System.out.println("Enter test name");
						String testname= scanner.next();
						try { 
							if(v.validateTestName(testname)) {
								System.out.println("Only alphabets are allowed and first letter should be capitalised");
							
						}else {System.out.println("Successfully validated");
						}}catch (UserException e) {
						}
						
						String title = Test.setTestTitle(testname);
					    System.out.println("Enter test duration");
					    int duration= scanner.nextInt();
					    int testDuration= Test.setTestDuration(duration);					    
					    System.out.println("Enter total marks of the test");
					    double total =scanner.nextInt();
					    double testTotalMarks = Test.setTestTotalMarks(total);
					
					try {
						testService.addTest(test);
					} catch (UserException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					System.out.println("Test added");
					System.out.println("TestId = "+test.getTestId(testId)+" Test Title = "+test.getTestTitle(testname)+" Test Duration = "+test.getTestDuration(duration)+" Test total marks = "+test.getTestTotalMarks(total));
						break;
				case 2:
					System.out.println("Enter the testId to be updated");
					int updateTestId = scanner.nextInt();
					try {
						if(v.validateTestId(updateTestId)){
						System.out.println("ID cannot be negative or null");}	
						else {
							System.out.println("Successfully validated");
						} }catch (UserException e) {
							e.printStackTrace();
						}					
						
					
					System.out.println("Enter OnlineTest Name");
					scanner.nextLine();
					String test_name = scanner.nextLine();
					
					try {
						System.out.println("Enter Test Duration in the format :" + DURATIONMESSAGE );
						
						String durationPattern = scanner.nextLine();
						DateTimeFormatter durationFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
						LocalTime duration1 = LocalTime.parse(durationPattern, durationFormatter);
						System.out.println("Enter Start Time in the Format : "+DATEMESSAGE);
						scanner.nextLine();
						String startPattern = scanner.nextLine();
						DateTimeFormatter startTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
						LocalDateTime startTime = LocalDateTime.parse(startPattern, startTimeFormatter);
						System.out.println("Enter End Time in the Format : "+DATEMESSAGE);
						String endPattern = scanner.nextLine();
						DateTimeFormatter endTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
						LocalDateTime endTime = LocalDateTime.parse(endPattern, endTimeFormatter);
	
						TestMSService.validateDate(startTime, endTime);
						TestMSService.validateEndTime(endTime);
						TestMSService.validateTestDuration(duration1, startTime, endTime);
						Test onlineTest = new Test();
						onlineTest.setTestId(updateTestId);
						onlineTest.setTestTitle(test_name);
						onlineTest.setTestDuration(duration1);
						onlineTest.setStartTime(startTime);
						onlineTest.setEndTime(endTime);
						onlineTest.setTestMarksScored(0.0);
						Test updatedTest;
						try {
							updatedTest = TestMSService.updateTest(updateTestId, onlineTest);
							if (updatedTest != null) {
								System.out.println("OnlineTest Updated Successfully!");
							} else {
								System.out.println("OnlineTest cannot be Updated!");
							}}
						 catch (UserException e) {
							
						}
					
					 catch (DateTimeException exception) {
						System.out.println("Invaid Date");
					}	}		
			
		        catch (InputMismatchException e) {
			    System.out.println("Invalid input");
	         	}	finally {
	         		System.out.println("Out of block");
	         	}
		          break;	
		
		
				case 3: 
					System.out.println("Enter the test Id");
				    long testId1=scanner.nextInt();
					long id = Test.getTestId(testId1);
					try {
						testService.deleteTest(id, test);
					} catch (UserException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(Test.getTestId()+" is deleted");
					break;
				case 4:
					System.out.println("Enter User Id");
					try {
						BigInteger user_Id = scanner.nextBigInteger();
						try {
							TestMSService.validateUserId(user_Id);
						} catch (UserException e) {
							
						}
						User assignUser = TestMSService.searchUser(user_Id);
						if (assignUser != null && assignUser.getIsAdmin()) {
							System.out.println("Enter the User Id to whom test is to be assigned");
							BigInteger userTestId = scanner.nextBigInteger();
							try {
								TestMSService.validateUserId(userTestId);
							} catch (UserException e) {
								
								
							}
							System.out.println("Enter the OnlineTest Id of the test to be alloted");
							BigInteger testUserId = scanner.nextBigInteger();
							try {
								TestMSService.validateTestId(testUserId);
							} catch (UserException e) {
								// TODO Auto-generated catch block
								// System.out.println(e.getMessage());
								
							}
							Boolean assign = false;
							try {
								Test test1 = TestMSService.searchTest(testUserId);
								if (test1.getIsTestAssigned()==null ) {
									test1.setIsTestAssigned(false);
								}
								assign = TestMSService.assignTest(userTestId, testUserId);
							} catch (UserException e) {
								// TODO Auto-generated catch block
								// System.out.println(e.getMessage());
								
							}
							if (assign) {
								System.out.println("OnlineTest assigned to User Successfully!");
							} else {
								System.out.println("OnlineTest could not be assigned to the User");
							}
						} else {
							System.out.println("Not allowed to perform this action");
						}
					} catch (InputMismatchException e) {
						System.out.println("Invalid Input");
					}
					
				case 5:
					System.out.println("Enter the test Id");
					 testId =scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the question id");
					int questionId = scanner.nextInt();

					scanner.nextLine();

					System.out.println("Enter the Questin title");
					String name =scanner.nextLine();
					System.out.println("enter the question options");
					String options[] = new String[4];
					for(int i=0;i<4;i++)
					{
						options[i]=scanner.nextLine();
					}
					System.out.println("Enter the question answer");
					int questionAnswer=scanner.nextInt();
					System.out.println("Enter the Question marks");
					double questionMarks=scanner.nextDouble();
					int Id1 = question.setQuestionId(questionId);
					String title1 = question.setQuestionTitle(name);
					String []option = (String[]) question.setQuestionOptions(options);
					int answer = question.setQuestionAnswer(questionAnswer);
					double marks = question.setQuestionMarks(questionMarks);
					try
					{
						testService.addQuestions(testId,question);
						System.out.println("Question added");
						System.out.println("QuestionId = "+question.getQuestionId()+" Question Title = "+question.getQuestionTitle()+" Question Answer = "+question.getQuestionAnswer()+" Question Marks = "+question.getQuestionMarks());
					}
					catch(TestMSException e)
					{
						System.err.println(e.getMessage());
					}
					break;


					
					
				case 6:
					System.out.println("Enter the testId Id");
					int id3=scanner.nextInt();
					System.out.println("Enter the question id");
					int questionid = scanner.nextInt();
					int Id2 = question.setQuestionId(questionid);
					try {
						testService.deleteQuestions(id3, question);
						System.out.println(question.getQuestionId()+" is deleted");
					} catch (TestMSException e) {
						System.err.println(e.getMessage());
					}
					break;
					
					
				case 7: 					
					System.out.println("Enter Question Id to be updated");
					int updateQuestionId = scanner.nextInt();
					int updateTestQuestionId = scanner.nextInt();
					try {
						TestMSService.validateQuestionId(updateQuestionId);
					} catch (UserException e) {
						
					}
					System.out.println("Enter the updated Question Title");
					scanner.nextLine();
					String updatedQuestionTitle = scanner.nextLine();
					System.out.println("Enter the updated Question Options");
					String updatedQuestionOptions[] = new String[4];
					for (int i = 0; i < 4; i++) {
						updatedQuestionOptions[i] = scanner.next();
					}
					System.out.println("Enter the updated Question Answer");
					Integer updatedQuestionAnswer = scanner.nextInt();
					TestMSService.questionAnswerValidate(updatedQuestionAnswer);
					System.out.println("Enter the updated Question Marks");
					Double updatedQuestionMarks = scanner.nextDouble();
					Questions question1 = new Questions();
					question.setQuestionOptions(updatedQuestionOptions);
					question.setQuestionTitle(updatedQuestionTitle);
					question.setQuestionAnswer(updatedQuestionAnswer - 1);
					question.setQuestionMarks(updatedQuestionMarks);
					Questions updatedQuestion;
					try {
						updatedQuestion = TestMSService.updateQuestion(updateTestQuestionId, updateQuestionId, question);
						if (updatedQuestion != null) {
							System.out.println("Question Updated Successfully!");
						} else {
							System.out.println("Question could not be Updated!");
						}
					} catch (InputMismatchException e) {
				
			}
					
				case 8: System.out.println("Enter OnlineTest Id for which the result is to be checked");
				try {
					BigInteger resultTestId = scanner.nextBigInteger();
					try {
						TestMSService.validateTestId(resultTestId);
					} catch (UserException e) {
						e.printStackTrace();
					}
					Test resultTest = TestMSService.searchTest(resultTestId);
					if (resultTest != null) {
						Double marksScored = TestMSService.getResult(resultTest);
						System.out.println("The Marks Scored are " + marksScored);
					} else {
						System.out.println("The test does not exist!");
					}
				} catch (InputMismatchException | UserException e) {
					System.out.println("INVALID INPUT");
				}
				case 9: System.out.println("Thank you");
				return; 
				
			} 
				
					}}}
