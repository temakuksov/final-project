package ru.maxima.finalproject.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
            super("Book not found!!!");
    }

}
