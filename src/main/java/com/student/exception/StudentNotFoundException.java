package com.student.exception;
/**
 * @author Simpson Alfred
 */

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
