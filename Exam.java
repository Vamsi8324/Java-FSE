package com.console.exam;

import java.util.Scanner;

public class Exam {
		public static void main(String[] args) {
			Question[] questions = new Question[10];
			questions[0] = new Question(1, "Number of primitive data types in Java are?", "6", "7", "8", "9", 'C');
			questions[1] = new Question(1, "What is the size of float and double in java?", "32 & 64", "32 & 32", "64 & 64",
					"64 & 32", 'A');
			questions[2] = new Question(1, "Automatic type conversion is possible in which of the possible cases?",
					"Byte to int", "int to long", "long to int", "short to int", 'B');
			questions[3] = new Question(1, "Arrays in java are-", "Object references", "Objects", "Primitive data type",
					"none", 'B');
			questions[4] = new Question(1, "When is the object created with new keyword?", "At run time", "At compile time",
					"depends on the code", "None", 'A');
			questions[5] = new Question(1,
					"Identify the keyword among the following that makes a variable belong to a class,"
							+ "rather than being defined for each instance of the class." + "",
					"final", "static", "volatile", "abstract", 'B');
			questions[6] = new Question(1, "\r\n" + "In which of the following is toString() method defined?",
					"java.lang.Object", "java.lang.String", "java.lang.Util", "None", 'A');
			questions[7] = new Question(1, "compareTo() returns", "True", "False", "An int value", "None", 'C');
			questions[8] = new Question(1, "To which of the following does the class string belong to.", "java.lang",
					"ava.awt", "java.applet", "java.string", 'A');
			questions[9] = new Question(1, "Total constructor string class have?", "3", "7", "13", "20", 'C');

			Scanner sc = new Scanner(System.in);
			System.out.println("Welcome to Exam! Are you Ready? (y-start,n-stop)");
			char c = sc.next().toUpperCase().charAt(0);
			if (c == 'Y') {
				for (int i = 0; i < questions.length; i++) {
					Question q = questions[i];
					char rightAnswer = q.getRightOption();
					System.out.println(i + 1 + ":" + q.getQuestion());
					System.out.println("A:" + q.getOption1() + "          " + "B:" + q.getOption2());
					System.out.println("C:" + q.getOption3() + "          " + "D:" + q.getOption4());
					char answer = sc.next().toUpperCase().charAt(0);
					if(answer == rightAnswer) {
						System.out.println("It is right!");
						continue;
					} else {
						System.out.println("Your answer is not correct!");
						System.out.println("Do you want to try again? (y-yes,n-no)");
						answer = sc.next().toUpperCase().charAt(0);
						if(answer == 'Y') {
							i--;
						}
						else {
							continue;
						}
					}
				}
			} else {
				System.out.println("Thank you!");
			}
		}
	}

