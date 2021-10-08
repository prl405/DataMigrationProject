package com.sparta.datamigrationtests;

import com.sparta.datamigration.model.RegexValidator;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeTests {
    TestVariables testVariables = new TestVariables();
    RegexValidator regexPatterns = new RegexValidator();

    @Test
    public void givenNumbers_ReturnFalseName(){
        Matcher firstNameMatcher = regexPatterns.getRegexName().matcher(testVariables.NUMBERS);
        Matcher lastNameMatcher = regexPatterns.getRegexName().matcher(testVariables.NUMBERS);
        assertTrue(!firstNameMatcher.find() || !lastNameMatcher.find());
    }

    @Test
    public void givenLetters_ReturnTrueName(){
        Matcher firstNameMatcher = regexPatterns.getRegexName().matcher(testVariables.ALPHABET);
        Matcher lastNameMatcher = regexPatterns.getRegexName().matcher(testVariables.ALPHABET);
        assertTrue(firstNameMatcher.find() || lastNameMatcher.find());
    }

    @Test
    public void givenNumbersAndLetters_ReturnFalseName(){
        Matcher firstNameMatcher = regexPatterns.getRegexName().matcher(testVariables.NUMBERS_LETTERS);
        Matcher lastNameMatcher = regexPatterns.getRegexName().matcher(testVariables.NUMBERS_LETTERS);
        assertTrue(!firstNameMatcher.find() || lastNameMatcher.find());
    }
}
