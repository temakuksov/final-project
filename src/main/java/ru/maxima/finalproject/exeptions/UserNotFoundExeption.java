package ru.maxima.finalproject.exeptions;

public class UserNotFoundExeption extends RuntimeException {
    public UserNotFoundExeption() {
        super("User not found!");
    }
}
