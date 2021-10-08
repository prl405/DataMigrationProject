package com.sparta.datamigration.model;

import java.util.regex.Pattern;

public class RegexValidator {
    private Pattern regexName = Pattern.compile("[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");
    private Pattern regexEmail = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    private Pattern regexNamePrefix = Pattern.compile("[A-Za-z.]+");
    private Pattern regexInitial = Pattern.compile("^[A-Z]$");
    private Pattern regexGender = Pattern.compile("^[MF]$");


    public Pattern getRegexName() {
        return regexName;
    }

    public Pattern getRegexEmail() {
        return regexEmail;
    }

    public Pattern getRegexNamePrefix() {
        return regexNamePrefix;
    }

    public Pattern getRegexInitial() {
        return regexInitial;
    }

    public Pattern getRegexGender() {
        return regexGender;
    }
}
