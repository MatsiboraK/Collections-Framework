package ru.netology.javaqa;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Player with this name: " + name + "not exists! You need to register");
    }
}
