package com.snowshark.MagicPost.errors;

public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException() {
        super();
    }

    public EmployeeNotFoundException(String messege) {
        super(messege);
    }

}
