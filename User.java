package org.telkom.university.code.smell;

import java.time.Year;
import java.util.UUID;
import java.util.regex.Pattern;

public class User {
    private final String userID;
    private String programStudy;
    private String faculty;
    private int enrollmentYear;
    private String email;
    private String password;
    private String userName;
    private String firstName;
    private String lastName;
    private String gender;
    private String studentIdentifierNumber;

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

    public void setSchoolAccount(String email, String password, String userName) throws Exception {
        validateStringInput(email, "Email");
        validateStringInput(password, "Password");
        validateStringInput(userName, "User name");

        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public void setGeneralInformation(String firstName, String lastName, String gender, String studentIdentifierNumber) throws Exception {
        validateStringInput(firstName, "First name");
        validateStringInput(lastName, "Last name");
        validateStringInput(gender, "Gender");
        validateStringInput(studentIdentifierNumber, "Student identifier number");

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.studentIdentifierNumber = studentIdentifierNumber;
    }

    public int calculateEnrollmentYear() {
        int currentYear = Year.now().getValue();
        return currentYear - this.enrollmentYear;
    }

    public boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return email != null && pat.matcher(email).matches();
    }

    public boolean validatePassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

        Pattern pat = Pattern.compile(passwordRegex);
        return password != null && pat.matcher(password).matches();
    }

    public void updateProfile(String firstName, String lastName, String gender, String studentIdentifierNumber,
                              String programStudy, String faculty, int enrollmentYear, String email,
                              String password, String userName) throws Exception {
        if (studentIdentifierNumber.length() != 10 || !isNumeric(studentIdentifierNumber)) {
            throw new Exception("Input is not valid.");
        }

        setGeneralInformation(firstName, lastName, gender, studentIdentifierNumber);
        setSchoolIdentifier(programStudy, faculty, enrollmentYear);
        setSchoolAccount(email, password, userName);
    }

    private void validateStringInput(String value, String fieldName) throws Exception {
        if (value == null || value.isEmpty()) {
            throw new Exception(fieldName + " cannot be null or empty.");
        }
    }

    private void validatePositiveInteger(int value, String fieldName) throws Exception {
        if (value <= 0) {
            throw new Exception(fieldName + " must be a positive integer.");
        }
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}