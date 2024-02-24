package com.driver;

public class Email {

    private final String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {

        return emailId;
    }

    public String getPassword() {

        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password
        // and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if (oldPassword.equals(password)) {
            boolean hasUppercase = false;
            boolean hasLowercase = false;
            boolean hasDigit = false;
            boolean hasSpecialChar = false;

            if (newPassword.length() >= 8) {
                for (char ch : newPassword.toCharArray()) {
                    if (Character.isUpperCase(ch)) {
                        hasUppercase = true;
                    } else if (Character.isLowerCase(ch)) {
                        hasLowercase = true;
                    } else if (Character.isDigit(ch)) {
                        hasDigit = true;
                    } else {
                        hasSpecialChar = true;
                    }
                }
                if (hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
                    password = newPassword;
                }
            }
        }
    }
}
