package by.academy.it.exceptions;

public class ContentNotFoundException extends IllegalArgumentException{
    public ContentNotFoundException(String message) {
        super(message);
    }
}
