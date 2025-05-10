/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationloginfeature;

import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author RC_Student_lab
 */
//This class handles user registration and login for username,password and cell phone number
public class RegistrationLoginFeature {

    // User details
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String cellphoneNumber;

  
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

 // this method checks if the username is valid contains an underscore and no more than 5 characters long
     
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    
 //this method checks if the password meets the requirements
    
    public boolean checkPasswordComplexity() {
        return Pattern.matches("(?=.[A-Z])(?=.[0-9])(?=.*[^a-zA-Z0-9]).{8,}", password);
    }

  //Assistance with java class structure and validation logic(Claude Ai,2025)
 //this method checks if the cell phone number is valid starts with +27 and is exactly 12 characters long
    
    public boolean checkCellPhoneNumber() {
        return Pattern.matches("\\+27\\d{9}", cellphoneNumber);
    }

//This method returns a message depending on how valid the username, password and cell phone number
    
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain an international code, please correct the number and try again.";
        }

        return "Registration successful!";
    }

     // This method returns checks if the entered details match username and password
    
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    // this method returns login status message
    
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistrationLoginFeature registration = new RegistrationLoginFeature();

        System.out.println("USER REGISTRATION");

        // Username
        System.out.print("Enter username must contain an underscore and be no more than 5 characters");
        registration.setUsername(scanner.nextLine());
        if (registration.checkUserName()) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
            scanner.close();
            return;
        }

        // Password
        System.out.print("Enter password (at least 8 characters with capital letter, number, and special character): ");
        registration.setPassword(scanner.nextLine());
        if (registration.checkPasswordComplexity()) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            scanner.close();
            return;
        }

        // Cell phone
        System.out.print("Enter cell phone number with international code");
        registration.setCellphoneNumber(scanner.nextLine());
        if (registration.checkCellPhoneNumber()) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain an international code, please correct the number and try again.");
            scanner.close();
            return;
        }

        // First and Last name
        System.out.print("Enter your first name: ");
        registration.setFirstName(scanner.nextLine());

        System.out.print("Enter your last name: ");
        registration.setLastName(scanner.nextLine());

        System.out.println("Registration successful!");

        // Login section
        System.out.println("USER LOGIN");
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        System.out.println(registration.returnLoginStatus(loginUsername, loginPassword));

        scanner.close();
    }
}

//References:
//Claude AI. (2025). Assistance with Java class structure and validation logic.
//Accessed via https://claude.ai on 13 April 2025.
