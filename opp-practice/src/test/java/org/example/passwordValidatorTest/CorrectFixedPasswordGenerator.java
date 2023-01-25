package org.example.passwordValidatorTest;

public class CorrectFixedPasswordGenerator implements PasswordGenerator {

    @Override
    public String generatePassword() {
        return "abcdefgh"; // 8글자
    }
}
