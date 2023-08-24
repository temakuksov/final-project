package ru.maxima.finalproject.exeptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
            super("Book not found!!!");
    }

}
