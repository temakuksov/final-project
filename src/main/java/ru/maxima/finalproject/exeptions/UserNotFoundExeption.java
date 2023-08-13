package ru.maxima.finalproject.exeptions;

public class UserNotFoundExeption extends RuntimeException {
    public UserNotFoundExeption() {
        super("пользователь не найден!");
    }
}
