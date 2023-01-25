package org.example.passwordValidatorTest;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator){
//        어떤 값이 String에 저장되어 비밀번호 검증을 거치는지 모르기 때문에 해당 방식은 좋지 않다.
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
//        String randomPassword = randomPasswordGenerator.generatePassword();

        String password = passwordGenerator.generatePassword();

        /*
        * 비밀번호가 최소 8자 이상 12자 이하여야 한다.
        */
        if(password.length() >= 8 && password.length() <= 12){
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
