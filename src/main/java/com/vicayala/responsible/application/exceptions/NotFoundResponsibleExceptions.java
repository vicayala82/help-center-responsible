package com.vicayala.responsible.application.exceptions;

public class NotFoundResponsibleExceptions extends RuntimeException{

    private static final String ERROR_MESSAGE = "Responsible Not Found";
    public NotFoundResponsibleExceptions(){
        super(ERROR_MESSAGE);
    }
}
