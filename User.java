package org.telkom.university.code.smell;

import org.apache.commons.lang3.StringUtils;

import java.time.Year;
import java.util.UUID;
import java.util.regex.Pattern;

public class User {
    private final String userID;
    public User() {

        this.userID = UUID.randomUUID().toString();
    }

    public void setSchoolIdentifier(String programStudy, String faculty, int enrollmentYear) throws Exception {
        validateStringInput(programStudy, "Program study");
        validateStringInput(faculty, "Faculty");
        validatePositiveInteger(enrollmentYear, "Enrollment year");

        this.programStudy = programStudy;
        this.faculty = faculty;
        this.enrollmentYear = enrollmentYear;
    }
        this.programStudy = programStudy;
        this.faculty = programStudy;
        this.enrollmentYear = enrollmentYear;
    }

    public void setSchoolAccount(String email, String password, String userName) throws Exception {
        validateStringInput(email, "Email");
        validateStringInput(password, "Password");
        validateStringInput(userName, "User name");

        this.email = email;
        this.password = password;
        this.userName = userName;
    }


        this.email = email;
        this.password = password;
        this.userName = userName;
    

    public void setGeneralInformation(String firstName, String lastName, String gender, String studentIdentifierNumber) throws Exception {
        throws IllegalArgumentException {
       

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.studentIdentifierNumber = studentIdentifierNumber;
    }
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.studentIdentifierNumber = studentIdentifierNumber;
    }

    public int calculateEnrollmentYear() {
        int currentYears = Year.now().getValue();
        return currentYears - this.enrollmentYear;
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public boolean isStrongPassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        Pattern pat = Pattern.compile(passwordRegex);
        if (password == null)
            return false;
        return pat.matcher(password).matches();
    }

    public void updateProfile(String firstName, String lastName, String gender, String studentIdentifierNumber,
                              String programStudy, String faculty, int enrollmentYear, String email,
                              String password, String userName) throws Exception {

        if(studentIdentifierNumber.length() != 10 || !StringUtils.isNumeric(studentIdentifierNumber)){
            throw new Exception("Input is not valid.");
        }

      
        }