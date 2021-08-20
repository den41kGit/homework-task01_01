package com.den.javacourseV2.user;

public interface UserService {
    boolean checkName(String inputStr);
    boolean containsInDataBase(String name);
    String[] parseUser(String stringToProcess);
    void displayId(String name);
    void saveUser(User user);

}
