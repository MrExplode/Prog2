package me.sunstorm.zhgyak.exceptions;

public class MediaNotFoundException extends RuntimeException {

    public MediaNotFoundException(String name) {
        super("Media not found: " + name);
    }
}
