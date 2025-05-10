/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registrationloginfeature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
class RegistrationLoginFeatureTest {

    private RegistrationLoginFeature feature;


    // -----------------------------
    // USERNAME TESTS
    // -----------------------------

    @Test
    void testValidUsername() {
        feature.setUsername("ab_c");
        assertTrue(feature.checkUserName());
    }

    @Test
    void testInvalidUsername() {
        feature.setUsername("abcde123"); // no underscore, too long
        assertFalse(feature.checkUserName());
    }

    // -----------------------------
    // PASSWORD TESTS
    // -----------------------------

    @Test
    void testValidPassword() {
        feature.setPassword("Ch@nge123");
        assertTrue(feature.checkPasswordComplexity());
    }

    @Test
    void testInvalidPassword() {
        feature.setPassword("password"); // lacks complexity
        assertFalse(feature.checkPasswordComplexity());
    }

    // CELL NUMBER TESTS
   
    @Test
    void testValidCellNumber() {
        feature.setCellphoneNumber("+27835555999");
        assertTrue(feature.checkCellPhoneNumber());
    }

    @Test
    void testInvalidCellNumber() {
        feature.setCellphoneNumber("0839555999"); // no +27
        assertFalse(feature.checkCellPhoneNumber());
    }

    // REGISTRATION TESTS

    @Test
    void testRegistrationSuccessMessage() {
        feature.setUsername("ab_c");
        feature.setPassword("Abc@1234");
        feature.setCellphoneNumber("+27831112222");
        assertEquals("Registration successful!", feature.registerUser());
    }

    @Test
    void testRegistrationInvalidUsernameMessage() {
        feature.setUsername("abcde"); // no underscore
        feature.setPassword("Abc@1234");
        feature.setCellphoneNumber("+27831112222");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", feature.registerUser());
    }

    @Test
    void testRegistrationInvalidPasswordMessage() {
        feature.setUsername("ab_c");
        feature.setPassword("password");
        feature.setCellphoneNumber("+27831112222");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", feature.registerUser());
    }

    @Test
    void testRegistrationInvalidCellNumberMessage() {
        feature.setUsername("ab_c");
        feature.setPassword("Abc@1234");
        feature.setCellphoneNumber("0835551234");
        assertEquals("Cell phone number incorrectly formatted or does not contain an international code, please correct the number and try again.", feature.registerUser());
    }

    
    // LOGIN TEST

    @Test
    void testLoginSuccess() {
        feature.setUsername("ab_c");
        feature.setPassword("Abc@1234");
        feature.setFirstName("John");
        feature.setLastName("Doe");

        assertEquals("Welcome John Doe, it is great to see you again.",
                feature.returnLoginStatus("ab_c", "Abc@1234"));
    }

    @Test
    void testLoginFailed() {
        feature.setUsername("ab_c");
        feature.setPassword("Abc@1234");

        assertEquals("Username or password incorrect, please try again.",
                feature.returnLoginStatus("wrong", "wrong"));
    }
}